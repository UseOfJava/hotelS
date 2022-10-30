package com.sdau.controller;

import com.sdau.domain.Staff;
import com.sdau.service.StaffService;

import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录管理类
 */

@RestController
public class LoginController {

    @Resource
    StaffService ser;

    @RequestMapping("dologin")
    public boolean dologin(@SuppressWarnings("rawtypes") @RequestParam Map params, HttpSession session) {
//		System.out.println(params);
        return ser.login(params,session);

    }

    @RequestMapping("islogin")
    public Staff islogin(HttpSession session){
        return (Staff)session.getAttribute(SYS.LOGINSTAFF);
    }

    @RequestMapping("loginout")
    public boolean loginout(HttpSession session){
        if (session != null){
            session.invalidate();
        }
        return true;
    }



}
