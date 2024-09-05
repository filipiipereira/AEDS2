



class BubbleSort{
    public static void main(String[] args) {
        int[] array = {32,87,65,7,4,35,100,76,56};
        for(int i = 0; i < array.length; i++){
            for(int j = array.length - 1; j > 0; j--){
                if(array[j] < array[j-1]) swap(array, j, j-1);
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    private static void swap(int array[],int a, int b){
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}