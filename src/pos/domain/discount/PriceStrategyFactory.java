package pos.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

// Factory that deals with pricing strategies...
public class PriceStrategyFactory {
	
	private static PriceStrategyFactory instance;	// Singleton
	private ISalePricingStrategy pricingStrategy;
	private CompositePricingStrategy compositePricingStrategy;
	
	private PriceStrategyFactory() {}
	
	public static PriceStrategyFactory getInstance() {
		if (instance == null)
			instance = new PriceStrategyFactory();
		return instance;
	}
	
	// Strategy Pattern
	public ISalePricingStrategy getSalePricingStrategy() {
		
		if (pricingStrategy == null) {
			LocalDateTime dt = LocalDateTime.now();
			DayOfWeek today = dt.getDayOfWeek();

			if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY)
				pricingStrategy = new AbsoluteDiscountOverThresholdPricingStrategy();
			else 
				pricingStrategy = new PercentDiscountStrategy();
		}
		return pricingStrategy;
	}
	
	// Composite pattern - note: all pricing strategies are of type ISalePricingStrategy
	public ISalePricingStrategy getCompositeSalePricingStrategy() {
		
		if (compositePricingStrategy == null) {
			
			compositePricingStrategy= new CompositeBestForCustomerPricingStrategy();
			compositePricingStrategy.add(new PercentDiscountStrategy()); // default strategy is PercentDiscountStrategy
			
			// ... do work ...
			// add another pricing strategy
			compositePricingStrategy.add(new AbsoluteDiscountOverThresholdPricingStrategy());
		}
		return compositePricingStrategy;
	}
}
