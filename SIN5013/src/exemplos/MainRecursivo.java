package exemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class MainRecursivo {

	public static void main(String[] args) {

	
		List<Integer> vetor = new ArrayList<>();
		vetor.addAll(Arrays.asList(4,7,-3,8,1));
		
		int soma = 0;
		calculaSomaVetor(vetor, soma);

	}

	private static void calculaSomaVetor(List<Integer> vetor, int soma) {
		if (vetor.size()-1 == 0)
		{
			soma += vetor.get(vetor.size()-1);
			System.out.println("acabou a soma com soma = "+ soma);
		} else {
			if (vetor.get(vetor.size()-1) > 0)
			{
				System.out.println("O tamanho do vetor é "+ vetor.size());
				System.out.println("O valor que temos na posição "+ (vetor.size()-1) + " do vetor é " + vetor.get(vetor.size()-1));
				System.out.println("Soma estava com "+ soma);
				soma += (int) vetor.get(vetor.size()-1);
				System.out.println("agora Soma tem "+ soma);
			}
			System.out.println("Execução da recursão com vetor de tamanho "+ (vetor.size()-1));
			System.out.println(vetor);
			calculaSomaVetor(vetor.subList(0, vetor.size()-1), soma);
		}
		
	}

	
}
