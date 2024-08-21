import java.util.*;
class Lab01_Recursivo{
     //inicio metodo QuantidadeMaisculosRecursivo2. Parametro: string. Retorno: inteiro.
    public static int QuantidadeMaiusculosRecursivo1(String string) {
        return QuantidadeMaiusculosRecursivo2(string, 0, string.length() - 1);
    }
    //inicio metodo QuantidadeMaisculosRecursivo2. Parametro: string, int, int. Retorno: inteiro.
    public static int QuantidadeMaiusculosRecursivo2(String string, int i, int length){
        int quantidadeMaisculas;
        if(i > length){
            quantidadeMaisculas = 0;
        }
        else if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') 
            quantidadeMaisculas = 1 + QuantidadeMaiusculosRecursivo2(string, i+1, length);
        else{
            quantidadeMaisculas = QuantidadeMaiusculosRecursivo2(string, i+1, length);
        }
        return quantidadeMaisculas;
    }//end QuantidadeMaisculosRecursivo
    //inicio metodo principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        while(!"FIM".equals(string)){
            System.out.println(QuantidadeMaiusculosRecursivo1(string));
            string = sc.nextLine();
        }
    }//end main
}//end class