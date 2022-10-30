package com.sdau.controller;

import java.util.List;
import java.util.Map;


import com.sdau.util.SYS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdau.domain.Staff;
import com.sdau.service.StaffService;
import com.sdau.util.LayData;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 员工管理类
 */
@RestController
@RequestMapping("staff")
public class StaffController {


	@Resource
	StaffService ser;
	
	
	@RequestMapping("get")
	public Staff getStaffByName(@SuppressWarnings("rawtypes") @RequestParam Map params){
//		System.out.println(params);
		return ser.getStaffByName(params);
	}
	
	
	@RequestMapping(SYS.LIST)
	public LayData getAll(@SuppressWarnings("rawtypes") @RequestParam Map params) {
		//	layui传递的参数有:{page = 1-->页码,limit = 10-->单页条数}
//		System.out.println(params);
		//	layui想要的数据中的data数据,layui需要一个完整的数据规范
		//	JSON 对象：{code;msg;count;data}
		List<?> list = ser.getAll(params);
		//	count 查询数据的总条数
		//	data/list 当前页面要显示的数据
		int count = ser.getCount(params);

		return new LayData(count,list);
	}

	
	@RequestMapping(SYS.DEL)
	public int delStaff(@SuppressWarnings("rawtypes") @RequestParam Map params) {
		return ser.delStaff(params);
	}
	
	@RequestMapping(SYS.ADD)
	public int addStaff(@SuppressWarnings("rawtypes") @RequestParam Map params) {
		return ser.addStaff(params);
	}

	@RequestMapping("loginNameRepeat")
	public boolean loginNameRepeat(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return ser.loginNameRepeat(params);
	}

	@RequestMapping(SYS.EDIT)
	public int editStaff(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return ser.editStaff(params);
	}

	@RequestMapping(SYS.KILL)
	public int kill(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return ser.kill(params);
	}

	@RequestMapping(SYS.RECOVER)
	public int recover(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return ser.recover(params);
	}

	@RequestMapping(SYS.RESETPASS)
	public boolean resetpass(@SuppressWarnings("rawtypes") @RequestParam Map<String,String> params, HttpSession session){
		return ser.resetpass(params,session);
	}

}