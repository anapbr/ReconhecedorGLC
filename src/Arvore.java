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
			// Se o filho direito � nulo, ent�o seu irm�o (� esquerda) � um terminal
			if (estruturaDaArvore[posicao+1] == null) {
				cadeiaDaArvore = cadeiaDaArvore.concat(estruturaDaArvore[posicao]); // terminal do filho esquerdo
				// Rever essa nega��o. Parece que est� dando erro
				if (cadeiaDaArvore.equals(cadeia.substring(0, cadeiaDaArvore.length()-1))) { 
					// Se chegar aqui, ent�o a substring gerada n�o corresponde � cadeia pesquisada. 
					// Logo, n�o � necess�rio perder mais tempo com essa �rvore e seus desdobramentos 
					// e ela deve ser descartada
					return "DESCARTAR"; 
				}
			} else {
				return "DERIVAR"; // Derivacao Incompleta: arvore candidata at� o momento
			}
			
			// ---------------------------------------------------------------------
			// Retorna ao primeiro filho � direita.
			// ---------------------------------------------------------------------
			posicao/=2;
			while (posicao%2==1) {
				posicao = (posicao-1)/2;
			}
			// ---------------------------------------------------------------------
			// Ap�s retornar ao filho direito, passa ao filho esquerdo para iniciar
			// nova descida no ramo � esquerda atrav�s de desceRamoAEsquerda(posicao)
			// ---------------------------------------------------------------------

			posicao++;			
			
		} while (posicao > 1);
		
		// ---------------------------------------------------------------------
		// Se chegamos at� aqui, ent�o n�o foram identificadas vari�veis 
		// pendentes de deriva��o
		// ---------------------------------------------------------------------
		// Verifica se a cadeia produzida pela �rvore � a cadeia procurada
		// ---------------------------------------------------------------------
		if (cadeia.equals(cadeiaDaArvore)) {
			return "OK"; // �rvore encontrada
		} else {
			return "DESCARTAR"; // �rvore n�o gera a cadeia
		}
		// ---------------------------------------------------------------------
		
	}
	
	private Integer desceRamoAEsquerda(Integer posicao) {
		String[] estrutura = getEstrutura();
		Integer tamanhoArvore = estrutura.length;
		
		while (posicao < tamanhoArvore-1) {
			if (posicao % 2 == 0 && estrutura[posicao + 1] == null) {
				// Ultimo filho � esquerda do ramo pesquisado
				return posicao;
			} else {
				// Pega o pr�ximo filho � esquerda
				posicao *= 2;
			}

		}

		return posicao / 2;
	}

}