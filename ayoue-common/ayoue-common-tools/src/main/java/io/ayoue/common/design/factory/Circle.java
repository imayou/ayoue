package io.ayoue.common.design.factory;

/**
 * @category 圆
 * @author AYOU
 */
public class Circle implements Shape, io.ayoue.common.design.abstractfactory.Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
