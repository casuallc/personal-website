package com.qing.base;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qing.util.ThreadUtils;

public class BaseAction {

	public void writeJson(String code, String msg, HttpServletResponse response) throws Exception {
		StringBuilder sb = ThreadUtils.getStringBuilder();
		sb.append("{\"code\":\"").append(code).append("\"");
		sb.append(", \"msg\":\"").append(msg).append("\"}");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.write(sb.toString());
		out.flush();
	}
	
	public void writeJson(String code, Object obj, HttpServletResponse response) throws Exception {
		Gson gson = new Gson();
		StringBuilder sb = ThreadUtils.getStringBuilder();
		sb.append("{\"code\":\"").append(code).append("\"");
		sb.append(", \"obj\":").append(gson.toJson(obj)).append("}");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.write(sb.toString());
		out.flush();
	}
}
