package exemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MainProcuraValorFora {

	public static void main(String[] args) {

		// n = 11
		List<Integer> vetor = new ArrayList<>();
		vetor.addAll(Arrays.asList(1, 3, 5, 4, 0, 2, 7, 9, 10, 6));

		int[] vetor2 = new int[11];

		procuraValorForaDoVetor(vetor);
		System.out.println(encontraDiferente(vetor));

	}

	private static void procuraValorForaDoVetor(List<Integer> vetor) {
		// contador de 0 até n-1
		int contador = 0;
		for (int i = 0; i < vetor.size(); i++) {
			if (vetor.get(i) == contador) {
				contador++;
				i = -1;
			} else {
				if (i == vetor.size() - 1) {
					System.out.println(contador);
					break;
				}
			}

		}

	}

	static int encontraDiferente(List<Integer> vetor) {
		int i;
		int soma1 = 0, soma2 = 0, n = vetor.size();
		for (i = 0; i <= n - 1; i++) {
			soma1 += i;
			if (vetor.get(i) >= 0 && vetor.get(i) <= n - 1)
				soma2 += vetor.get(i);
		}
		return (soma1 - soma2);
	}
}
