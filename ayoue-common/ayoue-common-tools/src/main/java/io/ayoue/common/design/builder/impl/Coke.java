package io.ayoue.common.design.builder.impl;

/**
 * 咖啡
 * @author AYOU
 */
public class Coke extends Drink {

	@Override
	public float price() {
		return 30.0f;
	}

	@Override
	public String name() {
		return "Coke";
	}

}
