package com.ps.service.core;



import com.ps.domain.core.QasysAnswerT;

import java.util.List;

public interface AnswerInterface {
    //	 mid          	    	int comment '会员表id（回答者的id）',
    //	 qid          	    	int comment '问题表id',
    //   answer         		  VARCHAR(5000) comment '回答内容',
    void add(int mid, String answer,int qid);

    //查询所属问题的所有答案
    List<QasysAnswerT> query(int qid);

    //采纳问题
    void update(int id);

    List<QasysAnswerT> queryall(int id);
}
