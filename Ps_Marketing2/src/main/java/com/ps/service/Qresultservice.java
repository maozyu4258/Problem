package com.ps.service;

import com.ps.mapper.SupperMapper;
import com.ps.service.context.QresultInterface;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(version = "1.0.0")
public class Qresultservice implements QresultInterface {
    @Autowired
    private SupperMapper supperMapper;


    @Override
    public void add(int mid, int id, String result) {
        supperMapper.addqresult(mid,id,result);
    }
}
