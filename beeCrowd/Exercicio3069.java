
import java.util.Scanner;

class Exercicio3069 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int tamanhoPraia;
      int numeroSorveteiros;
      int[][] intervalos;
      int numeroTeste = 1;
      int menor;
      int maior;
      tamanhoPraia = scanner.nextInt();
      numeroSorveteiros = scanner.nextInt();
      while (tamanhoPraia != 0 || numeroSorveteiros != 0) {
         intervalos = new int[2][numeroSorveteiros];
         for (int i = 0; i < numeroSorveteiros; i++) {
               intervalos[0][i] = scanner.nextInt();
               intervalos[1][i] = scanner.nextInt();
         }
         ordenar(intervalos, numeroSorveteiros);
         menor = intervalos[0][0];
         maior = intervalos[1][0];
         int j = 1;
         System.out.println("Teste " + numeroTeste++);
         while(j < numeroSorveteiros){
            while(j < numeroSorveteiros && intervalos[0][j] >= menor && intervalos[0][j] <= maior){
               if(intervalos[1][j] > maior) maior = intervalos[1][j];
               j++;
            }      
            System.out.print(menor + " ");
            System.out.println(maior);
            if(j != numeroSorveteiros){
               menor = intervalos[0][j];
               maior = intervalos[1][j];
            }
         }
         tamanhoPraia = scanner.nextInt();
         numeroSorveteiros = scanner.nextInt();
      }
   }
   public static void ordenar(int[][] matriz, int n){
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j > 0; j--){
                if(matriz[0][j] < matriz[0][j-1]) swap(matriz, j, j-1);
            }
        }
   }
   private static void swap(int[][] matriz, int a, int b){
      for(int i = 0; i < 2; i++){
         int temp = matriz[i][b];
         matriz[i][b] = matriz[i][a];
          matriz[i][a] = temp;
      }
    }
}
