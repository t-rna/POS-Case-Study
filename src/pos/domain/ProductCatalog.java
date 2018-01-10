package pos.domain;

import java.util.*;

public class ProductCatalog 
{	
	private static ProductCatalog instance;
	private Map<String, ProductDescription> descriptions = new HashMap<String, ProductDescription>();
	
	private ProductCatalog()
	{
		// sample data
		descriptions.put("100", new ProductDescription("100", 2, "milk"));
		descriptions.put("101", new ProductDescription("101", 5, "cake"));
		descriptions.put("102", new ProductDescription("102", 3, "noodle"));

		descriptions.put("201", new ProductDescription("201", 2, "pen"));
		descriptions.put("202", new ProductDescription("202", 1, "pencil"));
		descriptions.put("203", new ProductDescription("203", 3, "paper"));
	}

	public ProductDescription getProductDescription( String id )
	{
		return descriptions.get( id );
	}
	
	// Singleton
	public static ProductCatalog getInstance() 
	{
		if (instance == null)
			instance = new ProductCatalog();
		return instance;
	}
}
