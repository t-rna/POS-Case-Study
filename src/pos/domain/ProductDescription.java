package pos.domain;

public class ProductDescription 
{
	private String id;
	private float price;
	private String description;
	
	public ProductDescription( String id, float price, String description )
	{
		this.id = id;
		this.price = price;
		this.description = description;
	}
	
	public String getItemID() { return id; }
	public float getPrice() { return price; }
	public String getDescription() { return description; }
	
	// Added to display ProductDescription information
	public String toString() {
		return "ItemID: " + id + ", \"" + description + "\", $" + price;
	}
}
