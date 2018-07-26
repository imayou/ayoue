package io.ayoue.common.tools.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chinese4Binary {
	public static String toBinary(String chinese) {
		byte[] zl;
		String b = "";
		try {
			zl = chinese.getBytes("utf-8");
			for (int i = 0; i < zl.length; i++) {
				b += Integer.toBinaryString(zl[i] & 0xff);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 中文转二进制在线工具 http://www.5ixuexiwang.com/str/binary.php
	public static String toChinese(String binary) throws UnsupportedEncodingException {
		// 匹配所有由1或0组成的8位字符
		Pattern p = Pattern.compile("[10]{8}");
		// 定义匹配器，与源字符串关连上
		Matcher m = p.matcher(binary);
		List<Byte> list = new ArrayList<Byte>();

		// 开始搜寻pattern
		// 先将8位的字符串按2进制扫描为Integer
		// 由于后面的须求数字再强制转成byte
		// 存入list中
		while (m.find()) {
			list.add((byte) Integer.parseInt(m.group(), 2));
		}

		// 准备将list转为byte数组
		// 由于String构造器参数类型的限制
		byte[] b = new byte[list.size()];

		/*
		 * List.remove(int index)是将指定位置的元素删除, 然后右边所有剩下的数据向左移一位，填补第一个数据的空缺。
		 * remove(0)中0表示第一个元素，不停的调用remove(0)导致所有元素被删光，剩下一个空集合。
		 * 除了删除指定元素外，同时也具有返回值，就是被删掉的元素。
		 */

		// 开始转换
		for (int j = 0; j < b.length; j++) {
			b[j] = (Byte) list.remove(0); // 方法二 把Object强制转成Byte就可以了
		}
		return new String(b, "utf-8");
	}

}
