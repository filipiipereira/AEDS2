#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//prototipos
int QuantidadeMaiusculasRec1(char* string);
int QuantidadeMaiusculasRec2(char* string, int i);
//comeco main
int main(){
    char string[50];
    fgets(string, 50, stdin);
    printf("%d", QuantidadeMaiusculasRec1(string));
    return 0;
}//fim main
//comeco QuantidadeMaisculasRec1; entrada: string; retorno: inteiro
int QuantidadeMaiusculasRec1(char* string){
    return QuantidadeMaiusculasRec2(string, 0);
}
//comeco QuantidadeMaisculasRec2; entrada: string, int; retorno: inteiro
int QuantidadeMaiusculasRec2(char* string, int i){
    int quantidade = 0;
    if (string[i] == '\0'){
        quantidade = 0;
    }
    else if(string[i] >= 'A' && string[i] <= 'Z') quantidade = 1 + QuantidadeMaiusculasRec2(string, i+1);
    else quantidade = QuantidadeMaiusculasRec2(string, i+1);
    return quantidade;
}//fim QuantidadeMaisculasRec2
