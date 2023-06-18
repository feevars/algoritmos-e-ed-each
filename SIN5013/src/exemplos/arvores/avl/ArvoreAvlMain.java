package exemplos.arvores.avl;

public class ArvoreAvlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public No criaNovoNo(int valor) {
		No novo = new No();
		
		novo.altura = 0;
		novo.esquerda = null;
		novo.direita = null;
		novo.valor = valor;
		
		return novo;
		
	}
	
	public int maior(int altura1, int altura2) {
		return altura1 > altura2 ? altura1 : altura2;
	}


	
	public int fatorDeBalanceamento(No no) {
		if (no == null) return 0;
		return no.getAltura(no.esquerda) - no.getAltura(no.direita);
	}
	
	public No rotacaoEsquerda(No noDesbalanceado) { // desbalanceado para a direita, -2
		No noDireita = noDesbalanceado.direita;
		No noEsquerdaDoNoDireita = noDireita.esquerda; // armazenar os filhos da esquerda do nó que vai receber o nó desbalanceado
		
		noDireita.esquerda = noDesbalanceado;
		noDesbalanceado.direita = noEsquerdaDoNoDireita;
		
		//recalcula a altura dos nós
		noDesbalanceado.altura = maior(noDesbalanceado.getAltura(noDesbalanceado.esquerda), noDesbalanceado.getAltura(noDesbalanceado.direita)) + 1;
		noDireita.altura = maior(noDireita.getAltura(noDireita.esquerda), noDireita.getAltura(noDireita.direita)) + 1;
		
		return noDireita; // Nó que era o nó à direita reposicionado no lugar do nó desbalanceado
	}
	
	public No rotacaoDireita(No noDesbalanceado) { // desbalanceado para a esquerda, +2
		No noEsquerda = noDesbalanceado.esquerda;
		No noDireitaDoNoEsquerda = noEsquerda.direita; // armazenar os filhos da direita do nó que vai receber o nó desbalanceado
		
		noEsquerda.direita = noDesbalanceado;
		noDesbalanceado.esquerda = noDireitaDoNoEsquerda;
		
		noDesbalanceado.altura = maior(noDesbalanceado.getAltura(noDesbalanceado.esquerda), noDesbalanceado.getAltura(noDesbalanceado.direita)) + 1;
		noEsquerda.altura = maior(noEsquerda.getAltura(noEsquerda.esquerda), noEsquerda.getAltura(noEsquerda.direita)) + 1;
		
		return noEsquerda;
	}
	
	/*
    Funções para as rotações duplas
	 */
	public No rotacaoEsquerdaDireita(No noDesbalanceado) {
		noDesbalanceado.esquerda = rotacaoEsquerda(noDesbalanceado.esquerda);
		return rotacaoDireita(noDesbalanceado);
	}

	public No rotacaoDireitaEsquerda(No noDesbalanceado) {
		noDesbalanceado.direita = rotacaoDireita(noDesbalanceado.direita);
		return rotacaoEsquerda(noDesbalanceado);
	}
	
	public No inserir(No raiz, int valor) {
		if (raiz == null) return criaNovoNo(valor); // se a árvore está vazia...
		
		if (valor < raiz.esquerda.valor) raiz.esquerda = inserir(raiz.esquerda, valor); // recursão na arvore da esquerda
		if (valor > raiz.direita.valor) raiz.direita = inserir(raiz.direita, valor); // recursão na arvore da direita
		if (valor == raiz.valor) System.out.println("o valor já existe na árvore...");
		
		//verifica a altura da raiz
		raiz.altura = maior(raiz.getAltura(raiz.esquerda), raiz.getAltura(raiz.direita)) + 1;
		
		raiz = balancear(raiz);
		
		return raiz;
	}

	public No remover(No raiz, int valor) {
		if (raiz == null) {
			System.out.println("Nó não encontrado");
			return null;
		}
		
		if (raiz.valor == valor) {
			//remove nós folhas
			if (raiz.esquerda == null && raiz.direita == null) {
				System.out.println("Elemento folha removido");
				return null;
			}
			//remoção de nós que possuem 2 filhos
			if (raiz.esquerda != null && raiz.direita != null) {
				No noAux = raiz.esquerda;
				while (noAux.direita != null) {
					noAux = noAux.direita;
				}
				raiz.valor = noAux.valor;
				noAux.valor = valor;
				System.out.println("elemento trocado");
				raiz.esquerda = remover(raiz.esquerda, valor);
				return raiz;
			}
			//remove nós que possuem 1 filho só
			return raiz.esquerda != null ? raiz.esquerda : raiz.direita;
			
		}
		//faz a recursão e verifica se vai fazer a remoção na sub-árvore da direita ou da esquerda
		if (valor < raiz.valor) {
			raiz.esquerda = remover(raiz.esquerda, valor);
		} else {
			raiz.direita = remover(raiz.direita, valor);
		}
		
		//recalcula a altura de todos os nós entre a raiz e o valor inserido
		raiz.altura = maior(raiz.getAltura(raiz.esquerda), raiz.getAltura(raiz.direita)) + 1;
		
		raiz = balancear(raiz);
		
		return raiz;
	}
	
	/**
	 * balanceia a árvore após inserção ou remoção
	 * @param raiz o nó desbalanceado
	 * @return nova raiz após o balanceamento
	 */
	public No balancear(No raiz) {
		int fb = fatorDeBalanceamento(raiz);
		
		if (fb < -1 && fatorDeBalanceamento(raiz.direita) <= 0) raiz = rotacaoEsquerda(raiz); // raiz com -2 e o filho da direita é -1 ou 0, rotação simples esquerda
		if (fb > 1 && fatorDeBalanceamento(raiz.esquerda) >= 0) raiz = rotacaoDireita(raiz); // raiz com +2 e o filho da esquerda é +1 ou 0, rotação simples direita
		if (fb > 1 && fatorDeBalanceamento(raiz.esquerda) < 0) raiz = rotacaoEsquerdaDireita(raiz); // raiz com +2 e o filho da esquerda é -1, rotação dupla ED
		if (fb < -1 && fatorDeBalanceamento(raiz.direita) > 0) raiz = rotacaoDireitaEsquerda(raiz); // raiz com -2 e o filho da direita é +1, rotação dupla DE
		
		return raiz;
	}
	
}
