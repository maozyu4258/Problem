package com.ps.controller.core;

import com.ps.domain.ResultVo;
import com.ps.domain.core.QasysAnswerT;
import com.ps.domain.core.QasysQuestionT;
import com.ps.service.core.AnswerInterface;
import com.ps.service.core.MemberInterface;
import com.ps.service.core.QuestionInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    @Reference(version = "1.0.0",check = false)
    private AnswerInterface answerInterface;


    @Reference(version = "1.0.0",check = false)
    private MemberInterface memberInterface;

    @Reference(version = "1.0.0",check = false)
    private QuestionInterface questionInterface;


    private ResultVo resultVo =new ResultVo();

    @GetMapping("/addAnswer")
    public ResultVo add(@RequestParam int mid,@RequestParam int qid, @RequestParam String question){

        answerInterface.add(mid,question,qid);

        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }
    @GetMapping("/queryAnswer")
    public ResultVo query(@RequestParam int qid){

        List qasysQuestionT=answerInterface.query(qid);
        System.out.println(qasysQuestionT);

        resultVo.setDate(qasysQuestionT);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }
    @GetMapping("/qupdateAnswer")
    public ResultVo update(@RequestParam int id){
        answerInterface.update(id);
        List<QasysAnswerT> list=answerInterface.queryall(id);
        int i= (int) list.get(0).getQid();
        int mid=(int) list.get(0).getMid();
        List<QasysQuestionT> lists=questionInterface.queryall(i);
        int ss= (int) lists.get(0).getIntegral();
        int aa= (int) lists.get(0).getId();

        //加积分
        memberInterface.updatejia(mid,ss);
        //减积分
        memberInterface.update(aa,ss);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }


}
