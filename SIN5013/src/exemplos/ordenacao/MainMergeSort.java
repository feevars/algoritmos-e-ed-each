package exemplos.ordenacao;

public class MainMergeSort {

	public static void main(String[] args) {

	
		int [] vetor = {3,2,4,1,5};
		
		mergeSort(vetor);
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + ", ");
		}
	}

	private static void mergeSort(int[] vetor) {
		sort(vetor);
	}

	public static void sort(int[] vetor) {
        if (vetor == null || vetor.length < 2) {
            return;
        }

        int middle = vetor.length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[vetor.length - middle];

        // Populando o array da esquerda
        for (int i = 0; i < middle; i++) {
            leftArray[i] = vetor[i];
        }

        // Populando o array da direita
        for (int i = middle; i < vetor.length; i++) {
            rightArray[i - middle] = vetor[i];
        }

        sort(leftArray);
        sort(rightArray);

        merge(vetor, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
