package io.ayoue.common.design.decorator;

public class ZuHe implements Insurance{

	@Override
	public void build(Order order) {
		System.out.println("组合参数构建");
		
	}

	@Override
	public void calc(Order order) {
		
	}
}
