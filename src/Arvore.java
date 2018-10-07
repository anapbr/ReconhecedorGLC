public class Arvore {

	private String[] estrutura;

	private String cadeia = new String();

	public String[] getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(String[] estrutura) {
		this.estrutura = estrutura;
	}

	public String getCadeia() {
		return cadeia;
	}

	public String getCadeiaGerada() {

		Integer posicao = 1;
		String cadeiaDaArvore = new String();
		String[] estrutura = getEstrutura();
		String cadeia = getCadeia();

		do {
			posicao = desceRamoAEsquerda(posicao);

			// ---------------------------------------------------------------------
			// Busca conteudo do filho direito
			// ---------------------------------------------------------------------
			// Se o filho direito é nulo, então seu irmão (à esquerda) é um terminal
			if (estrutura[posicao+1] == null) {
				cadeiaDaArvore = cadeiaDaArvore.concat(estrutura[posicao]); // terminal do filho esquerdo
				if (cadeiaDaArvore.equals(cadeia.substring(0, cadeiaDaArvore.length()-1))) {
					return "Cadeia Incorreta";
				}
			} else {
				return "Derivacao Incompleta";
			}

			posicao/=2;
			while (posicao%2==1) {
				posicao = (posicao-1)/2;
			}
			posicao++;
			
			// ---------------------------------------------------------------------

		} while (posicao > 1);

		// Trata casos onde a cadeiaGerada é uma substring da cadeia pesquisada
		if (cadeia.equals(cadeiaDaArvore)) {
			return cadeiaDaArvore;
		} else {
			return "Cadeia Incorreta";
		}
		
	}
	
	private Integer desceRamoAEsquerda(Integer posicao) {
		String[] estrutura = getEstrutura();
		Integer tamanhoArvore = estrutura.length;
		
		while (posicao < tamanhoArvore-1) {
			if (posicao % 2 == 0 && estrutura[posicao + 1] == null) {
				// Ultimo filho à esquerda do ramo pesquisado
				return posicao;
			} else {
				// Pega o próximo filho à esquerda
				posicao *= 2;
			}

		}

		return posicao / 2;
	}

	public void setCadeia(String cadeia) {
		this.cadeia = cadeia;
	}

}