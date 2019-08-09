package com.ps.service;

import com.ps.mapper.SupperMapper;
import com.ps.service.context.QdetailInterface;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class Qdetailservice implements QdetailInterface {
    @Autowired
    private SupperMapper supperMapper;

    @Override
    public void add(int id, int num, String question) {
        supperMapper.addQdetail(id,num,question);
    }
}
