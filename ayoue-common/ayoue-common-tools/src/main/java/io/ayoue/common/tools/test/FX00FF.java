package io.ayoue.common.tools.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class FX00FF {
	public static int BC_INT_SHORT_ZERO = 0xd4;
	public static int INT_SHORT_MIN = -0x40000;
	public static int INT_SHORT_MAX = 0x3ffff;
	public static final int BC_LONG_SHORT_ZERO = 0x3c;
	public static int x = 0B0100_0000_0000; // 2的10次方

	public static void main(String[] args) throws IOException {
		int value = 101910;
		byte[] buffer = new byte[3];
		int offset = 0;
		if (INT_SHORT_MIN <= value && value <= INT_SHORT_MAX) {
			buffer[offset++] = (byte) (BC_INT_SHORT_ZERO + (value >> 16));
			buffer[offset++] = (byte) (value >> 8);
			buffer[offset++] = (byte) (value);
		}

		System.out.println(value);
		System.out.println(Arrays.toString(buffer));
		System.out.printf("%02x %02x %02x\n", buffer[0], buffer[1], buffer[2]);
		System.out.printf("%d\n", ((buffer[0] - BC_LONG_SHORT_ZERO) << 16) + 256 * buffer[1] + buffer[2]);
		System.out.printf("%d\n", Long.valueOf(((buffer[0] - BC_LONG_SHORT_ZERO) << 16) + 256 * buffer[1] + buffer[2]));
		// return Long.valueOf(((tag - BC_LONG_SHORT_ZERO) << 16) + 256 * read()+
		// read());
		System.out.println(Math.pow(2, 10));
		System.out.println(x);

		String str = "杨世友";//1110 0110 1001 1101 1010 1000 1110 0100 1011 1000 1001 0110 1110 0101 1000 1111 1000 1011
		char x = '中';
		
		String binary = Chinese4Binary.toBinary(str);
		System.out.println("二进制 " + binary);
		System.out.println("中文 " + Chinese4Binary.toChinese(binary));
		
		byte[] bytes = null;
		byte[] bytes1 = null;
		try {
			bytes = str.getBytes("utf-8");
			bytes1 = charToByte(x);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("bytes 大小：" + bytes.length);
		System.out.println("bytes1大小：" + bytes1.length);
	}

	public static byte[] charToByte(char c) {
		byte[] b = new byte[4];
		b[0] = (byte) ((c & 0xFF000000) >> 32);
		b[1] = (byte) ((c & 0xFF0000) >> 16);
		b[2] = (byte) ((c & 0xFF00) >> 2);
		b[3] = (byte) (c & 0xFF);
		return b;
	}

}
