package io.ayoue.common.design.abstractfactory;

public class Test {
	public static void main(String[] args) {
		// 获取形状工厂
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		// 获取颜色工厂
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

		Shape circle = shapeFactory.getShape("Circle");
		Shape rectangle = shapeFactory.getShape("Rectangle");
		Shape square = shapeFactory.getShape("Square");
		circle.draw();
		rectangle.draw();
		square.draw();

		Color blue = colorFactory.getColor("Blue");
		Color green = colorFactory.getColor("Green");
		Color red = colorFactory.getColor("Red");
		blue.fill();
		green.fill();
		red.fill();
	}
}
