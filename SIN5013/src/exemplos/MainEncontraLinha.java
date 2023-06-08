package exemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MainEncontraLinha {

	public static void main(String[] args) {

	
		List<List<Integer>> vetor = new ArrayList<>();
		vetor.add(Arrays.asList(1,1,0,0,0,0,0));
		vetor.add(Arrays.asList(1,0,0,0,0,0,0));
		vetor.add(Arrays.asList(1,1,1,0,0,0,0));
		vetor.add(Arrays.asList(1,1,1,1,1,1,0));
		vetor.add(Arrays.asList(1,1,1,1,0,0,0));
		vetor.add(Arrays.asList(1,1,1,0,0,0,0));
		
		encontraLinha(vetor);

	}

	private static void encontraLinha(List<List<Integer>> vetor) {
		
		int linha = -1;
		int unsDaLinha = 0;
		int maxUns = 0;
		
		for (int i=0, j=0;i<vetor.size();i++)
		{
			if (j >= vetor.size()) { //condição de parada j == n
				System.out.println(linha);
				return;
			}
			List<Integer> list = vetor.get(j);
			System.out.println("A["+i+"]["+j+"]");
			if(list.get(i) == 1) //se o elemento for 1
			{
				unsDaLinha++;
			}
			if(i == vetor.size()-1) //se chegou à última posição da linha
			{
				System.out.println("numero de uns na linha: "+unsDaLinha);
				if (unsDaLinha > maxUns) // se o numero de Uns é maior que o numero de uns salvo anteriormente
				{
					linha = j; // linha recebe o numero da linha
					System.out.println("linha com maior numero de uns: "+linha);
					maxUns = unsDaLinha;
				}
				unsDaLinha = 0;
				i = -1;
				j++;
			}
		}
	}
}
