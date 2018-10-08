import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GLC {

	private String estadoInicial;
	private ArrayList<String> variaveis;
	private ArrayList<String> terminais;
	private ArrayList<Producao> producoes;
	
	public String getEstadoInicial() {
		return estadoInicial;
	}
	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	public ArrayList<String> getVariaveis() {
		return variaveis;
	}
	public void setVariaveis(ArrayList<String> variaveis) {
		this.variaveis = variaveis;
	}
	public ArrayList<String> getTerminais() {
		return terminais;
	}
	public void setTerminais(ArrayList<String> terminais) {
		this.terminais = terminais;
	}
	public ArrayList<Producao> getProducoes() {
		return producoes;
	}
	public void setProducoes(ArrayList<Producao> producoes) {
		this.producoes = producoes;
	}
	
	public Arvore reconheceCadeia (Arvore arvore, GLC glc, String cadeia) {
		
		String cadeiaGerada = arvore.getCadeiaGerada(cadeia);
		
		if (cadeiaGerada.equals(cadeia)) {
			return arvore;
		} else {
			
			derivaArvore(arvore);
			
		}
				
		System.out.println(cadeiaGerada);
				
		return arvore;
	}
	private void derivaArvore(Arvore arvore) {
		
		Integer tamanhoArvore = arvore.getEstrutura().length;
		String[] estruturaArvore = arvore.getEstrutura();
		String[] estruturaNovaArvore = new String[tamanhoArvore+2];
		
		Queue<Arvore> filaArvores = new LinkedList<Arvore>();
		
		for (Producao producao : producoes) {
			
			if (producao.getLhs().equals(estruturaArvore[tamanhoArvore-1])) {
				Arvore novaArvore = new Arvore();
				estruturaNovaArvore = estruturaArvore; 
				estruturaNovaArvore[tamanhoArvore-2]=producao.getRhs()[0];
				estruturaNovaArvore[tamanhoArvore-1]=producao.getRhs()[1];
				
				novaArvore.setEstrutura(estruturaNovaArvore);
				
				// Adicionar à fila
				estruturaNovaArvore.toString();
					
			}
			
		}
		
	} 
	
}
