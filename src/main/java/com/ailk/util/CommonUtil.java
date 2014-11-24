package com.ailk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonUtil {
	private static final Log log = LogFactory.getLog(CommonUtil.class);

	public CommonUtil() {
		log.info("CommonUtil initialized.");
	}

	/**
	 * 
	 * 将ip转换为long型
	 * 
	 * @param ip
	 * @return
	 */
	public long ip2Long(String ip) throws IncorrectIp4FormatException {
		try {
			long[] ipFileds = new long[4];
			String[] ipArr = ip.split("\\.");

			ipFileds[0] = Long.parseLong(ipArr[0]);
			ipFileds[1] = Long.parseLong(ipArr[1]);
			ipFileds[2] = Long.parseLong(ipArr[2]);
			ipFileds[3] = Long.parseLong(ipArr[3]);
			/*
			 * 127.0.0.1
			 * [127.0.0.1]原,反,补=[00000000 00000000 00000000 01111111.0.0.00000000 00000000 00000000 00000001]
			 * 按照下面的算法得到值:[01111111 00000000 00000000 00000000.0.0.00000000 00000000 00000000 00000001]=2^0+2^24+2^25+2^26+2^27+2^28+2^29+2^30=1+2^24*(1+2+4+..+64)=1+2^24*127=2130706433L
			 */
			return (ipFileds[0] << 24) + (ipFileds[1] << 16) + (ipFileds[2] << 8) + ipFileds[3];

		} catch (Exception e) {
			throw new IncorrectIp4FormatException("input ip:" + ip, e);
		}
	}

	/**
	 * 
	 */
	public void sleepTwoSeconds() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void deadLoop() {
		for (;;) {

		}
	}

	/**
	 * 日期转化函数字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public String date2Str(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}

	/**
	 * 字符串转化日期函数，不正确的日期返回null
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public Date str2Date(String date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 字符串转化日期函数，不正确的日期返回null
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public boolean contains(String str, String substr) {
		if (str == null) {
			return substr == null;
		}
		if ("".equals(str)) {
			return "".equals(substr);
		} else {
			return substr != null && str.contains(substr);
		}
	}
}
