package com.ps.service;

import com.ps.TestUtil;
import com.ps.mapper.SupperMapper;
import com.ps.service.context.QuestionnaireInterface;
import com.ps.service.core.MemberInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service(version = "1.0.0")
public class Questionnaireservice implements QuestionnaireInterface {
   @Autowired
    private SupperMapper supperMapper;

    @Reference(version = "1.0.0")
    private MemberInterface memberInterface;


    @Override
    public void add(String project, int integral) {
        supperMapper.add(project,integral);
    }

    @KafkaListener(topics = "panshi")
    public void  send(ConsumerRecord<?, ?> cr) throws Exception{
        System.out.println(cr.value());
        String j= (String) cr.value();
        System.out.println("String "+j);
        int b = Integer.parseInt(j);
        System.out.println("int "+b);
        String format = "yyyy-MM-dd";//"HH:mm:ss";
        Date date=new Date();
        Date startTime = new SimpleDateFormat(format).parse("2019-7-20");
        Date endTime = new SimpleDateFormat(format).parse("2019-8-20");

          if("self".equals(cr.key()) && true){
              memberInterface.update(b  ,100);
          }else if("ecod".equals(cr.key()) && true){
              boolean bool =TestUtil.isEffectiveDate(date,startTime,endTime);
              if(bool){
                memberInterface.update(b  ,100);
            }


          }


    }

    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
    }
}
