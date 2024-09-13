
import java.util.Scanner;

class Prova1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[] palavras = new String[m];
        int[] salarios = new int[m];
        for(int i = 0; i < m; i++){
            palavras[i] = scanner.next();
            salarios[i] = scanner.nextInt();
        }
        StringBuilder[] descricao = new StringBuilder[2];
        int j = 0;
        while(scanner.hasNext()){
            String string;
            while(!((string = scanner.next())).equals(".")){
                descricao[j].append(string);
            }
            j++;
        }
        for(int i = 0; i < n; i++){
            descricao[i].toString();
        }
        for(int i = 0; i < 2; i++){
            System.out.println(descricao[i]);
        }
    }
}