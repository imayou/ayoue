package io.ayoue.common.design.abstractfactory.t;

public class Test {
	public static void main(String[] args) {
		AbstractFactory miFactory = FactoryProducer.getFactory("mi");
		miFactory.getMi("NuoMi").get();
		miFactory.getMi("XiaoMi").get();
		miFactory.getMi("ZiMi").get();
		
		AbstractFactory caiFactory = FactoryProducer.getFactory("cai");
		caiFactory.getCai("BaiCai").get();
		caiFactory.getCai("QingCai").get();
		caiFactory.getCai("YouCai").get();
		
	/**
	 * 	糯米
		小米
		紫米
		白菜
		青菜
		油菜
	 */
	}
}
