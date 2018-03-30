package io.ayoue.common.design.decorator;

public class JiaoQiang implements Insurance{

	@Override
	public void build(Order order) {
		System.out.println("交强参数构建");
	}

	@Override
	public void calc(Order order) {
		System.err.println("交强险保费计算："+order.getId());
	}

}
