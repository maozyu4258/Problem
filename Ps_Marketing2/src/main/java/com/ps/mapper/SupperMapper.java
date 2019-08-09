package com.ps.mapper;

import com.ps.domain.core.QasysCommodityT;
import com.ps.domain.core.QasysOrderT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupperMapper {


    void add(String project, int integral);

    void addQdetail(int id, int num, String question);

    void addqresult(int mid, int id, String result);

    //shop
    QasysCommodityT shopquery(int id);

    void update(int id);
    //dingdang
    void orderupdate(int uid,int sid);

    QasysOrderT orederquery(int uid, int id);
}
