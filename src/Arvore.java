public class Arvore {

	private String[] estrutura;

	public String[] getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(String[] estrutura) {
		this.estrutura = estrutura;
	}
	
	public String getCadeiaGerada(String cadeia) {

		Integer posicao = 1;
		String cadeiaDaArvore = new String();
		String[] estruturaDaArvore = getEstrutura();

		do {
			
			posicao = desceRamoAEsquerda(posicao);

			// ---------------------------------------------------------------------
			// Busca conteudo do filho direito
			// ---------------------------------------------------------------------
			// Se o filho direito é nulo, então seu irmão (à esquerda) é um terminal
			if (estruturaDaArvore[posicao+1] == null) {
				cadeiaDaArvore = cadeiaDaArvore.concat(estruturaDaArvore[posicao]); // terminal do filho esquerdo
				// Rever essa negação. Parece que está dando erro
				if (cadeiaDaArvore.equals(cadeia.substring(0, cadeiaDaArvore.length()-1))) { 
					// Se chegar aqui, então a substring gerada não corresponde à cadeia pesquisada. 
					// Logo, não é necessário perder mais tempo com essa árvore e seus desdobramentos 
					// e ela deve ser descartada
					return "DESCARTAR"; 
				}
			} else {
				return "DERIVAR"; // Derivacao Incompleta: arvore candidata até o momento
			}
			
			// ---------------------------------------------------------------------
			// Retorna ao primeiro filho à direita.
			// ---------------------------------------------------------------------
			posicao/=2;
			while (posicao%2==1) {
				posicao = (posicao-1)/2;
			}
			// ---------------------------------------------------------------------
			// Após retornar ao filho direito, passa ao filho esquerdo para iniciar
			// nova descida no ramo à esquerda através de desceRamoAEsquerda(posicao)
			// ---------------------------------------------------------------------

			posicao++;			
			
		} while (posicao > 1);
		
		// ---------------------------------------------------------------------
		// Se chegamos até aqui, então não foram identificadas variáveis 
		// pendentes de derivação
		// ---------------------------------------------------------------------
		// Verifica se a cadeia produzida pela árvore é a cadeia procurada
		// ---------------------------------------------------------------------
		if (cadeia.equals(cadeiaDaArvore)) {
			return "OK"; // Árvore encontrada
		} else {
			return "DESCARTAR"; // Árvore não gera a cadeia
		}
		// ---------------------------------------------------------------------
		
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

}