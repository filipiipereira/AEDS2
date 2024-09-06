#include <stdbool.h>
int metodoRecursivo(int array[], int x, int dir, int esq, int posicao){
    int meio = (dir + esq)/2;
    if(esq > dir) posicao = -1;
    else if(array[meio] == x){
        posicao = meio;
    }
    else if(array[meio] < x){
        posicao = metodoRecursivo(array, x, dir, meio + 1, posicao);
    }
    else posicao = metodoRecursivo(array, x, meio - 1, esq, posicao);
    return posicao;
}
void metodoIterativo(int array[], int x, int dir, int esq){
    bool encontrou = false;
    int posicao;
    int meio;
    while(!encontrou && esq <= dir){
        meio = (dir + esq)/2;
        if(array[meio] == x){
            encontrou = true;
            posicao = meio;
        }
        else if(x < array[meio]){
            dir = meio-1;
        }
        else {
            esq = meio+1;
        }
    }

    if(encontrou){
        printf("Esta na posicao %d", posicao);
    }
    else printf("Nao encontrou");
}

int main(){
    int array[] = {1,2,4,5,8,9};
    int x = 4;
    int dir = 5;
    int esq = 0;
    int posicao;
    posicao = metodoRecursivo(array, x, dir, esq, posicao);
    if(posicao == -1){
        printf("Nao encontrou");
    }
    else printf("Posicao eh %d", posicao);
    return 0;
}

