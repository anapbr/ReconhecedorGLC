import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GLC {

	private String estadoInicial;
	private ArrayList<String> variaveis;
	private ArrayList<String> terminais;
	private ArrayList<Producao> producoes;
	private List<Arvore> fila = new ArrayList<Arvore>();
	
	public Arvore getElementoFila () {
		
		Arvore arvore = getFila().get(0);
		
		getFila().remove(0);
		
		return arvore;
	}
	
	public void setElementoFila(Arvore arvore) {
		System.out.println("fila "+fila);
		System.out.println("arvore "+arvore);
		getFila().add(arvore);
	}
	
	public List<Arvore> getFila() {
		return fila;
	}
	public void setFila(List<Arvore> fila) {
		this.fila = fila;
	}
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
		
		String resultado = arvore.getCadeiaGerada(cadeia);
		
		System.out.println(resultado);
		
		if (resultado.equals("OK")) {
			return arvore; // Encontrada a árvore que deriva a cadeia pesquisada
		} else {
			
			if (resultado.equals("DERIVAR")) {
				
				derivaArvore(arvore);
					
			}
			
			if (getFila().size()>0) {
				arvore = getElementoFila();
				reconheceCadeia(arvore, glc, cadeia);
			} else {
				return null;
			}
			
		}
		
		return null;
		
	}
	
	private void derivaArvore(Arvore arvore) {
		
		Integer tamanhoArvore = arvore.getEstrutura().length;
		String[] estruturaArvore = arvore.getEstrutura();
		String[] estruturaNovaArvore = new String[tamanhoArvore+2];
		
		for (Producao producao : producoes) {
			
			if (producao.getLhs().equals(estruturaArvore[tamanhoArvore/2])) {
				Arvore novaArvore = new Arvore();
				// ---------------------------------------------------
				// SETA NOVA ARVORE
				for (int i=0; i<tamanhoArvore; i++) {
					estruturaNovaArvore[i]=estruturaArvore[i];
				}
				estruturaNovaArvore[tamanhoArvore]=producao.getRhs()[0];
				estruturaNovaArvore[tamanhoArvore+1]=producao.getRhs()[1];
				// ---------------------------------------------------
				
				novaArvore.setEstrutura(estruturaNovaArvore);
				
				// Adicionar à fila
				setElementoFila(novaArvore);
				arvore=novaArvore;
			}
			
		}
		
	}
	
}