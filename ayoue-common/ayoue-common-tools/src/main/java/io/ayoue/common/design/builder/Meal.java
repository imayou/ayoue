package io.ayoue.common.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 * @author AYOU
 */
public class Meal {
	List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCount() {
		// return items.stream().filter(item->{return item.price()}).count();
		float count = 0.0f;
		for (Item item : items) {
			count += item.price();
		}
		return count;
	}

	public void showItems() {
		for (Item item : items) {
			System.out.print("Item : " + item.name());
			System.out.print(", Packing : " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}
	}

}
