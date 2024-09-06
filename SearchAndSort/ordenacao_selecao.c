
int main(){
    int array[] = {2,3,1,8,5,9,7};
    int posicaoMenor;
    int aux;
    for(int i = 0; i < 7; i++){
        posicaoMenor = i;
        for(int j = i; j < 7; j++){
            if(array[j] < array[posicaoMenor]) posicaoMenor = j;
        }
        aux = array[posicaoMenor];
        array[posicaoMenor] = array[i];
        array[i] = aux;
    }
    for(int i = 0; i < 7; i++){
        printf("%d ", array[i]);
    }
}
