package pos.domain.tax;

public class QuebecTaxAdapter implements ITaxCalculatorAdapter {
	
	public float getTaxRate() {
		return 1+(new QuebecTaxRate().getQuebecTaxRate());
	}
	
	public String taxDesc() {
		return "QST: " + Math.round((getTaxRate()-1)*100) + "%";
	}
}
