import java.util.*;
class SequenciaEspelho{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1;
        int numero2;
        while(sc.hasNext()){
            numero1 = sc.nextInt();
            numero2 = sc.nextInt();
            for(int i = numero1; i <= numero2; i++){
                System.out.print(i);
            }
            for(int i = numero2; i >= numero1; i--){
                escreveNumeroInvertido(i);
            }
        }
    }
    public static void escreveNumeroInvertido(int numero){
        int algarismos[] = new int[100];
        int i = 0;       
        int temp = numero;
        while(temp != 0){
            algarismos[i] = temp % 10;
            temp = temp / 10;
            i++;
        }
        for(int j = 0; j < i; j++){
            System.out.print(algarismos[j]);
        }
    }
}