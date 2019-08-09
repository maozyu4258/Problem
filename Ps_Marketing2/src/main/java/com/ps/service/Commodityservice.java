package com.ps.service;

import com.alibaba.fastjson.JSON;
import com.ps.TestUtil;
import com.ps.domain.ResultVo;
import com.ps.domain.core.QasysCommodityT;
import com.ps.domain.core.QasysMemberT;
import com.ps.domain.core.QasysOrderT;
import com.ps.mapper.SupperMapper;
import com.ps.service.core.Commodity;
import com.ps.service.core.MemberInterface;
import com.ps.service.core.Order;
import javafx.beans.property.ReadOnlyStringProperty;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0")
public class Commodityservice implements Commodity {
     @Autowired
     private SupperMapper supperMapper;

     @Autowired
     private KafkaTemplate<String, String> kafkaTemplate;

     @Reference(version = "1.0.0",check = false)
     private MemberInterface memberInterface;

     @Reference(version = "1.0.0",check = false)
     private Order order;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

     private  ResultVo resultVo =new ResultVo();

     //定时任务
     public  void  dingshi(){
         ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
         String s = listOperations.leftPop("active:exChange");
         Long size = listOperations.size("active:exChange");
         System.out.println(size);
     }
     //线程
    public void  duoxianchen(){
        /*executorService.submit(() -> {

        });*/
    }


    @Override
    @KafkaListener(topics = "newss")
    @Transactional
    public ResultVo add(String username, int id) throws InterruptedException {



        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String key = "visitor"+username;
        String visitor= stringStringValueOperations.get(key);

        if(visitor ==null){
            // 1. 排队
            boolean res = addQueue(username);
            if(res){
                // 排队成功
                stringRedisTemplate.opsForValue().set("active:kill:" + username, "2", 1, TimeUnit.DAYS);
                visitor="2";

            } else {
                // 排队失败
                stringRedisTemplate.opsForValue().set("active:kill:" + username, "1", 1, TimeUnit.SECONDS);
                visitor="1";
            }
        }
        if(visitor.equals("2")) {
            // 排队成功
            resultVo.setMsg("排队成功");
            return resultVo;
        }


        if(visitor.equals("1")) {
            System.out.println("------->有此用户");
            resultVo.setMsg("当前人数过多");
            return resultVo;
        }

        System.out.println("------------>正常访问");
        stringStringValueOperations.set(key,username,2, TimeUnit.MINUTES);
        QasysMemberT qasysMemberT=memberInterface.querya(username);
        QasysCommodityT qasysCommodityT=supperMapper.shopquery(id);
        Thread.sleep(10000);
        int userid = (int) qasysMemberT.getId();

        if (qasysCommodityT==null){
            resultVo.setCode(100);
            resultVo.setMsg("没有次商品");
            return resultVo;
        }else if(qasysMemberT == null){
            resultVo.setCode(100);
            resultVo.setMsg("没有次用户");
            return resultVo;
        }
         String num=qasysCommodityT.getValue();
        if(num.equals("0")){
            resultVo.setCode(100);
            resultVo.setMsg("商品已经没有了");
            return resultVo;
        }

        Date dates= qasysCommodityT.getStartTime();
        Date datess=qasysCommodityT.getEndTime();
        Date date=new Date();
        boolean bool = TestUtil.isEffectiveDate(date,dates,datess);
        if(bool==false){
            resultVo.setCode(100);
            resultVo.setMsg("商品已过期");
            return resultVo;
        }

        int jf= (int) qasysMemberT.getIntegral();
        int shopjf= (int) qasysCommodityT.getExchangeIntegral();
        if(jf<=shopjf){
            resultVo.setCode(100);
            resultVo.setMsg("积分不够");
            return resultVo;
        }
     /*   QasysOrderT user=order.query(userid,id);
        if(user!=null){
            resultVo.setCode(100);
            resultVo.setMsg("你已经购买此商品了，不可再买");
            return resultVo;
        }*/
        memberInterface.update(userid,shopjf);
        //商品数量减一，
        supperMapper.update(id);
        if(num.equals("0")){
            String mid=userid+"";
            String ss=id+"";
            kafkaTemplate.send("news",mid,ss);
            throw new RuntimeException("没有了");
        }

        //用户减积分

        //订单表加记录
        order.update(userid,id);

        resultVo.setMsg("恭喜你，成功购买此商品");
        resultVo.setCode(200);
        return resultVo;

    }
    private boolean addQueue(String username) {
        long size = stringRedisTemplate.opsForList().size("active:exChange");
        if(size >= 10000) {
            return false;
        }
        stringRedisTemplate.opsForList().leftPush("active:exChange", username.toString()); // 返回值的判断

        return true;
    }
}
