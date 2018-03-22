package io.ayoue.common.design.builder.impl;

/**
 * 素食汉堡
 * @author AYOU
 */
public class VegBurger extends Burger {

	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}

}
