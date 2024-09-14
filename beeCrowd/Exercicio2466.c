#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int bolas[100];
    for(int i = 0; i < n; i++) {
        scanf("%d", &bolas[i]);
    }
    for(int i = n - 1; i > 0; i--) {
        for(int j = 0; j < i; j++) {
            if(bolas[j] == bolas[j + 1]) bolas[j] = 1;
            else bolas[j] = -1;
        }
    }
    if(bolas[0] == 1) printf("preta\n");
    else printf("branca\n");

    return 0;
}
