package com.sdau.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ILoginLogDao {
    int addLoginLog(@SuppressWarnings("rawtypes") Map params);
}
