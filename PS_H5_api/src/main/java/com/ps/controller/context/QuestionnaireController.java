package com.ps.controller.context;


import com.ps.domain.ResultVo;
import com.ps.service.context.QuestionnaireInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {
    //   project_name         VARCHAR(200) comment '问卷主题',
    //   integral          		int comment '填写完问卷可获得的积分数',
    @Reference(version = "1.0.0",check = false)
    private QuestionnaireInterface questionnaireInterface;

    private ResultVo resultVo =new ResultVo();

    @GetMapping("/addzhuti")
    public ResultVo add(@RequestParam String project ,@RequestParam int integral){
        questionnaireInterface.add(project,integral);

        return  resultVo;
    }
}
