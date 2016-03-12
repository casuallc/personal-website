package com.qing.util;

import java.util.UUID;

/**
 * @author liuchangqing
 * @time 2015年8月10日上午11:43:08
 * @function 
 */
public class StringUtils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
	
	/**
	 * if array == null || str == null then return false
	 * @param array
	 * @param str
	 * @return
	 */
	public static boolean contains(String array[], String str) {
		if(array == null || str == null) 
			return false;
		
		for(String s : array) {
			if(s.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * both null, false
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equals(String s1[], String s2[]) {
		if(s1 == null || s2 == null) 
			return false;
		
		if(s1.length != s2.length) 
			return false;
		
		if(s1 == s2) 
			return true;
		
		for(String s : s1) {
			boolean flag = false;
			for(String ss : s2) {
				if(s.equals(ss)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				return false;
			}
		}
		
		return true;
	}
	
}
