package exemplos.tentativaeerro;

import java.util.ArrayList;
import java.util.List;

public class MainMochilaBinaria {

	public static void main(String[] args) {

		
		Objeto [] vetor = {new Objeto(5, 0.3), new Objeto(2, 1.3), new Objeto(8, 3.9), new Objeto(6, 1.0)};
		
		
		Mochila mochila = new Mochila(3.0);
		mochilaBinaria(mochila, vetor);
		
	}

	private static void mochilaBinaria(Mochila mochila, Objeto[] vetor) {
		if (mochila.getCapacidade()<=0 || vetor.length == 0)
		{
			System.out.println();
//			return mochila.;
		}
		
	}

	private static Mochila mochilaBinaria(Mochila mochila, List<Objeto> vetor) {
		

		
		
		
		
		
		
		return mochila;
	}
}
