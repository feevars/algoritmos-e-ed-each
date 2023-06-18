package exemplos.grafos.profundidade;

public class MainBuscaProfundidade {

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5); // Criação de um grafo com 5 vértices

        // Adicionando arestas
		grafo.adicionaAresta(0, 1);
		grafo.adicionaAresta(0, 2);
		grafo.adicionaAresta(1, 3);
        grafo.adicionaAresta(2, 4);
        grafo.adicionaAresta(2, 3);
        grafo.adicionaAresta(1, 4);

        System.out.println("Busca em Profundidade (DFS) a partir do vértice 0:");
        grafo.buscaProfundidade(0);
        
        grafo.desenhaGrafo();

	}

}
