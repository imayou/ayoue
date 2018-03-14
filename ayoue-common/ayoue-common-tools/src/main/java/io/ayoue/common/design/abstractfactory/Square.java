package io.ayoue.common.design.abstractfactory;

/**
 * @category 正方形
 * @author AYOU
 */
public class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
