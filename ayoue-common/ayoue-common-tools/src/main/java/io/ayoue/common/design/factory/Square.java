package io.ayoue.common.design.factory;

/**
 * @category 正方形
 * @author AYOU
 */
public class Square implements Shape, io.ayoue.common.design.abstractfactory.Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
