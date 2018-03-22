package io.ayoue.common.design.builder.impl;

/**
 * 百事可乐
 * 
 * @author AYOU
 */
public class Pepsi extends Drink {

	@Override
	public float price() {
		return 35.0f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}

}
