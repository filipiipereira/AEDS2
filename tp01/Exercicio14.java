import java.util.*;
public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while(!"FIM".equals(string)){
            if(soVogalRec(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(soConsoanteRec(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(ehInteiroRec(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(ehFloatRec(string)) System.out.println("SIM");
            else System.out.println("NAO");
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static boolean soVogalRec(String string){
        return soVogalRec2(string, 0);
    }
    private static boolean soVogalRec2(String string, int i){
        boolean ehSoVogal = true;
        if(i < string.length()){
           ehSoVogal = (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U' || string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') && soVogalRec2(string, i + 1);
        }
        return ehSoVogal;
    }
    private static boolean soConsoanteRec(String string){
        return soConsoanteRec2(string, 0);
    }
    private static boolean soConsoanteRec2(String string, int i){
        boolean ehSoConsoante = true;
        if(i < string.length()){
            ehSoConsoante = ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') || (string.charAt(i) >= 'a' && string.charAt(i) <= 'z')) && (string.charAt(i) != 'A' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U' && string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i' && string.charAt(i) != 'o' && string.charAt(i) != 'u') && soConsoanteRec2(string, i + 1);
        }
        return ehSoConsoante;
    }
    private static boolean ehInteiroRec(String string){
        return ehInteiroRec2(string, 0);
    }
    private static boolean ehInteiroRec2(String string, int i){
        boolean ehInteiro = true;
        if(i < string.length()){
            ehInteiro = (string.charAt(i) >= 48 && string.charAt(i) <= 58) && ehInteiroRec2(string, i + 1);
            }
        return ehInteiro;
    }
    private static boolean ehFloatRec(String string){
        return ehFloatRec2(string, 0, 0);
    }
    private static boolean ehFloatRec2(String string, int i, int quantidadePontos){
        boolean ehFloat = true;
        if(i < string.length()){
            if(string.charAt(i) >= 48 && string.charAt(i) <= 57){
                ehFloat = quantidadePontos <= 1 & ehFloatRec2(string, i + 1, quantidadePontos);
            }
            else if(string.charAt(i) == 44 || string.charAt(i) == 46) ehFloat = quantidadePontos <= 1    && ehFloatRec2(string, i + 1, quantidadePontos + 1);
            else ehFloat = false;
            }
        return ehFloat;
    }
}
