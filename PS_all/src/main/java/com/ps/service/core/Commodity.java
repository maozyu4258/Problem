package com.ps.service.core;

import com.ps.domain.ResultVo;

public interface Commodity {
    ResultVo add(String username , int id) throws InterruptedException;

}
