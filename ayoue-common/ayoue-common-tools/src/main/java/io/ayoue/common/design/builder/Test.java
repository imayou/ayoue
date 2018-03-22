package io.ayoue.common.design.builder;

import io.ayoue.common.design.builder.impl.ChickenBurger;
import io.ayoue.common.design.builder.impl.Coke;

public class Test {
	public static void main(String[] args) {
		// 先要有一个套餐列表
		MealBuilder mealBuilder = new MealBuilder();

		// 要一个素食套餐
		Meal vegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("素食套餐价格：" + vegMeal.getCount());
		// 感觉咖啡少了加了一杯
		vegMeal.addItem(new Coke());
		System.out.println("加了一杯咖啡的素食套餐价格：" + vegMeal.getCount());

		// 要一个鸡腿套餐
		Meal chickenMeal = mealBuilder.prepareVegMeal();
		System.out.println("鸡腿套餐价格：" + chickenMeal.getCount());
		//我也吃不饱 我要再加一根鸡腿一杯咖啡
		chickenMeal.addItem(new ChickenBurger());
		chickenMeal.addItem(new Coke());
		System.out.println("加了一个鸡腿一杯咖啡的鸡腿套餐价格：" + chickenMeal.getCount());

	}
}
