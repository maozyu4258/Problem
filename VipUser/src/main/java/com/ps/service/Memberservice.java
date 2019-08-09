package com.ps.service;

import com.ps.domain.core.QasysMemberT;
import com.ps.mapper.SupMapper;
import com.ps.service.core.MemberInterface;
import org.apache.dubbo.config.annotation.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service(version = "1.0.0")
public class Memberservice implements MemberInterface {

    @Autowired
    private SupMapper superMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public int query(String username) {
        return 0;
    }

    @Override
    public QasysMemberT querya(String username) {
        return superMapper.query(username);
    }



    @Override//减积分
    public void update(int aa, int ss) {
        int i =2;
        superMapper.updatejian(aa,ss);
        superMapper.addshu(aa,ss,i);
    }

    @Override
    public void updatejia(int mid,int ss) {
        int i=1;
        superMapper.updatejia(mid,ss);
        superMapper.addshu(mid,ss,i);
    }
    @Override
    @KafkaListener(topics = "panshi")
    public void add(String username, String password,String codes) {
        superMapper.adduser(username,password);
        System.out.println("username:  "+username);
        QasysMemberT qasysMemberT= superMapper.query(username);
        int s= (int) qasysMemberT.getId();
        String mid=String.valueOf(s);
        System.out.println(mid);

        kafkaTemplate.send("panshi","self",mid);

    }

    @KafkaListener(topics = "newss")
    public void tuikuang(ConsumerRecord<?, ?> cr) {
        String mids= (String) cr.key();
        int mid = Integer.parseInt(mids);
        String jf= (String) cr.value();
        int ss = Integer.parseInt(jf);

        System.out.println(ss+"---0---"+mid);
        int i=1;
        superMapper.updatejia(mid,ss);
        superMapper.addshu(mid,ss,i);
    }
}
