package io.ayoue.common.design.decorator;

public abstract class InsuranceDecorator implements Insurance {
	protected Insurance decoratedInsurance;

	public InsuranceDecorator(Insurance decoratedInsurance) {
		this.decoratedInsurance = decoratedInsurance;
	}

	public void build(Order order) {
		decoratedInsurance.build(order);
	}
	
	abstract public void clac2(Order order);
}
