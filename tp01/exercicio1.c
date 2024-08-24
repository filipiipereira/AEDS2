#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
int tamanhoString(char* string){
    int c = 0;
    while(string[c] != '\0'){
        c++;
    }
    return c;
}

bool palindromo(char* string) //Função que verifica se uma string é um palíndromo
{
    bool ehPalindromo = true;
    int  i = 0;
    while(i < tamanhoString(string)/2 && ehPalindromo) //Loop para comparar os caracteres da string
    {
        if(string[i] != string[tamanhoString(string) - 1 - i]) //Compara o caractere da posição i com o caractere da posição correspondente do final
        {
            ehPalindromo = false; //Se os caracteres não forem iguais, ou forem caracteres não letras, não é um palíndromo
        }
        i++;
    }
    return ehPalindromo;
}


int main()
{
    char string[500];
    
    scanf(" %[^\n]", string);
    while(strcmp(string, "FIM") != 0) //Loop que lê strings até o fim do arquivo (determinado pela string FIM)
    {
        if(palindromo(string)) printf("SIM\n"); //Imprime o resultado("SIM" se for palindromo e "NAO" se nao for palindromo)
        else printf("NAO\n");
        scanf(" %[^\n]", string);
    }

    return 0;
}