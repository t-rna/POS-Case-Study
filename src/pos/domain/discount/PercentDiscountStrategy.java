package pos.domain.discount;

import pos.domain.Sale;

public class PercentDiscountStrategy implements ISalePricingStrategy{

	// Assumes a default percent discount of 5%
	private float percentage = 0.95f;
	
	public float getTotal(Sale s) {
		return s.getPreDiscountTotal() * percentage;
	}
	
	// Description of the percent discount
	public String discountDesc() {
		return "Discount: 5% off";
	}
}
