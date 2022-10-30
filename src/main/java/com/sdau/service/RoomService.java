package com.sdau.service;

import com.sdau.dao.IRoomDao;
import com.sdau.domain.Room;
import com.sdau.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    @Resource
    IRoomDao dao;

    /**
     * 	查询
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public List<Room> getAll(Map params){
        // 处理分页参数
        PageUtil.start(params);
        return dao.getAll(params);
    }
    /**
     * 	查询分页
     * @param params
     * @return
     */
    public int getCount(@SuppressWarnings("rawtypes") Map params) {
        return dao.getCount(params);
    }

    /**
     * 	删除
     * @param params
     */
    public int delRoom(@SuppressWarnings("rawtypes") Map params) {
        return dao.delRoom(params);
    }

    /**
     *	添加
     * @param params
     * @return
     */
    public int addRoom(@SuppressWarnings("rawtypes") Map params) {
        return dao.addRoom(params);
    }

    /**
     * 修改
     * @param params
     * @return
     */
    public int editRoom(@SuppressWarnings("rawtypes") Map params){
        return dao.editRoom(params);
    }

    /**
     * 核验房间号是否重复
     * @param params
     * @return
     */
    public int roomCodeRepeat(@SuppressWarnings("rawtypes") Map params){
        return dao.roomCodeRepeat(params);
    }

}
