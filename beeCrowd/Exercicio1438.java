
import java.util.Scanner;

class Exercicio1438{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeCaixas = scanner.nextInt();
        int quantidadePilhas = scanner.nextInt();
        int[][] pilhas = new int[quantidadeCaixas][quantidadePilhas];
        int numeroCaixasnaPilha;
        int quantidadeRetiradas;
        while(quantidadeCaixas != 0 || quantidadePilhas != 0){
            for(int j = 0; j < quantidadePilhas; j++){
                numeroCaixasnaPilha = scanner.nextInt();
                for(int i = 0; i < numeroCaixasnaPilha; i++){
                    pilhas[i][j] = scanner.nextInt();
                }
                for(int i = numeroCaixasnaPilha; i < quantidadeCaixas; i++){
                    pilhas[i][j] = 0;
                }
            }
            quantidadeRetiradas = 0;
            int i = quantidadeCaixas - 1;
            int j = 0;
            boolean encontrou = false;
            while(!encontrou){
                while(i >= 0 && !encontrou){
                    if(pilhas[i][j] == 1) encontrou = true;
                    if(pilhas[i][j] != 0 && !encontrou) quantidadeRetiradas++;
                    i--;
                }
                j++;
                i = quantidadeCaixas - 1;
            }
            if(quantidadeRetiradas > quantidadeCaixas / 2){
                quantidadeRetiradas = 0;
                i = quantidadeCaixas - 1;
                j = quantidadePilhas - 1;
                encontrou = false;
                while(!encontrou){
                    while(i >= 0 && !encontrou){
                        if(pilhas[i][j] == 1) encontrou = true;
                        if(pilhas[i][j] != 0 && !encontrou) quantidadeRetiradas++;
                        i--;
                    }
                    j--;
                    i = quantidadeCaixas - 1;
                }
            }
            System.out.println(quantidadeRetiradas);
            quantidadeCaixas = scanner.nextInt();
            quantidadePilhas = scanner.nextInt();
        
        }
    }
}