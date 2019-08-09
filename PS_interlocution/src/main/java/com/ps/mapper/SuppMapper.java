package com.ps.mapper;

import com.ps.domain.core.QasysAnswerT;
import com.ps.domain.core.QasysQuestionT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SuppMapper {
    //增加一个问题
    void addQuestion(int mid, String question, int integral);

    //增加一个答案
    void addAnswer(int mid, int qid, String answer);
    //查询所有问题
    List<QasysQuestionT> queryQuestion();

    List<QasysAnswerT> queryAnswer(int qid);

    int update(int id);

    List<QasysAnswerT> queryAnswerall(int id);

    List<QasysQuestionT> queryQuestionall(int i);
}
