package com.sdau.controller;

import com.sdau.service.LoginLogService;
import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("loginlog")
public class LoginLogController {

    @Resource
    LoginLogService ser;

    @RequestMapping(SYS.ADD)
    public int addLoginLog(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.addLoginLog(params);
    }

}
