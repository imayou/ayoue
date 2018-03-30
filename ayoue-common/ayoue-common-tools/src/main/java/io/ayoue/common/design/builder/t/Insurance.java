package io.ayoue.common.design.builder.t;

import java.util.List;

public interface Insurance {
	public String name();//名称
	public List<InsuranceType> insuranceTypes();//险种
	public float price();//价格
	public void calc();//计算
}
