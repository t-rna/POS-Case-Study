package pos.domain.discount;

import pos.domain.Sale;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {

	// $1 off $10 or more..
	private float discount = 1.0f;
	private float threshold = 10.0f;
	
	public float getTotal(Sale s) {
		float pdt = s.getPreDiscountTotal();
		if (pdt < threshold )
			return pdt;
		else 
			return pdt - discount;
	}
	
	// Description of the percent discount
	public String discountDesc() {
		return "Discount: $1 off $10 or more";
	}
}
