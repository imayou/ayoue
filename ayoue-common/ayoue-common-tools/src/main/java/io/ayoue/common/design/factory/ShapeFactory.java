package io.ayoue.common.design.factory;

/**
 * @category 工厂
 * @author AYOU
 */
public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		switch (shapeType) {
		case "Circle":
			return new Circle();
		case "Rectangle":
			return new Rectangle();
		case "Square":
			return new Square();
		default:
			return null;
		}
	}
}
