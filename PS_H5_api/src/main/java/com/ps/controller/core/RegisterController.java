package com.ps.controller.core;

import com.ps.domain.ResultVo;
import com.ps.domain.core.QasysMemberT;
import com.ps.service.core.MemberInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {


    @Reference(version = "1.0.0",check = false)
    private MemberInterface memberInterface;

    private ResultVo resultVo=new ResultVo();

    @GetMapping("/register")
    public ResultVo add(@RequestParam String username,@RequestParam String password,@RequestParam String ecode){
        QasysMemberT qasysMemberT=new QasysMemberT();
        qasysMemberT.setUsername(username);
        qasysMemberT.setPassword(password);
        memberInterface.add(username,password,ecode);


        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }



    @GetMapping("/login")
    public ResultVo login(){

        return resultVo;
    }
}
