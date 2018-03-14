package io.ayoue.common.design.abstractfactory.t;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factory) {
		if (factory.equals("cai")) {
			return new CaiFactory();
		} else if (factory.equals("mi")) {
			return new MiFactory();
		} else {
			return null;
		}
	}
}
