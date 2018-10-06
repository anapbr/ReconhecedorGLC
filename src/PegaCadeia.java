public class PegaCadeia {
	
	public static void main(String[] args) {

		Arvore arvore = new Arvore(); 
		
		arvore.setEstrutura(new String[] {"", "S", "A", "B", "A", "A", "b", null, "a", null, "a", null});
	
		arvore.setCadeia("aab");
		
		System.out.println("Cadeia derivada: "+arvore.getCadeiaGerada());
		
	}

}