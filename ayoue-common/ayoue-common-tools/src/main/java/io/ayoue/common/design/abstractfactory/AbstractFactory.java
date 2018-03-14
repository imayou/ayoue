package io.ayoue.common.design.abstractfactory;

/**
 * @category 抽象工厂
 * @author AYOU
 */
public abstract class AbstractFactory {
	abstract Color getColor(String color);//颜色
	abstract Shape getShape(String shape);//形状
}
