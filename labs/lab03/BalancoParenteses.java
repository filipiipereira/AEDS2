import java.util.*;
class BalancoParenteses{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        boolean estaCorreto;
        while(!string.equals("FIM")){
            estaCorreto = true;
            int contador = 0;
            for(int i = 0; i < string.length(); i++){
                if(string.charAt(i) == '('){
                    contador++;
                }
                else if(string.charAt(i) == ')'){
                    if(contador == 0) estaCorreto = false;
                    else contador--;
                }
            }
            if(contador != 0) estaCorreto = false;
            if(estaCorreto) System.out.println("correto");
            else System.out.println("incorreto");
            string = scanner.nextLine();
        }
        scanner.close();
    }
}