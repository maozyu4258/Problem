package com.ps.controller.core;

import com.ps.domain.ResultVo;
import com.ps.domain.core.QasysMemberT;
import com.ps.service.core.MemberInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministerController {
    @Reference(version = "1.0.0",check = false)
    private MemberInterface memberInterface;

    private  ResultVo resultVo =new ResultVo();


    @GetMapping("/administerquery")
    public ResultVo Query(@RequestParam String username){
        QasysMemberT qasysMemberT=memberInterface.querya(username);
        System.out.println(qasysMemberT.getIntegral());
        resultVo.setDate(qasysMemberT.getIntegral());
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }


}
