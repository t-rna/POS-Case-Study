package pos.domain.discount;

import pos.domain.Sale;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy{
	
	private String bestStrategy;

	// Finds the pricing strategy that gives the customer the lowest price
	public float getTotal(Sale s) {
		float lowestTotal = Integer.MAX_VALUE;
		
		for(ISalePricingStrategy strat : strategies) {
			float total = strat.getTotal(s);
			if (total < lowestTotal) {
				lowestTotal = total;
				bestStrategy = strat.discountDesc();
			}	
		}
		return lowestTotal;
	}
	
	public String discountDesc() {
		return bestStrategy;
	}
}
