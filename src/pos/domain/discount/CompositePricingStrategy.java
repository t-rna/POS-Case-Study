package pos.domain.discount;

import pos.domain.Sale;

import java.util.*;

public abstract class CompositePricingStrategy implements ISalePricingStrategy {

	protected List<ISalePricingStrategy> strategies 
						= new ArrayList<ISalePricingStrategy>();
	
	public void add(ISalePricingStrategy s) {
		strategies.add(s);
	}
	
	public abstract float getTotal(Sale s);
}
