class QuickSort{
    public static void main(String[] args) {
        int[] array = {23,96,53,59,06,44};
        int esq = 0, dir = array.length - 1;
        quickSort(array, esq, dir);
        for(int x : array) System.out.println(x);
    }
    private static void quickSort(int[] array, int esq, int dir){
        int i = esq;
        int j = dir;
        int pivo = array[(i + j)/2];
        while(i <= j){
            while(pivo > array[i]){
                i++;
            }
            while(pivo < array[j]){
                j--;
            }
            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if(esq < j) quickSort(array, esq, j);
        if(i < dir) quickSort(array, i, dir);
    }
    private static void swap(int array[],int a, int b){
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}