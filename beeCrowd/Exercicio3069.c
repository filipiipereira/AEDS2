#include <stdio.h>

void ordenar(int matriz[2][100], int n);
void swap(int matriz[2][100], int a, int b);

int main() {
    int tamanhoPraia;
    int numeroSorveteiros;
    int intervalos[2][100];
    int numeroTeste = 1;
    int menor;
    int maior;
    scanf("%d", &tamanhoPraia);
    scanf("%d", &numeroSorveteiros);
    while (tamanhoPraia != 0 || numeroSorveteiros != 0) {
        for (int i = 0; i < numeroSorveteiros; i++) {
            scanf("%d %d", &intervalos[0][i], &intervalos[1][i]);
        }
        ordenar(intervalos, numeroSorveteiros);
        menor = intervalos[0][0];
        maior = intervalos[1][0];
        int j = 1;
        printf("Teste %d\n", numeroTeste++);
        while (j < numeroSorveteiros) {
            while (j < numeroSorveteiros && intervalos[0][j] >= menor && intervalos[0][j] <= maior) {
                if (intervalos[1][j] > maior) maior = intervalos[1][j];
                j++;
            }
            printf("%d %d\n", menor, maior);
            if (j != numeroSorveteiros) {
                menor = intervalos[0][j];
                maior = intervalos[1][j];
            }
        }
        scanf("%d", &tamanhoPraia);
        scanf("%d", &numeroSorveteiros);
    }
    return 0;
}

void ordenar(int matriz[2][100], int n) {
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j > 0; j--) {
            if (matriz[0][j] < matriz[0][j - 1]) swap(matriz, j, j - 1);
        }
    }
}

void swap(int matriz[2][100], int a, int b) {
    for (int i = 0; i < 2; i++) {
        int temp = matriz[i][b];
        matriz[i][b] = matriz[i][a];
        matriz[i][a] = temp;
    }
}
