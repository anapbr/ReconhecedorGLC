public class Principal {
	
	public static void main(String[] args) {

		Arvore arvore = new Arvore(); 
		
		arvore.setEstrutura(new String[] {"", "S", "A", "B", "A", "A", "b", null, "a", null, "a", null});
		arvore.setCadeia("aab");
		System.out.println(arvore.getCadeiaGerada());
		
		arvore.setEstrutura(new String[] {"", "S", "A", "B", "b", null, "a", null});
		arvore.setCadeia("baa");
		System.out.println(arvore.getCadeiaGerada());		
		
		arvore.setEstrutura(new String[] {"", "S", "a", null});
		arvore.setCadeia("ba");		
		System.out.println(arvore.getCadeiaGerada());
		
		arvore.setEstrutura(new String[] {"", "S", "A", "B", "a", null});
		arvore.setCadeia("a");		
		System.out.println(arvore.getCadeiaGerada());
		
		arvore.setEstrutura(new String[] {"", "S", "A", "B", "a", null, "a", null});
		arvore.setCadeia("aa");		
		System.out.println(arvore.getCadeiaGerada());
		
		arvore.setEstrutura(new String[] {"", "S"});
        arvore.setCadeia("");
		System.out.println(arvore.getCadeiaGerada());
		
	}

}