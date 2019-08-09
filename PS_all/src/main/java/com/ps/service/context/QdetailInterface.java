package com.ps.service.context;

public interface QdetailInterface {
    // project_id          	int comment '问卷表id',
    //	 num          	    	int comment '问题序号',
    //   question      VARCHAR(800) comment '问题内容',
    void add(int id,int num,String question);
}
