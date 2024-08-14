#include <stdio.h>
#include <stdlib.h>
int QuantidadeMaisculas(char* string);
int main(){
    char string[50];
    scanf(" %s", string);
    printf("%d", QuantidadeMaisculas(string));
    return 0;
}
int QuantidadeMaisculas(char* string){
    int quantidade = 0;
    int i = 0;
    while(string[i] != '\0'){
        if(string[i] >= 65 && string[i] <= 90) quantidade++;
    }
    return quantidade;
}