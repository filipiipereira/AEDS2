
import java.util.Scanner;

class Exercicio2466{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] bolas = new int[n];
        for(int i = 0; i < n; i++){
            bolas[i] = scanner.nextInt();
        }
        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(bolas[j] == bolas[j+1]) bolas[j] = 1;
                else bolas[j] = -1;
            }
        }
        if(bolas[0] == 1) System.out.println("preta");
        else System.out.println("branca");
    }
}