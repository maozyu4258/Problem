package com.ps.service;

import com.ps.domain.core.QasysOrderT;
import com.ps.mapper.SupperMapper;
import com.ps.service.core.Order;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class Orderservice implements Order {
    @Autowired
    private SupperMapper supperMapper;


    @Override
    public void update(int userid, int id) {
        supperMapper.orderupdate(userid,id);
    }

    @Override
    public QasysOrderT query(int userid, int id) {

        return  supperMapper.orederquery(userid,id);
    }
}
