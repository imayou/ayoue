package io.ayoue.common.design.builder;

import io.ayoue.common.design.builder.impl.ChickenBurger;
import io.ayoue.common.design.builder.impl.Coke;
import io.ayoue.common.design.builder.impl.Pepsi;
import io.ayoue.common.design.builder.impl.VegBurger;

/**
 * 套餐列表
 * @author AYOU
 */
public class MealBuilder {
	/**
	 * 素食套餐
	 * @return
	 */
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	/**鸡肉套餐
	 * @return
	 */
	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
