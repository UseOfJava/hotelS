package com.sdau.service;

import com.sdau.dao.IOrderDao;
import com.sdau.domain.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    IOrderDao dao;

    public List<Order> getRoomOrder(@SuppressWarnings("rawtypes") Map params){
        return dao.getRoomOrder(params);
    }

    public List<Map<?,?>> incomeDay(@SuppressWarnings("rawtypes") Map params){
        return dao.incomeDay(params);
    }
    public List<Map<?,?>> incomeMonth(@SuppressWarnings("rawtypes") Map params){
        return dao.incomeMonth(params);
    }
    public List<Map<?,?>> incomeYear(@SuppressWarnings("rawtypes") Map params){
        return dao.incomeYear(params);
    }

    public List<Map<?,?>> vipconsume(@SuppressWarnings("rawtypes") Map params){
        return dao.vipconsume(params);
    }

    public List<Map<?,?>> roomincome(@SuppressWarnings("rawtypes") Map params){
        return dao.roomincome(params);
    }



}
