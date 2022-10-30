package com.sdau.dao;

import com.sdau.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Mapper
public interface IStaffDao {
    /**
     * 	登录
     * @param params
     * @return
     */
    Staff getStaffByName(@SuppressWarnings("rawtypes") Map params);

    /**
     * 	查询
     * @return
     */
    List<Staff> getAll(@SuppressWarnings("rawtypes") Map params);
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
    int delStaff(@SuppressWarnings("rawtypes") Map params);

    /**
     * 	添加
     * @param params
     * @return
     */
    int addStaff(@SuppressWarnings("rawtypes") Map params);

    /**
     * 编辑
     * @param params
     * @return
     */
    int editStaff(@SuppressWarnings("rawtypes") Map params);

    /**
     * 核验用户名是否重复
     * @param params
     * @return
     */
    int getCountByLoginName(@SuppressWarnings("rawtypes") Map params);

    int kill(@SuppressWarnings("rawtypes")  Map params);
    int recover(@SuppressWarnings("rawtypes") Map params);

    /**
     * 修改密码
     * @param params
     * @return
     */
    int resetpass(@SuppressWarnings("rawtypes")  Map params);

}
