package com.ps.controller.context;

import com.ps.domain.ResultVo;
import com.ps.service.context.QresultInterface;
import com.ps.service.context.QuestionnaireInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QresultController {
    @Reference(version = "1.0.0",check = false)
    private QresultInterface qresultInterface;

    private ResultVo resultVo =new ResultVo();

    @GetMapping("/addjieguo")
    public ResultVo add(@RequestParam String result , @RequestParam int id, @RequestParam int mid){
        qresultInterface.add(mid,id,result);
        return  resultVo;
    }


}
