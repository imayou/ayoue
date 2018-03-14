package io.ayoue.common.design.abstractfactory;

/**
 * @category 矩形
 * @author AYOU
 */
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
