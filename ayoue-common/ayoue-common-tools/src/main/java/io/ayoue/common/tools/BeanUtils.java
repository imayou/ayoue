package io.ayoue.common.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanUtils {
	/**
	 * 合并2个对象
	 * 
	 * @param o1
	 * @param o2
	 * @throws Exception
	 */
	public static void merge(Object o1, Object o2) {
		Field[] field = o1.getClass().getDeclaredFields();
		try {
			for (int j = 0; j < field.length; j++) {
				String name = field[j].getName();
				String type = field[j].getGenericType().toString();
				if (type.equals("class java.lang.String")) {
					Method m = o1.getClass().getMethod("get" + StringUtil.toUpperCaseFirstOne(name));
					String value = (String) m.invoke(o1);
					String value2 = (String) m.invoke(o2);
					if (value == null && value2 != null) {
						m = o1.getClass().getMethod("set" + StringUtil.toUpperCaseFirstOne(name), String.class);
						m.invoke(o1, value2);
					}
				} else if ("int".equals(type)) {
					Method m = o1.getClass().getMethod("get" + StringUtil.toUpperCaseFirstOne(name));
					Integer value = (Integer) m.invoke(o1);
					Integer value2 = (Integer) m.invoke(o2);
					if (value == null) {
						m = o1.getClass().getMethod("set" + StringUtil.toUpperCaseFirstOne(name), Integer.class);
						m.invoke(o1, value2);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
