package pos.domain;

public class Register 
{
	private ProductCatalog catalog;
	private Sale currentSale;
	
	public Register( ProductCatalog catalog )
	{
		this.catalog = catalog;
	}
	
	public void endSale()
	{
		currentSale.becomeComplete();
		
		// represents a msg sent to the UI layer
		currentSale.printSale();
	}
	
	public void enterItem( String id, int quantity )
	{
		ProductDescription desc = catalog.getProductDescription( id );
		
		// Simple guard to make sure the SalesLineItem we're creating is 
		// an actual item listed in the ProductCatalog
		if (desc != null)
		{
			currentSale.makeLineItem( desc, quantity );
			System.out.println(">>> " + desc + " [x" + quantity + "]");
		}
		else
			System.out.println(">>> Item " + id + " not found.");
	}
	
	public void makeNewSale()
	{
		currentSale = new Sale();
	}
	
	public void makePayment( float cashTendered )
	{
		currentSale.makePayment( cashTendered );
		
		// System msg represents a msg to the UI layer
		System.out.println("Change due: " + currentSale.getBalance());
	}
	
	public Sale getSale() 
	{
		return currentSale;
	}
	
	public ProductCatalog getProductCatalog()
	{
		return catalog;
	}
}
