package com.qing.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static long parseDateToNum(Date date, String pattern) {
		pattern = StringUtils.isEmpty(pattern) ? "yyyyMMddHHmmss" : pattern;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return Long.valueOf(format.format(date));
	}

}
