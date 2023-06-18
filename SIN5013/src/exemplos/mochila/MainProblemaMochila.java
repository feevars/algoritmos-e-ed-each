package exemplos.mochila;

import java.util.ArrayList;
import java.util.List;

public class MainProblemaMochila {
	
	
	public static void main(String[] args) {
        int n = 4; // numero de itens a serem verificados
        int K = 7; //tamanho da mochila
        int[] S = new int[]{0, 1, 2, 5, 6}; // lista de itens para verificação

        Item[][] mochila = mochila(n, K, S);
        printMatriz(mochila);
        
//        System.out.println(collectValuesRecursively(mochila));
    }
	
	public static Item[][] mochila(int n, int K, int[] S) {
        Item[][] P = new Item[n + 1][K + 1];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                P[i][k] = new Item();
            }
        }

        P[0][0].exist = true;

        for (int k = 1; k <= K; k++) {
            P[0][k].exist = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                P[i][k].exist = false;

                if (P[i - 1][k].exist) {
                    P[i][k].exist = true;
                    P[i][k].belong = false;
                } else if (k - S[i] >= 0) {
                    if (P[i - 1][k - S[i]].exist) { // se o tamanho da mochila - valor do item for válido, ou seja, >= 0, o item cabe na mochila
                        P[i][k].exist = true;
                        P[i][k].belong = true;
                    }
                }
            }
        }
        return P;
    }
	
//    public static List<String> collectValuesRecursively(Item[][] P) {
//        List<String> values = new ArrayList<>();
//        collectValuesRecursively(P, P.length - 1, P[0].length - 1, values);
//        return values;
//    }
//
//    private static void collectValuesRecursively(Item[][] P, int i, int k, List<String> values) {
//        if (i > 0 && k > 0) {
//            if (P[i][k].exist && P[i][k].belong) {
//                values.add("(" + i + ", " + k + ")");
//                collectValuesRecursively(P, i - 1, k - S[i], values);
//            } else {
//                collectValuesRecursively(P, i - 1, k, values);
//            }
//        }
//    }
		
		

	public static void printMatriz(Item[][] P) {
        int n = P.length - 1;
        int K = P[0].length - 1;

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                System.out.print("(" + P[i][k].exist + ", " + P[i][k].belong + ") | ");
            }
            System.out.println();
        }
    }


    

}
