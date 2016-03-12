package com.qing.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeAction {

	@RequestMapping("index.htm")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		} catch (Exception e) {
			
		} 
		return "/home/index.ftl";
	}
}
