package com.sdau.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoginLog {

    private Integer id;
    private String login_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date login_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        Date date = new Date();
        login_time = date;
        this.login_time = login_time;
    }



}
