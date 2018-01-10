package pos.domain.discount;

import pos.domain.Sale;

public interface ISalePricingStrategy {
	
	public float getTotal(Sale s);
	public String discountDesc();
}
