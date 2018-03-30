package io.ayoue.common.design.decorator;

public class ShangYe implements Insurance,Calc{
	@Override
	public void build(Order order) {
		System.out.println("商业参数构建");
	}

	@Override
	public void calc(Order order) {
		System.err.println("商业险保费计算："+order.getId());
	}

}
