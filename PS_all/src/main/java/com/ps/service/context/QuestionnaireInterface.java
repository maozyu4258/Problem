package com.ps.service.context;

public interface QuestionnaireInterface {
    //   project_name         VARCHAR(200) comment '问卷主题',
    //   integral          		int comment '填写完问卷可获得的积分数',
    void  add(String project, int integral);
}
