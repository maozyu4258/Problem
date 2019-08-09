package com.ps.service;

import com.ps.domain.core.QasysAnswerT;
import com.ps.mapper.SuppMapper;
import com.ps.service.core.AnswerInterface;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class Answerservice implements AnswerInterface {
    @Autowired
    private SuppMapper superMapper;

    @Override
    public void add(int mid, String answer, int qid) {
        superMapper.addAnswer(mid,qid,answer);
    }

    @Override
    public List<QasysAnswerT> query(int qid) {
        List<QasysAnswerT> list=superMapper.queryAnswer(qid);
        return list;
    }

    @Override
    public void update(int id) {
        superMapper.update(id);
    }

    @Override
    public List<QasysAnswerT> queryall(int id) {
        List<QasysAnswerT> list=superMapper.queryAnswerall(id);
        return list;
    }


}
