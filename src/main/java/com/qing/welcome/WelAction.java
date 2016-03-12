package com.qing.welcome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class WelAction {

	@RequestMapping("index.htm")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		} catch (Exception e) {
			throw e;
		} 
		return "/welcome/wel.ftl";
	}
	
}
