package com.sdau.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//  订单明细
public class OrderInfo {
    private Integer id;
    private Integer order_id;

    @JsonFormat(pattern = "yyyy-M-d")
    private Date check_in_date;
    private int state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
