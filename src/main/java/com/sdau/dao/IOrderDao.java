package com.sdau.dao;

import com.sdau.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IOrderDao {

    List<Order> getRoomOrder(@SuppressWarnings("rawtypes") Map params);

    /*按日查收入*/
    List<Map<?,?>> incomeDay(@SuppressWarnings("rawtypes") Map params);
    /*按月查收入*/
    List<Map<?,?>> incomeMonth(@SuppressWarnings("rawtypes") Map params);
    /*按年查收入*/
    List<Map<?,?>> incomeYear(@SuppressWarnings("rawtypes") Map params);
    /*VIP查询*/
    List<Map<?,?>> vipconsume(@SuppressWarnings("rawtypes") Map params);
    /*Room查询*/
    List<Map<?,?>> roomincome(@SuppressWarnings("rawtypes") Map params);
}
