package pos.domain.tax;

import java.util.*;
import java.io.*;

// Factory that deals with taxes
public class TaxesFactory {
	
	private static TaxesFactory instance;	// Singleton
	private ITaxCalculatorAdapter taxCalculatorAdapter;
	
	private TaxesFactory() {}
	
	public static TaxesFactory getInstance() {
		if (instance == null)
			instance = new TaxesFactory();
		return instance;
	}
	
	// Return tax calculator adapter
	public ITaxCalculatorAdapter getTaxCalculatorAdapter() {
	
		if (taxCalculatorAdapter == null) {
			
			// Read from configuration file that is stored in Java properties file format...
			Properties prop = new Properties();
			InputStream input = null;
			String filename = "config.properties";
			
			try {
				input = TaxesFactory.class.getResourceAsStream(filename);
				
				if (input == null) 
				{
					System.out.println("Failed to open configuration file.");
					return null;
				}
				
				prop.load(input);
				String value = null;
				
				for (String key : prop.stringPropertyNames()) {
					if (key.equals("TAX_CALC")) {
						value = prop.getProperty(key);
					}
				}
				
				if (value == null) {
					System.out.println("Could not read TAX_CALC entry.");
					return null;
				}
				
				taxCalculatorAdapter = (ITaxCalculatorAdapter)
											Class.forName("pos.domain.tax."+value).newInstance();
				// note: this doesn't work if class has no parameterless constructor while having other constructors
				//       or parameterless constructor is inaccessible.
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return taxCalculatorAdapter;
	}
}
