package exemplos.grafos.largura;

/**
 * 22.2-6 Existem dois tipos de lutadores: "bons sujeitos" e "maus sujeitos". Entre qualquer par de lutadores
 * profissionais pode ou não haver uma rivalidade. Suponha que temos n lutadores profissionais e temos uma lista
 * de r pares de lutadores para os quais existem rivalidades. Dê um algoritmo de tempo O(n + r) que determine se
 * é possível designar alguns dos lutadores como bons sujeitos e os restantes como maus sujeitos, de tal forma que
 * a rivalidade ocorra em cada caso entre um bom sujeito e um mau sujeito. Se for possível realizar tal designação,
 * seu algoritmo devia produzi-la.
 */
public class MainBuscaLargura {

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);
        grafo.adicionaAresta(0, 1);
        grafo.adicionaAresta(1, 2);
        grafo.adicionaAresta(2, 0);
        grafo.adicionaAresta(2, 3);
        grafo.adicionaAresta(3, 4);

        grafo.imprimeGrafo();
        
        boolean result = grafo.bomOuMau();
        System.out.println("O grafo é " + (result ? "BOM" : "MAU"));
    }


}
