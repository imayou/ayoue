package io.ayoue.common.design.decorator;

public class InsuranceTaxDecorator extends InsuranceDecorator {

	public InsuranceTaxDecorator(Insurance decoratedInsurance) {
		super(decoratedInsurance);
	}

	@Override
	public void build(Order order) {
		decoratedInsurance.build(order);
		tax(order);
	}

	public void tax(Order order) {
		order.setTax("车船税扒拉扒拉");
		System.out.println("为订单"+order.getId()+"添加了车船税");
	}

	@Override
	public void calc(Order order) {
		System.err.println("车船税交强险保费计算"+order.getId());
	}

	@Override
	public void clac2(Order order) {
		
	}


}
