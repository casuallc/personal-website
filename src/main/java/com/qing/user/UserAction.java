package com.qing.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qing.base.BaseAction;
import com.qing.util.DateUtils;
import com.qing.util.WebUtils;

@Controller
@RequestMapping("user")
public class UserAction extends BaseAction {

	@Autowired
	private UserService service;
	
	@RequestMapping("login.htm")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = "9999";
		String msg = "未知错误";
		try {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			if(!StringUtils.hasText(user.getUsername())) {
				code = "0001";
				msg = "用户名为空";
			}
			
			user.setPassword(request.getParameter("password"));
			if(!StringUtils.hasText(user.getPassword())) {
				user.setPassword(null);
			}
			user.setIp(WebUtils.getClientIP(request));
			int result = service.login(user).getCode();
			if(result == 20) {
				code = "0000";
				msg = "登陆成功";
			} else if(result == 21) {
				code = "0002";
				msg = "用户名不存在";
			} else if(result == 22) {
				code = "0003";
				msg = "用户名和密码不匹配";
			} else {
				code = "9991";
				msg = "登陆失败";
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			writeJson(code, msg, response);
		}
	}
	
	@RequestMapping("registe.htm")
	public void registe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = "9999";
		String msg = "未知错误";
		try {
			User user = new User();
			user.setIp(WebUtils.getClientIP(request));
			user.setUsername(request.getParameter("username"));
			user.setRegisteTime(DateUtils.parseDateToNum(new Date(), null));
			user.setLoginTimes(1);
			if(!StringUtils.hasText(user.getUsername())) {
				code = "0001";
				msg = "用户名为空";
			}
			
			user.setPassword(request.getParameter("password"));
			if(!StringUtils.hasText(user.getPassword())) {
				user.setPassword(null);
			}
			int result = service.registe(user).getCode();
			if(result == 10) {
				code = "0000";
				msg = "注册成功";
			} else if(result == 11) {
				code = "0002";
				msg = "用户名已存在";
			} else {
				code = "9991";
				msg = "注册失败";
			}
		} catch (Exception e) {
			throw e;
		} finally {
			writeJson(code, msg, response);
		}
	}
	
	@RequestMapping("loadUser.htm")
	public void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = "9999";
		Object obj = null;
		try {
			User user = service.loadUserByIp(WebUtils.getClientIP(request));
			int result = user.getCode();
			if(result == 30) {
				code = "0000";
				obj =  user;
			} else if(result == 31) {
				code = "0001";
				obj = "IP不存在";
			} else {
				code = "9991";
				obj = "加载用户失败";
			}
		} catch (Exception e) {
			throw e;
		} finally {
			writeJson(code, obj, response);
		}
	}
}
