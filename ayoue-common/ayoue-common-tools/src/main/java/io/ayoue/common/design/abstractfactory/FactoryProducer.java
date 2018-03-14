package io.ayoue.common.design.abstractfactory;

/**
 * @category 工厂生成器 通过传递形状或颜色信息来获取工厂
 * @author AYOU
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Shape")) {
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("Color")) {
			return new ColorFactory();
		}
		return null;
	}
}
