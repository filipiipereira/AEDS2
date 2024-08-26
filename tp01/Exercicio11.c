#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
bool ehPalindromoRec2(char* string, int i, int j){
    bool ehPalindromo;
    if(i < j) ehPalindromo = string[i] == string[j] && ehPalindromoRec2(string, i+1, j-1);
    else ehPalindromo = true;
    return ehPalindromo;
}
bool ehPalindromoRec(char* string){
    return ehPalindromoRec2(string, 0, strlen(string) - 1);
}
int main(){
    char string[500];
    scanf(" %[^\n]", string);
    while(strcmp(string, "FIM") != 0){
        if(ehPalindromoRec(string)) printf("SIM\n");
        else printf("NAO\n");
        scanf(" %[^\n]", string);
    }
}