package com.shaw.blog.utils.qiniu;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QiNiuPropertiesUtil {

	private static InputStream in;
	private static InputStream filePath = QiNiuPropertiesUtil.class.getClassLoader().getResourceAsStream("qiniu.properties");
	private static Properties props;

	static {
		props = new Properties();
		try {
			in = new BufferedInputStream(filePath);
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readStringValue(String key) {
		return props.getProperty(key);
	}

	public static int readIntValue(String key) {
		return Integer.parseInt(props.getProperty(key));
	}

	public static String[] readStringArray(String key, String regex) {
		String val = props.getProperty(key);
		String[] result = val.split(regex);
		return result;
	}

	
	public abstract class QiNiuPropKey{
		//七牛 公用配置
		public static final String qiniu_accessKey="qiniu.accessKey";
		public static final String qiniu_secretKey="qiniu.secretKey";
		
		
	}
}
