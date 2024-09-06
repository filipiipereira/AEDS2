int main(){
    int array[] = {2,3,1,8,5,9,7};
    for(int i = 0; i < 7; i++){
        int aux = array[i];
        int j = i-1;
        while(j >= 0 && array[i] < array[j]){
            array[j+1] = array[j];
            array[j] = aux;
            j--;
        }
    }
    for(int i = 0; i < 7; i++){
        printf("%d ", array[i]);
    }
    return 0;
}
