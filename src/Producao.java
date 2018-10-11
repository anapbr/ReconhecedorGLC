public class Producao {

	private String lhs;
	private String[] rhs = new String[2];
	
	public Producao (String lhs, String[] rhs) {
		setLhs(lhs);
		setRhs(rhs);
	}
	
	public String getLhs() {
		return lhs;
	}
	
	public void setLhs(String lhs) {
		this.lhs = lhs;
	}
	
	public String[] getRhs() {
		return rhs;
	}
	
	public void setRhs(String[] rhs) {
		this.rhs = rhs;
	}
	
}
