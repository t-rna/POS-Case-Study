package pos.domain.tax;

public class OntarioTaxAdapter implements ITaxCalculatorAdapter{
	
	public float getTaxRate() {
		return 1+(new OntarioTaxRate().getOntarioTaxRate());
	}
	
	public String taxDesc() {
		return "HST: " + Math.round((getTaxRate()-1)*100) + "%";
	}
}
