package com.sdau.service;

import java.util.List;
import java.util.Map;

import com.sdau.util.SYS;
import org.springframework.stereotype.Service;

import com.sdau.dao.IStaffDao;
import com.sdau.domain.Staff;
import com.sdau.util.MD5Utils;
import com.sdau.util.PageUtil;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class StaffService {
	
	@Resource
	IStaffDao dao;

	/**
	 * 	登录
	 * @param session
	 * @param params
	 * @return
	 * request 请求对象
	 * session 会话对象
	 * 默认是最后一次有效访问服务器半小时后自动注销
	 */
	public boolean login(@SuppressWarnings("rawtypes") Map params, HttpSession session) {
		Staff staff_data = dao.getStaffByName(params);
		if(staff_data != null) {
			// 获取数据库中的密码
			String pass_data = staff_data.getLogin_pass();
			// 前台输入的密码
			String pass_param = (String) params.get("Login_pass");
			// admin
			boolean isok = MD5Utils.LoginPass(pass_data,pass_param);
			if (isok){
				session.setAttribute(SYS.LOGINSTAFF,staff_data);
			}
			return isok;
		}
		return false;
	}

	public Staff getStaffByName(Map<?,?> params){
		return dao.getStaffByName(params);
	}
	
	
	
	/**
	 * 	查询
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List<Staff> getAll(Map params){
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
	public int delStaff(@SuppressWarnings("rawtypes") Map params) {
		return dao.delStaff(params);
	}
	
	/**
	 *	添加
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int addStaff(@SuppressWarnings("rawtypes") Map params) {
		/*给新增员工提供一个默认密码  MD5加密    随机加密次数    随机盐值 */
		String hex_pass = MD5Utils.getMD5(null);
		params.put("login_pass",hex_pass);
		
		return dao.addStaff(params);
	}

	/**
	 * 修改
	 * @param params
	 * @return
	 */
	public int editStaff(@SuppressWarnings("rawtypes") Map params){
		return dao.editStaff(params);
	}

	/**
	 * 核验账号是否重复
	 * @param params
	 * @return
	 */
	public boolean loginNameRepeat(@SuppressWarnings("rawtypes") Map params){
		int count = dao.getCountByLoginName(params);
		return count != 0;
	}

	public int kill(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return dao.kill(params);
	}
	public int recover(@SuppressWarnings("rawtypes") @RequestParam Map params){
		return dao.recover(params);
	}

	/**
	 * 修改密码
	 * @param params
	 * @param session
	 * @return
	 */
	public boolean resetpass(@RequestParam Map<String,String> params,HttpSession session){
		/*	验证密码原密码是否正确
		 * 	如果正确  将新密码加密后保存到数据库中
		 * session失效
		 * true
		 * */
		String old_pass = params.get(SYS.LOGINPASS);
		String new_pass = params.get(SYS.NEWPASS);
		String confirm_pass =params.get(SYS.CONFIRMPASS);
		Staff staff = (Staff) session.getAttribute(SYS.LOGINSTAFF);


		if (new_pass.equals(confirm_pass) && MD5Utils.LoginPass(staff.getLogin_pass(),old_pass) ){

			String hex_pass = MD5Utils.getMD5(new_pass);
			/*保存到数据库*/
			params.put("login_pass",hex_pass);
			params.put("id",staff.getId().toString());

			dao.resetpass(params);
			return true;
		}
		return false;
	}

}
