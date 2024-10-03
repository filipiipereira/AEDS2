

class Insercao{
    public static void main(String[] args) {
        int[] array = {2,7,46,3,25,75,85,32};
        int temp;
        int j;
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            j = i - 1;
            while(j > 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        for(int x : array){
            System.out.println(x);
        }
    }
}