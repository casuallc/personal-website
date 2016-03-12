package com.qing.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author liuchangqing
 * @time 2015年12月5日下午9:19:52
 * @function
 */
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
