package io.ayoue.common.design.builder;

/**
 * 商品
 * @author AYOU
 */
public interface Item {
	public String name();//名称
	public Packing packing();//包装
	public float price();//价格
}
