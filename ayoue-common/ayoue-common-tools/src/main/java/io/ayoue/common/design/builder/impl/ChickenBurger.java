package io.ayoue.common.design.builder.impl;

/**
 * 鸡肉汉堡
 * @author AYOU
 */
public class ChickenBurger extends Burger {
	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}
