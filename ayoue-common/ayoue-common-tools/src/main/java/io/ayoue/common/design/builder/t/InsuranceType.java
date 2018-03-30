package io.ayoue.common.design.builder.t;

import java.math.BigDecimal;
import java.util.List;

/**
 * 险种
 * @author AYOU
 */
public class InsuranceType {
	private List<Risks> riskss;//险别
	
	public List<Risks> getRiskss() {
		return riskss;
	}
	public void setRiskss(List<Risks> riskss) {
		this.riskss = riskss;
	}
	
	
	public void addItem(Risks risks) {
		riskss.add(risks);
	}

	public BigDecimal getCount() {
		// return items.stream().filter(item->{return item.price()}).count();
		BigDecimal count = new BigDecimal("0");
		for (Risks risks : riskss) {
			count.add(risks.getPrice());
		}
		return count;
	}

	public void showItems() {
		for (Risks risks : riskss) {
			System.out.print("Item : " + risks.getName());
			System.out.println(", Price : " + risks.getPrice());
		}
	}
}
