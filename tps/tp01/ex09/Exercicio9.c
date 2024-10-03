#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE* arq = fopen("reais.txt", "w");
    int n;
    scanf("%d", &n);
    float real;
    for(int i = 0; i < n; i++){
        scanf("%f", &real);
        fwrite(&real, 4, 1, arq);    
    }
    fclose(arq);
    arq = fopen("reais.txt", "r");
    fseek(arq, 0, SEEK_END);
    long posicao = ftell(arq);
    float leitura;
    while(posicao >= 0){
        posicao -= sizeof(float); 
        fseek(arq, posicao, SEEK_SET);
        fread(&leitura, 4, 1, arq);
        printf("%g\n", leitura);
    }
    fclose(arq);
    return 0;
}