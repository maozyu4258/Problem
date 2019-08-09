package com.ps.controller.context;

import com.ps.domain.ResultVo;
import com.ps.service.context.QdetailInterface;
import com.ps.service.context.QuestionnaireInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QdetailController {
    @Reference(version = "1.0.0",check = false)
    private QdetailInterface qdetailInterface;

    private ResultVo resultVo =new ResultVo();

    @GetMapping("/addxu")
    public ResultVo add(@RequestParam String question , @RequestParam int id,@RequestParam int num){
        qdetailInterface.add(id,num,question);

        return  resultVo;
    }

}
