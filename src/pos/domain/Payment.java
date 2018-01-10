package pos.domain;

public class Payment 
{
	private float amount;
	
	public Payment( float cashTendered ){ amount = cashTendered; }
	public float getAmount() { return amount; }
}

