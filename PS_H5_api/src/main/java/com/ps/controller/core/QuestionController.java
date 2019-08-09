package com.ps.controller.core;


import com.ps.domain.ResultVo;
import com.ps.service.core.QuestionInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Reference(version = "1.0.0",check = false)
    private QuestionInterface questionInterface;
    private ResultVo resultVo =new ResultVo();

    @GetMapping("/publication")
    public ResultVo add(@RequestParam int mid, @RequestParam String question,@RequestParam int integral){

        questionInterface.add(mid,question,integral);

        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }

    @GetMapping("/queryAllquestion")
    public ResultVo queryquestion(){

        List qasysQuestionT=questionInterface.query();
        System.out.println(qasysQuestionT);
        resultVo.setDate(qasysQuestionT);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }



}
