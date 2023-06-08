package exemplos.ordenacao;

public class MainQuickSort {

	public static void main(String[] args) {

	
		int [] vetor = {3,2,4,1,5};
		
		quickSort(vetor);
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + ", ");
		}
	}

	private static void quickSort(int[] vetor) {
		sort(vetor);
	}

	public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(array, left, right);

        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                if (i != j) {
                	swap(array, i, j);                	
                }
            }
        }

        swap(array, i + 1, right); // i+1 é a posição em que o pivô será posicionado no vetor. Seu "lugar certo ordenado"

        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
