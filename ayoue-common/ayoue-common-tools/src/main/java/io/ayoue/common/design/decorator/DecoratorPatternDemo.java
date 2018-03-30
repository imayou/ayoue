package io.ayoue.common.design.decorator;

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Order order = new Order(111);
		
		Insurance jq = new JiaoQiang();
		jq.build(order);
		jq.calc(order);
		
		
		Insurance sy = new ShangYe();
		sy.build(order);
		
		Insurance tax = new InsuranceTaxDecorator(new JiaoQiang());
		tax.build(order);
		tax.calc(order);
		
		Insurance xs = new InsuranceXiShuDecorator(new ShangYe());
		xs.build(order);
		
		Insurance zuhe = new InsuranceZuHeDecorator(new ZuHe());
		zuhe.build(order);
		zuhe.calc(order);
	}
}
