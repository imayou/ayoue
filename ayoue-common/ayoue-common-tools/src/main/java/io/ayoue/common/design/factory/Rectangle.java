package io.ayoue.common.design.factory;

/**
 * @category 矩形
 * @author AYOU
 */
public class Rectangle implements Shape, io.ayoue.common.design.abstractfactory.Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
