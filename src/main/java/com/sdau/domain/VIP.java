package com.sdau.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VIP {
    private Integer id;

    private String name;
    private String tel;
    private String age;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date create_time;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
