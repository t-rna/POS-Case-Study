package pos.domain;

import pos.domain.tax.*;
import pos.domain.discount.*;

import java.util.*;

public class Sale 
{
	private List<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private Date date = new Date();
	private boolean isComplete = false;
	private Payment payment;
	
	// Each sale has an associated tax calculator and pricing strategy
	private ITaxCalculatorAdapter taxCalculator 
					= TaxesFactory.getInstance().getTaxCalculatorAdapter();
	private ISalePricingStrategy salePricingStrategy
					= PriceStrategyFactory.getInstance().getCompositeSalePricingStrategy(); // use a composite strategy
	
	public float getBalance()
	{
		return payment.getAmount() - getTotalTax();
	}
	
	public void becomeComplete() { isComplete = true; }
	public boolean isComplete() { return isComplete; }
	
	public void makeLineItem( ProductDescription desc, int quantity )
	{
		lineItems.add( new SalesLineItem( desc, quantity ) );
	}
	
	// Formerly the method getTotal, renamed to reflect that it is pre-discount total.
	public float getPreDiscountTotal()
	{
		float total = 0;
		for ( SalesLineItem lineItem : lineItems )
		{
			total += lineItem.getSubtotal();
		}
		
		return total;
	}
	
	public void makePayment( float cashTendered )
	{
		payment = new Payment( cashTendered );
	}
	
	public List<SalesLineItem> getLineItems() {
		return lineItems;
	}
	
	// Strategy
	public float getTotalAfterDiscouting()
    {
        return salePricingStrategy.getTotal(this);
    }
	
	// Tax Adapter
    public float getTotalTax()
    {
        return taxCalculator.getTaxRate() * getTotalAfterDiscouting();
    }
    
    // Prints sale information to console
    public void printSale() {
    	System.out.println("SubTotal: " + getPreDiscountTotal());
    	System.out.println("Total: " + getTotalTax());
    	System.out.println(taxCalculator.taxDesc());
    	System.out.println(salePricingStrategy.discountDesc());
    }
}
