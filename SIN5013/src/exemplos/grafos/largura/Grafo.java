package exemplos.grafos.largura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {
	/**
	 * BRANCO: não visitado
	 * CINZA: visitado
	 * PRETO: não possui mais arestas disponíveis
	 *
	 */
	enum Cor {
	    BRANCO, CINZA, PRETO
	}

	enum Indole {
	    BOM, MAU
	}
	
	private int vertices;
    private List<Integer>[] listaDeAdjacencia;
    private Cor[] cor;
    private Indole[] indole;

    Grafo(int vertices) {
        this.vertices = vertices;
        listaDeAdjacencia = new ArrayList[vertices];
        cor = new Cor[vertices];
        indole = new Indole[vertices];

        for (int i = 0; i < vertices; i++) {
        	listaDeAdjacencia[i] = new ArrayList<>();
            cor[i] = Cor.BRANCO;
            indole[i] = null;
        }
    }

    void adicionaAresta(int origem, int destino) {
    	listaDeAdjacencia[origem].add(destino);
    }

    boolean bomOuMau() {
        for (int u = 0; u < vertices; u++) {
            cor[u] = Cor.BRANCO;
            indole[u] = null;
        }

        for (int s = 0; s < vertices; s++) {
            if (cor[s] == Cor.BRANCO) {
                cor[s] = Cor.CINZA;
                indole[s] = Indole.BOM;

                Queue<Integer> fila = new LinkedList<>();
                fila.add(s);

                while (!fila.isEmpty()) {
                    int u = fila.poll();
                    Indole estado;

                    if (indole[u] == Indole.BOM) {
                        estado = Indole.MAU;
                    } else {
                        estado = Indole.BOM;
                    }

                    for (int v : listaDeAdjacencia[u]) {
                        if (cor[v] == Cor.BRANCO) {
                            cor[v] = Cor.CINZA;
                            indole[v] = estado;
                            fila.add(v);
                        } else if (indole[u] == indole[v]) {
                            return false;
                        }
                    }

                    cor[u] = Cor.PRETO;
                }
            }
        }

        return true;
    }
    void imprimeGrafo() {
        for (int v = 0; v < vertices; v++) {
            System.out.print("Adjacências do vértice " + v + ": ");
            for (int adj : listaDeAdjacencia[v]) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }
}
