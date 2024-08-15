import java.util.*;
class LeituraScanner{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o inteiro: ");
        int inteiro = sc.nextInt();
        System.out.println("Digite o real: ");
        double real = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a string: ");
        String string = sc.nextLine();
        System.out.println("Digite o caractere: ");
        char caractere = sc.nextLine().charAt(0);
        System.out.println("Inteiro: " + inteiro);
        System.out.println("Real : " + real);
        System.out.println("String: " + string);
        System.out.println("Caractere: " + caractere);
    }
}