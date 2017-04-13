package com.unionx.core.util;

public class SerialNumberUtil {

	/*
	 * 订单编号自增长（两位数字）
	 */
	public static String codeStringNextValue(String codeString) {
		if(codeString == null || codeString.equals("")) {
			return "01";
		}else {
			Integer value = Integer.parseInt(codeString);
			value = value +1;
			if(value < 100 && value >= 10) {
				return value+"";
			}else{
				return "0"+value;
			}
		}
	}

}
