package io.ayoue.common.design.factory;

/**
 * 测试
 * @author AYOU
 */
public class Test {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();// 建一个工厂
		
		//Circle
		Shape circle = factory.getShape("Circle");
		circle.draw();
		
		//Rectangle
		Shape rectangle = factory.getShape("Rectangle");	
		rectangle.draw();
		
		//Square
		Shape square = factory.getShape("Square");
		square.draw();
	}
}
