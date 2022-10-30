package com.sdau.dao;

import com.sdau.domain.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IRoomDao {
    /**
     * 	查询
     * @return
     */
    List<Room> getAll(@SuppressWarnings("rawtypes") Map params);
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
    int delRoom(@SuppressWarnings("rawtypes") Map params);

    /**
     * 	添加
     * @param params
     * @return
     */
    int addRoom(@SuppressWarnings("rawtypes") Map params);

    /**
     * 编辑
     * @param params
     * @return
     */
    int editRoom(@SuppressWarnings("rawtypes") Map params);

    /**
     * 核验房间号是否重复
     * @param params
     * @return
     */
    int roomCodeRepeat(@SuppressWarnings("rawtypes") Map params);

}
