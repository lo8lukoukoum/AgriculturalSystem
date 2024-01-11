package com.hr.util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class EncodeUtil {
	// ���봦���������ڴ�������ı�������
	public static void encode(HttpServletRequest request) {
		try {
			// ����������ַ�����ΪUTF-8
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// ��ȡ���������Map
		Map map = request.getParameterMap();

		// ����Map�е�ֵ
		Collection vs = map.values();
		Iterator it = vs.iterator();
		while (it.hasNext()) {
			String[] v = (String[]) it.next(); // ��ȡĳ����ֵ������
			for (int i = 0; i < v.length; i++) {
				try {
					// ��ÿ����ֵ���ַ������ISO8859-1ת��ΪUTF-8
					v[i] = new String(v[i].getBytes("ISO8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
