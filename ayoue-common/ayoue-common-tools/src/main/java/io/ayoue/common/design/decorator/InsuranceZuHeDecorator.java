package io.ayoue.common.design.decorator;

public class InsuranceZuHeDecorator extends InsuranceDecorator{

	public InsuranceZuHeDecorator(Insurance decoratedInsurance) {
		super(decoratedInsurance);
	}

	@Override
	public void build(Order order) {
		decoratedInsurance.build(order);
		tax(order);
		xishu(order);
	}
	
	public void tax(Order order) {
		order.setTax("组合车船税");
		System.out.println("为组合订单添加了车船税");
	}
	public void xishu(Order order) {
		order.setTax("组合系数");
		System.out.println("为组合订单添加了系数");
	}

	@Override
	public void calc(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clac2(Order order) {
		// TODO Auto-generated method stub
		
	}

}
