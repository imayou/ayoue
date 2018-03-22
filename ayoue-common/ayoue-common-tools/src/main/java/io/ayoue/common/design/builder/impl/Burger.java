package io.ayoue.common.design.builder.impl;

import io.ayoue.common.design.builder.Item;
import io.ayoue.common.design.builder.Packing;

public abstract class Burger implements Item {
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
