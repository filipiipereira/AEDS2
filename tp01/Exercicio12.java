import java.util.*;
class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        string = scanner.nextLine();
        while(!"FIM".equals(string)){
            System.out.println(ciframentoRec(string));
            string = scanner.nextLine();
        }
        scanner.close();
    }
    private static String ciframentoRec(String string){
        return ciframentoRec2(string, 0);
    }
    private static String ciframentoRec2(String string, int i){
        StringBuilder novaString = new StringBuilder();
        if(i == string.length() - 1){
            if(string.charAt(i) < 1 || string.charAt(i) > 127) novaString.append(string.charAt(i));
            else novaString.append((char)(string.charAt(i) + 3));
        }
        else{
            if(string.charAt(i) < 1 || string.charAt(i) > 127) novaString.append(string.charAt(i));
            else novaString.append((char)(string.charAt(i) + 3));
            novaString.append(ciframentoRec2(string, i + 1));
        }
        return novaString.toString();
    }
}
