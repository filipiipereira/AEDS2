import java.util.Random;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Random gerador = new Random();
        gerador.setSeed(4);
        char primeiraLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char segundaLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        while(!"FIM".equals(string)){
            trocaLetras(string, primeiraLetra, segundaLetra);
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static void trocaLetras(String string, char primeiraLetra, char segundaLetra){
        StringBuilder novaString = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == primeiraLetra) novaString.append(segundaLetra);
            else novaString.append(string.charAt(i));
        }
        System.out.println(novaString);;
    }
}
