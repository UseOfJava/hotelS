package com.sdau.service;

import com.sdau.dao.ILoginLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service
public class LoginLogService {

    @Resource
    ILoginLogDao dao;

    public int addLoginLog(@SuppressWarnings("rawtypes") Map params){
        return dao.addLoginLog(params);
    }

}
