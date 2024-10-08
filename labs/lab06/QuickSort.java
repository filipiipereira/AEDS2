import java.util.Date;
import java.util.Random;
class QuickSort{
    public static void main(String[] args) {
        int tamanho = 1000000;
        int[] array = new int[tamanho];
        int n = array.length;
        for (int i = 0; i < n; i++) {
			array[i] = i;
		}
        /*
        //ORDENADO:
        Random rand = new Random();	
		for (int i = 0; i < n; i++) {
			swap(array, i, Math.abs(rand.nextInt()) % n);
		}
        */
        /*
        //PARCIALMENTE ORDENADO
        Random rand = new Random();	
		for (int i = 0; i < n/8; i++) {
			swap(array, i, Math.abs(rand.nextInt()) % n);
		}
        */
        double inicio = new Date().getTime();
        //QuickSortFirstPivot(array, 0, array.length - 1);
        //QuickSortLastPivot(array, 0, array.length - 1);
        //QuickSortRandomPivot(array, 0, array.length - 1);
        //QuickSortMedianOfThree(array, 0, array.length - 1);
        double fim = new Date().getTime();
        System.out.println("Tempo para ordenar: " + (fim-inicio)/1000.0 + " s.");
    }
    public static void QuickSortFirstPivot(int array[], int left, int right) {
        int i = left, j = right;
        int pivo = array[i];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)  QuickSortFirstPivot(array, left, j);
        if (i < right)  QuickSortFirstPivot(array, i, right);
    }
    public static void QuickSortLastPivot(int array[], int left, int right) {
        int i = left, j = right;
        int pivo = array[j];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)  QuickSortLastPivot(array, left, j);
        if (i < right)  QuickSortLastPivot(array, i, right);
    }
    public static void QuickSortRandomPivot(int array[], int left, int right) {
        int i = left, j = right;
        Random random = new Random();
        int pivo = array[i + random.nextInt(j - i + 1)];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)  QuickSortRandomPivot(array, left, j);
        if (i < right)  QuickSortRandomPivot(array, i, right);
    }
    public static void QuickSortMedianOfThree(int array[], int left, int right) {
        int i = left, j = right;
        int pivo = array[medianOfThree(array, i , j)];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)  QuickSortMedianOfThree(array, left, j);
        if (i < right)  QuickSortMedianOfThree(array, i, right);
    }
    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static int medianOfThree(int[] array, int i, int j){
        int mediana;
        int meio = (i + j) / 2;
        if((array[i] >= array[j] && array[j] >= array[meio]) || (array[meio] >= array[j] && array[j] >= array[i])){
            mediana = j;
        }
        else if((array[j] >= array[i] && array[i] >= array[meio]) || (array[meio] >= array[i] && array[i] >= array[j])){
            mediana = i;
        }
        else mediana = meio;
        return mediana;
    }
}