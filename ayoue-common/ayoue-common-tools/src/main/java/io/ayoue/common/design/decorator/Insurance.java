package io.ayoue.common.design.decorator;

public interface Insurance {
	public void build(Order order);
	public void calc(Order order);
}
