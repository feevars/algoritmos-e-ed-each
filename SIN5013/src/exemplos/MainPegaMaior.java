package exemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MainPegaMaior {

	public static void main(String[] args) {

	
		List<Integer> vetor = new ArrayList<>();
		vetor.addAll(Arrays.asList(1,3,2,5,4,8));
		
		pegaMaiorESegundoMaior(vetor);

	}

	private static void pegaMaiorESegundoMaior(List<Integer> vetor) {
		int maior1= vetor.get(0);
		int maior2 = vetor.get(0);
		System.out.println("valor inicial de maior1 = " + maior1 + " | maior2 = "+maior2);
			for (int i = 0; i<vetor.size(); i++) {
				if(vetor.get(i) > maior1)
				{
					maior2 = maior1;
					maior1 = vetor.get(i);
				}
			}
		System.out.println("maior1 = "+maior1);
		System.out.println("maior2 = "+maior2);
	}

	
}
