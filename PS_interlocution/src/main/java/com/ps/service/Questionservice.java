package com.ps.service;

import com.ps.domain.core.QasysQuestionT;
import com.ps.mapper.SuppMapper;
import com.ps.service.core.QuestionInterface;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class Questionservice implements QuestionInterface {


    @Autowired
    private SuppMapper superMapper;



    @Override
    public void add(int mid, String question, int integral) {
        superMapper.addQuestion(mid,question,integral);

    }

    @Override
    public List<QasysQuestionT> query() {
        List<QasysQuestionT> list=  superMapper.queryQuestion();
        return list;
    }

    @Override
    public List<QasysQuestionT> queryall(int i) {
        List<QasysQuestionT> list=  superMapper.queryQuestionall(i);
        return list;
    }
}
