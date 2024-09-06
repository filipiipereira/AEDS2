#include <stdbool.h>
int main(){
    int array[] = {2,8,5,4,9,1};
    int x = 10;
    bool encontrou = false;
    int i = 0;
    int posicao;
    while(i < 6 && !encontrou){
        if(array[i] == x){
            encontrou = true;
            posicao = i+1;
        }
        i++;
    }
    if(encontrou){
        printf("Esta na posicao %d", posicao);
    }
    else printf("Nao encontrou");
    return 0;
}
