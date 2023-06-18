package exemplos.grafos.profundidade;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grafo {
	 private int vertices; // Número de vértices
	    private LinkedList<Integer>[] listaDeAdjacencia; // Lista de adjacência

	    Grafo(int vertices) {
	        this.vertices = vertices;
	        listaDeAdjacencia = new LinkedList[vertices];
	        for (int i = 0; i < vertices; ++i)
	            listaDeAdjacencia[i] = new LinkedList<>();
	    }

	    void adicionaAresta(int origem, int destino) {
	    	listaDeAdjacencia[origem].add(destino);
	    }

	    void buscaProfundidade(int verticeInicial) {
	        boolean[] visited = new boolean[vertices]; // Array para marcar os vértices visitados
	        visitar(verticeInicial, visited);
	    }

	    void visitar(int vertice, boolean[] visited) {
	        visited[vertice] = true;
	        System.out.print(vertice + " ");

	        Iterator<Integer> it = listaDeAdjacencia[vertice].listIterator();
	        while (it.hasNext()) {
	            int n = it.next();
	            if (!visited[n])
	            	visitar(n, visited);
	        }
	    }
	    void desenhaGrafo() {
	        JFrame frame = new JFrame("Graph Visualization");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 500);

	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);

	                int radius = 20;
	                int centerX = getWidth() / 2;
	                int centerY = getHeight() / 2;

	                // Desenha os vértices
	                for (int v = 0; v < vertices; v++) {
	                    double angle = 2 * Math.PI * v / vertices;
	                    int x = (int) (centerX + Math.cos(angle) * 150);
	                    int y = (int) (centerY + Math.sin(angle) * 150);
	                    g.setColor(Color.BLUE);
	                    g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

	                    g.setColor(Color.WHITE);
	                    g.drawString(Integer.toString(v), x - 5, y + 5);
	                }

	                // Desenha as arestas
	                for (int v = 0; v < vertices; v++) {
	                    int startX = (int) (centerX + Math.cos(2 * Math.PI * v / vertices) * 150);
	                    int startY = (int) (centerY + Math.sin(2 * Math.PI * v / vertices) * 150);

	                    Iterator<Integer> it = listaDeAdjacencia[v].listIterator();
	                    while (it.hasNext()) {
	                        int n = it.next();
	                        int endX = (int) (centerX + Math.cos(2 * Math.PI * n / vertices) * 150);
	                        int endY = (int) (centerY + Math.sin(2 * Math.PI * n / vertices) * 150);
	                        g.setColor(Color.BLACK);
	                        g.drawLine(startX, startY, endX, endY);
	                    }
	                }
	            }
	        };

	        frame.add(panel);
	        frame.setVisible(true);
	    }

}
