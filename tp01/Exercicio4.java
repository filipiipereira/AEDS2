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
            System.out.println(trocaLetras(string, primeiraLetra, segundaLetra));
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static String trocaLetras(String string, char primeiraLetra, char segundaLetra){
        char[] novaString = new char[string.length()];
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == primeiraLetra) novaString[i] = segundaLetra;
            else novaString[i] = string.charAt(i);
        }
        return new String(novaString);
    }
}
