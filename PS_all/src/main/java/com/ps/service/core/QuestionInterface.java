package com.ps.service.core;

import com.ps.domain.core.QasysQuestionT;

import java.util.List;

public interface QuestionInterface {
    void add(int mid, String question,int integral);

    List<QasysQuestionT> query();

    List<QasysQuestionT> queryall(int i);
}
