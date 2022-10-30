package com.sdau.controller;

import com.sdau.service.RoomService;
import com.sdau.util.LayData;
import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 房间管理类
 */
@RestController
@RequestMapping("room")
public class RoomController {

    @Resource
    RoomService ser;

    @RequestMapping(SYS.LIST)
    public LayData getAll(@SuppressWarnings("rawtypes") @RequestParam Map params) {

        List<?> list = ser.getAll(params);
        int count = ser.getCount(params);

        return new LayData(count,list);
    }


    @RequestMapping(SYS.DEL)
    public int delRoom(@SuppressWarnings("rawtypes") @RequestParam Map params) {
//        System.out.println(params);
        return ser.delRoom(params);
    }

    @RequestMapping(SYS.ADD)
    public int addRoom(@SuppressWarnings("rawtypes") @RequestParam Map params) {
        return ser.addRoom(params);
    }



    @RequestMapping(SYS.EDIT)
    public int editRoom(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.editRoom(params);
    }

    @RequestMapping(SYS.ROOMCODEREPEAT)
    public int roomCodeRepeat(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return ser.roomCodeRepeat(params);
    }





}
