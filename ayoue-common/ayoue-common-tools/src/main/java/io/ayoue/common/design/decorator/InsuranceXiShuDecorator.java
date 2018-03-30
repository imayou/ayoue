package io.ayoue.common.design.decorator;

public class InsuranceXiShuDecorator extends InsuranceDecorator{

	public InsuranceXiShuDecorator(Insurance decoratedInsurance) {
		super(decoratedInsurance);
	}

	@Override
	public void build(Order order) {
		decoratedInsurance.build(order);
		xs(order);
	}
	
	public void xs(Order order) {
		order.setXs("商业险系数");
		System.out.println("为订单"+order.getId()+"添加了系数");
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
