package com.hr.util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class EncodeUtil {
	// 编码处理方法，用于处理请求的编码问题
	public static void encode(HttpServletRequest request) {
		try {
			// 设置请求的字符编码为UTF-8
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// 获取请求参数的Map
		Map map = request.getParameterMap();

		// 遍历Map中的值
		Collection vs = map.values();
		Iterator it = vs.iterator();
		while (it.hasNext()) {
			String[] v = (String[]) it.next(); // 获取某个表单值的数组
			for (int i = 0; i < v.length; i++) {
				try {
					// 将每个表单值的字符编码从ISO8859-1转换为UTF-8
					v[i] = new String(v[i].getBytes("ISO8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
