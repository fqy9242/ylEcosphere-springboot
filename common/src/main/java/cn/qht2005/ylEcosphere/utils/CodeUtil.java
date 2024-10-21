package cn.qht2005.ylEcosphere.utils;

public class CodeUtil {
	/**
	 *  生成验证码
	 * @return
	 */
	public static String createCode(Integer length) {
		String code = "";
		for (int i = 0; i < length; i++) {
			code += (int)(Math.random() * 10);
		}
		return code;
	}
}
