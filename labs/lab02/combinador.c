#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    char string1[50];
    char string2[50];
    char string3[100];
    while (scanf(" %s", string1) == 1 && scanf(" %s", string2) == 1){
        int i = 0;
        while (string1[i] != '\0' && string2[i] != '\0'){
            if (i % 2 == 0) string3[i] = string1[i];
            else string3[i] = string2[i];
            i++;
        }
        if (strlen(string1) > strlen(string2)){
            while (string1[i] != '\0')
            {
                string3[i] = string1[i];
                i++;
            }
        }
        else{
            while (string2[i] != '\0')
            {
                string3[i] = string2[i];
                i++;
            }
        }
        string3[i] = '\0';
        printf("%s", string3);
    }
}