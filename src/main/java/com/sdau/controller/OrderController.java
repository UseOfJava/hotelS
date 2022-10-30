package com.sdau.controller;

import com.sdau.domain.Order;
import com.sdau.service.OrderService;
import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderService ser;

    @RequestMapping(SYS.GETROOMORDER)
    public List<Order> getRoomOrder(@SuppressWarnings("rawtypes") @RequestParam Map params) {
//        System.out.println(params);
        return ser.getRoomOrder(params);
    }

    @RequestMapping(SYS.GETINCOMEDAY)
    public List<Map<?,?>> incomeDay(@SuppressWarnings("rawtypes") @RequestParam Map params) {
        return ser.incomeDay(params);
    }
    @RequestMapping(SYS.GETINCOMEMONTH)
    public List<Map<?,?>> incomeMonth(@SuppressWarnings("rawtypes") Map params){
        return ser.incomeMonth(params);
    }
    @RequestMapping(SYS.GETINCOMEYEAR)
    public List<Map<?,?>> incomeYear(@SuppressWarnings("rawtypes") Map params){
        return ser.incomeYear(params);
    }

    @RequestMapping(SYS.VIPCONSUM)
    List<Map<?,?>> vipconsume(@SuppressWarnings("rawtypes") Map params){
        return ser.vipconsume(params);
    }
    @RequestMapping(SYS.ROOMINCOME)
    List<Map<?,?>> roomincome(@SuppressWarnings("rawtypes") Map params){
        return ser.roomincome(params);
    }

}
