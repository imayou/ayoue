package io.ayoue.common.design.abstractfactory;

import io.ayoue.common.design.factory.Circle;
import io.ayoue.common.design.factory.Rectangle;
import io.ayoue.common.design.factory.Square;

public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		switch (shape) {
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
