package com.sdau.controller;

import com.sdau.service.VipService;
import com.sdau.util.LayData;
import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * VIP管理类
 */
@RestController
@RequestMapping("vip")
public class VipController {

    @Resource
    VipService ser;


    @RequestMapping(SYS.LIST)
    public LayData getAll(@SuppressWarnings("rawtypes") @RequestParam Map params) {

        List<?> list = ser.getAll(params);
        int count = ser.getCount(params);

        return new LayData(count,list);
    }


    @RequestMapping(SYS.DEL)
    public int delVIP(@SuppressWarnings("rawtypes") @RequestParam Map params) {
//        System.out.println(params);
        return ser.delVIP(params);
    }

    @RequestMapping(SYS.ADD)
    public int addVIP(@SuppressWarnings("rawtypes") @RequestParam Map params) {
        return ser.addVIP(params);
    }



    @RequestMapping(SYS.EDIT)
    public int editVIP(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.editVIP(params);
    }


    @RequestMapping(SYS.KILL)
    public int kill(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.kill(params);
    }

    @RequestMapping(SYS.RECOVER)
    public int recover(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.recover(params);
    }


}
