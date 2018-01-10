package pos.domain;

public class SalesLineItem 
{
	private int quantity;
	private ProductDescription description;
	
	public SalesLineItem (ProductDescription desc, int quantity )
	{
		this.description = desc;
		this.quantity = quantity;
	}
	
	public float getSubtotal()
	{
		return description.getPrice() * quantity;
	}
}
