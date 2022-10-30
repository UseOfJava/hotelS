package com.sdau.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// 订单
public class Order {

    private Integer id;
    private Integer room_id;
    private Integer vip_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date start_time;            //  入住时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date check_out_time;        //  退房时间
    private int stay_days;              //  入住天数
    private int state;


    private BigDecimal money;           //  消费金额

    private List<OrderInfo> orderInfos; //  当前订单明细



    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(List<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getVip_id() {
        return vip_id;
    }

    public void setVip_id(Integer vip_id) {
        this.vip_id = vip_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public int getStay_days() {
        return stay_days;
    }

    public void setStay_days(int stay_days) {
        this.stay_days = stay_days;
    }

    public Date getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(Date check_out_time) {
        this.check_out_time = check_out_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
