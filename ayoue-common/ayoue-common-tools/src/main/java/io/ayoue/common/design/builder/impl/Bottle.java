package io.ayoue.common.design.builder.impl;

import io.ayoue.common.design.builder.Packing;

/**
 * 瓶子
 * @author AYOU
 */
public class Bottle implements Packing {
	@Override
	public String pack() {
		return "Bottle";
	}
}
