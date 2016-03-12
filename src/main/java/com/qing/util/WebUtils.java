package com.qing.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liuchangqing
 * @time 2015年8月11日上午10:12:40
 * @function 
 */
@SuppressWarnings("unchecked")
public class WebUtils {

	public static String getWebDirectory(HttpServletRequest request) throws Exception {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	/**
	 * make bean from request
	 * @param request
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T>T getBean(HttpServletRequest request, Class<T> clazz) throws Exception {
		return getBean(request, null, clazz);
	}
	
	/**
	 * make bean from session
	 * @param request
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T getBean(HttpSession session, Class<T> clazz) throws Exception {
		return getBean(null, session, clazz); 
	}
	
	public static <T>T getBean(HttpServletRequest request, HttpSession session, Class<T> clazz) throws Exception {
		Object obj = clazz.newInstance();
		Field fields[] = clazz.getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			String name = fields[i].getName();
			String v = request.getParameter(name);
			if(v == null) {
				continue;
			}
			String type = fields[i].getType().getSimpleName();
			Method m = clazz.getDeclaredMethod("set"+name.substring(0,1).toUpperCase()+name.substring(1), fields[i].getType());
			if("String".equals(type)) {
				m.invoke(obj, v);
			} else if("int".equals(type)) {
				m.invoke(obj, Integer.valueOf(v));
			} else if("double".equals(type)) {
				m.invoke(obj, Double.valueOf(v));
			} else if("long".equals(type)) {
				m.invoke(obj, Long.valueOf(v));
			} else if("float".equals(type)) {
				m.invoke(obj, Float.valueOf(v));
			} else if("Date".equals(type)) {
				m.invoke(obj, Date.valueOf(v));
			} else if("Time".equals(type)) {
				m.invoke(obj, Time.valueOf(v));
			} else if("Timestamp".equals(type)) {
				m.invoke(obj, Timestamp.valueOf(v));
			}  else {
				throw new Exception("未知数据类型");
			}
		}
		
		return (T) obj;
	}
	
	/**
	 * 得到访问者的ip地址
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ip == null) {
			ip = "unknown";
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
