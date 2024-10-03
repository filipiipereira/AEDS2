import java.util.*;
class ExemploString1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char carac = sc.nextLine().charAt(0);
        int tamanhoString = string.length();
        int quantidade = 0;
        for(int i = 0; i < tamanhoString; i++){
            if(string.charAt(i) == carac) quantidade++;
        }
        System.out.println(quantidade);
    }
}