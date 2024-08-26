import java.util.*;
public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while(!"FIM".equals(string)){
            if(soVogal(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(soConsoante(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(ehInteiro(string)) System.out.print("SIM ");
            else System.out.print("NAO ");
            if(ehFloat(string)) System.out.println("SIM");
            else System.out.println("NAO");
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static boolean soVogal(String string){
        boolean ehSoVogal = true;
        int i = 0;
        while(i < string.length() && ehSoVogal){
            if(string.charAt(i) != 'A' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U' && string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i' && string.charAt(i) != 'o' && string.charAt(i) != 'u'){
                ehSoVogal = false;
            }
            i++;
        }
        return ehSoVogal;
    }
    private static boolean soConsoante(String string){
        boolean ehSoConsoante = true;
        int i = 0;
        while(i < string.length() && ehSoConsoante){
            if((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') || (string.charAt(i) >= 'a' && string.charAt(i) <= 'z')){
                if(!(string.charAt(i) != 'A' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U' && string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i' && string.charAt(i) != 'o' && string.charAt(i) != 'u') ) ehSoConsoante = false;        
            }
            else ehSoConsoante = false;
            i++;
        }
        return ehSoConsoante;
    }
    private static boolean ehInteiro(String string){
        boolean ehInteiro = true;
        int i = 0;
        while(i < string.length() && ehInteiro){
            if(string.charAt(i) < 48 || string.charAt(i) > 58){
                ehInteiro = false;
            }
            i++;
        }
        return ehInteiro;
    }
    private static boolean ehFloat(String string){
        boolean ehFloat = true;
        int i = 0;
        int quantidadePontos = 0;
        while(i < string.length() && ehFloat){
            if(string.charAt(i) < 48 || string.charAt(i) > 58){
                if((string.charAt(i) == 44 || string.charAt(i) == 46) && quantidadePontos < 1){
                    quantidadePontos++;
                }
                else ehFloat = false;
            }
            i++;
        }
        return ehFloat;
    }
}
