package com.sdau.dao;

import com.sdau.domain.VIP;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IVipDao {
    /**
     * 	查询
     * @return
     */
    List<VIP> getAll(@SuppressWarnings("rawtypes") Map params);
    /**
     * 	分页查询
     * @param params
     * @return
     */
    int getCount(@SuppressWarnings("rawtypes") Map params);


    /**
     *	删除
     */
    // 返回值用int或boolean
    int delVIP(@SuppressWarnings("rawtypes") Map params);

    /**
     * 	添加
     * @param params
     * @return
     */
    int addVIP(@SuppressWarnings("rawtypes") Map params);

    /**
     * 编辑
     * @param params
     * @return
     */
    int editVIP(@SuppressWarnings("rawtypes") Map params);



    int kill(@SuppressWarnings("rawtypes")  Map params);
    int recover(@SuppressWarnings("rawtypes") Map params);

}
