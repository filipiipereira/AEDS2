import java.util.*;
class Lab01_Iterativo{
    //inicio metodo tipo void QuantidadeMaisculosIterativo. Parametro: string 
    public static void QuantidadeMaiusculosIterativo(String string){
        int quantidadeMaisculas = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') quantidadeMaisculas++;
        }//endfor
        System.out.println(quantidadeMaisculas);
    }//end QuantidadeMaisculosIterativo
    //inicio metodo principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        QuantidadeMaiusculosIterativo(string);
    }//end main
}//end class