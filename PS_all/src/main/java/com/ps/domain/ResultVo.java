package com.ps.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResultVo implements Serializable {
    private static final long serialVersionUID = -1L;
    private String msg;
    private int code;
    private Object date;

}
