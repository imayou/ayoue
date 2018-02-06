package io.ayoue.common.tools;

import java.util.UUID;

public class UUIDUtil {
	public static String generate() {
		return generate(false);
	}

	public static String generate(boolean withSeparator) {
		String uuid = UUID.randomUUID().toString();
		if (!withSeparator) {
			uuid = uuid.replace("-", "");
		}
		return uuid;
	}

	public static void main(String[] args) {
		System.out.println(generate());
		System.out.println(System.currentTimeMillis());
	}
}
