#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//prototipos
int QuantidadeMaisculas(char* string);
//comeco main
int main(){
    char string[50];
    fgets(string, 50, stdin);
    printf("%d", QuantidadeMaisculas(string));
    return 0;
}//fim main
//comeco QuantidadeMaisculas; entrada: string; saida: inteiro
int QuantidadeMaisculas(char* string){
    int quantidade = 0;
    int i = 0;
    while(string[i] != '\0'){
        if(string[i] >= 'A' && string[i] <= 'Z') quantidade++;
        i++;
    }//endwhile
    return quantidade;
}//fim QuantidadeMaisculas
