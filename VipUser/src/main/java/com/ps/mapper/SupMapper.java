package com.ps.mapper;

import com.ps.domain.core.QasysMemberT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SupMapper {
    //注册



     void adduser(String username,String password);
    //查询积分
     QasysMemberT query(String username);

     //增加一个问题
    void addQuestion(int mid, String question, int integral);


    void updatejian(int aa, int ss);

    void updatejia(int mid,int ss);

    void addshu(int mid, int ss, int i);

}
