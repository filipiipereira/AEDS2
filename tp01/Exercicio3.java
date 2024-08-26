import java.util.*;
class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        while(scanner.hasNext()){
            string = scanner.nextLine();
            System.out.println(ciframento(string));
        }
        scanner.close();
    }
    private static String ciframento(String string){
        StringBuilder novaString = new StringBuilder();
        char caractere;
        char novoCaractere;
        for(int i = 0; i < string.length(); i++){
            caractere = string.charAt(i);
            if(caractere < 1 || caractere > 127){
                novaString.append(caractere);
            }
            else{
                novoCaractere = (char) (caractere + 3);
                novaString.append(novoCaractere);
            }
        }
        return novaString.toString();
    }
}
