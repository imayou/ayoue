package io.ayoue.common.design.builder.impl;

import io.ayoue.common.design.builder.Item;
import io.ayoue.common.design.builder.Packing;

/**
 * 饮料
 * @author AYOU
 */
public abstract class Drink implements Item {
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
    public abstract float price();
}
