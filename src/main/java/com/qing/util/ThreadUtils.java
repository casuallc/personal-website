package com.qing.util;

/**
 * @author liuchangqing
 * @time 2015年12月19日下午8:56:49
 * @function 
 */
public class ThreadUtils {

	private static ThreadLocal<StringBuilder> sbThreadLocal = new ThreadLocal<StringBuilder>() {
		public StringBuilder initialValue() {
			return new StringBuilder();
		};
	};
	
	public static StringBuilder getStringBuilder() {
		StringBuilder sb = sbThreadLocal.get();
		sb.setLength(0);
		return sb;
	}
}
