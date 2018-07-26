package io.ayoue.common.tools.test;

public class HashT {
	public static void main(String[] args) {
		System.out.println(HashAlgorithms.mixHash("123456"));
		System.out.println(HashAlgorithms.BKDRHash("123456"));
		System.out.println(HashAlgorithms.BKDRHash("123abc"));
		System.out.println(HashAlgorithms.BKDRHash("123efg"));
		System.out.println(HashAlgorithms.java("123abc"));
		System.out.println(HashAlgorithms.java("123"));
		System.out.println(HashAlgorithms.mixHash("684965498465"));
		System.out.println(HashAlgorithms.mixHash("sdfsfasfsfsa"));
		System.out.println(HashAlgorithms.mixHash("123456sdfs"));
		System.out.println(HashAlgorithms.mixHash("6465sdfs6fa5sf46ew561"));
		System.out.println(HashAlgorithms.mixHash("sdfa6546546547798we6f5s4df6asd54f6sa4f6s4fd5s4af65sdf4as65f4e6gt4sdhq6634twed4f6356389r456ds4f65asg4af564fs65s464d)*&*&TIHjY&^*^%*"));
	}
}
