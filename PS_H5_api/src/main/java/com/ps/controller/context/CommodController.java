package com.ps.controller.context;

import com.ps.domain.ResultVo;
import com.ps.service.context.QresultInterface;
import com.ps.service.core.Commodity;
import com.ps.service.core.MemberInterface;
import com.ps.service.core.Order;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodController {

    @Reference(version = "1.0.0",check = false)
    private Commodity commodity;


    @Reference(version = "1.0.0",check = false)
    private MemberInterface memberInterface;

    private ResultVo resultVo =new ResultVo();

    @GetMapping("/shop")
    public ResultVo add(@RequestParam String username , @RequestParam int shopid) throws InterruptedException {
        ResultVo resultVos=commodity.add(username,shopid);

        return resultVos;
    }
}
