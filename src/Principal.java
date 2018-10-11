import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {

		// ------------------------------------------------------------------------------------------------
		// CRIANDO A GRAMÁTICA
		// ------------------------------------------------------------------------------------------------
		
		GLC glc = new GLC();

		// ------------------------------------------------------------------------------------------------
		
		glc.setEstadoInicial("S");

		// ------------------------------------------------------------------------------------------------
		
		ArrayList<String> variaveis = new ArrayList<String>();
		variaveis.add("S");
		variaveis.add("A");
		variaveis.add("B");		
				
		glc.setVariaveis(variaveis);

		// ------------------------------------------------------------------------------------------------

		ArrayList<String> terminais = new ArrayList<String>();
		terminais.add("a");
		terminais.add("b");
		
		glc.setTerminais(terminais);

		// ------------------------------------------------------------------------------------------------		
		
		ArrayList<Producao> producoes = new ArrayList<Producao>();
		
		producoes.add(new Producao("S", new String[]{"A", "B"}));
		producoes.add(new Producao("A", new String[]{"A", "A"}));
		producoes.add(new Producao("A", new String[]{"a", null}));
		producoes.add(new Producao("B", new String[]{"B", "B"}));
		producoes.add(new Producao("B", new String[]{"b", null}));
				
		glc.setProducoes(producoes);

		// ------------------------------------------------------------------------------------------------		
		
		Arvore arvore = new Arvore();
		arvore.setEstrutura(new String[] {"", glc.getEstadoInicial()});
		
		System.out.println(glc.reconheceCadeia(arvore, glc, "aaab"));
		
	}

}