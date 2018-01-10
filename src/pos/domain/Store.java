package pos.domain;

public class Store 
{
	private ProductCatalog catalog;
	private Register register;
	
	public Store() 
	{
		catalog = ProductCatalog.getInstance();	// Singleton
		register = new Register( catalog );
	}
	
	public Register getRegister() { return register; }
}
