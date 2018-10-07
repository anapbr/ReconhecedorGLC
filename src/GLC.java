import java.util.ArrayList;

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
	
	public Arvore reconheceCadeia (String estado, GLC glc, String cadeia) {
		
		
		
		return null;
	} 
	
}
