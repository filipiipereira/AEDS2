#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int QuantidadeMaisculas(char* string);
int main(){
    char* string;
    fgets(string, 50, stdin);
    printf("%d", QuantidadeMaisculas(string));
    return 0;
}
int QuantidadeMaisculas(char* string){
    int quantidade = 0;
    int i = 0;
    while(string[i] != '\0'){
        if(string[i] >= 'A' && string[i] <= 'Z') quantidade++;
        i++;
    }
    return quantidade;
}
