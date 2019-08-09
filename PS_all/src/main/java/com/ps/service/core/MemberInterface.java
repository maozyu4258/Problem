package com.ps.service.core;

import com.ps.domain.core.QasysMemberT;

import java.util.List;

public interface MemberInterface {
    int query(String username);

    QasysMemberT querya(String username);

    void add(String username, String password,String codes);

    void update(int aa, int ss);

    void updatejia(int mid,int ss);


}
