package io.ayoue.common.design.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		if (color == null) {
			return null;
		}
		switch (color) {
		case "Blue":
			return new Blue();
		case "Red":
			return new Red();
		case "Green":
			return new Green();
		default:
			return null;
		}
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}

}
