import java.util.Random;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();;
        while(!"FIM".equals(string)){
            System.out.println(trocaLetras(string));
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static String trocaLetras(String string){
        Random gerador = new Random();
        gerador.setSeed(4);
        char primeiraLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char segundaLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        StringBuilder novaString = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == primeiraLetra) novaString.append(segundaLetra);
            else novaString.append(string.charAt(i));
        }
        return novaString.toString();
    }
}
