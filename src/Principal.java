import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {

		// ------------------------------------------------------------------------------------------------
		// CRIANDO A GRAMÁTICA
		// ------------------------------------------------------------------------------------------------
		
		GLC glc = new GLC();

		// ------------------------------------------------------------------------------------------------
		
		glc.setEstadoInicial("S");
		
		ArrayList<String> variaveis = new ArrayList<String>();
		variaveis.add("S");
		variaveis.add("A");
		variaveis.add("B");		
		
		// ------------------------------------------------------------------------------------------------
		
		glc.setVariaveis(variaveis);
		
		ArrayList<String> terminais = new ArrayList<String>();
		terminais.add("a");
		terminais.add("b");
		
		// ------------------------------------------------------------------------------------------------		
		
		glc.setTerminais(terminais);
		
		ArrayList<Producao> producoes = new ArrayList<Producao>();
		
		Producao producao = new Producao();
		producao.setLhs("S");
		producao.setRhs(new String[]{"A", "B"});
		
		producoes.add(producao);
		
		producao.setLhs("A");
		producao.setRhs(new String[]{"A", "A"});

		producoes.add(producao);
		
		producao.setLhs("A");
		producao.setRhs(new String[]{"a", null});

		producoes.add(producao);
		
		producao.setLhs("B");
		producao.setRhs(new String[]{"B", "B"});

		producoes.add(producao);
		
		producao.setLhs("B");
		producao.setRhs(new String[]{"b", null});

		producoes.add(producao);
		
		glc.setProducoes(producoes);

		// ------------------------------------------------------------------------------------------------		
		
		Arvore arvore = new Arvore();
		arvore.setEstrutura(new String[] {"", "S", "a", null});
		
		glc.reconheceCadeia(arvore, glc, "a");
		
		/*Arvore arvore = new Arvore();
		
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
		*/
	}

}