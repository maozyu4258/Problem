package com.ps.service.core;

import com.ps.domain.core.QasysOrderT;

public interface Order {
    void update(int userid,int id);

    QasysOrderT query(int userid, int id);
}
