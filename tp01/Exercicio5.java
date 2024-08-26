import java.util.*;
public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int A;
        int B;
        boolean expressao;
        while(scanner.hasNext()){
            n = scanner.nextInt();
            A = scanner.nextInt();
            B = scanner.nextInt();
            expressao = scanner.nextBoolean();
            System.out.println(expressao);
        }
        scanner.close();
    }
}
