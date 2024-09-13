import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
class Exercicio7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String url_nome;
        InputStream inputStream;
        URL url;
        BufferedReader bufferedReader;
        String linha;
        String textoHtml;
        while(!nome.equals("FIM")){
            textoHtml = "";
            url_nome = scanner.nextLine();
            try {
                url = new URL(url_nome);
                inputStream = url.openStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while((linha = bufferedReader.readLine()) != null){
                    textoHtml += linha + "\n";
                }
                inputStream.close();
                escreveQuantidades(textoHtml);
                System.out.println(nome);
            } catch (Exception e) { }
            nome = scanner.nextLine();
        }
        scanner.close();
    }
    private static void escreveQuantidades(String textoHtml){
        char[] vogais = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
        int[] quantidadeVogais = new int[vogais.length];
        int numeroConsoantes = 0;
        int numeroBr = 0;
        int numeroTable = 0;
        for(int i = 0; i < textoHtml.length(); i++){
            for(int j = 0; j < vogais.length; j++){
                if(textoHtml.charAt(i) == vogais[j]) quantidadeVogais[j]++; 
            }
            if(textoHtml.charAt(i) == 'b' || textoHtml.charAt(i) == 'c' || textoHtml.charAt(i) == 'd' || textoHtml.charAt(i) == 'f' || textoHtml.charAt(i) == 'g' || textoHtml.charAt(i) == 'h' || textoHtml.charAt(i) == 'j' || textoHtml.charAt(i) == 'k' || textoHtml.charAt(i) == 'l' || textoHtml.charAt(i) == 'm' || textoHtml.charAt(i) == 'n' || textoHtml.charAt(i) == 'p' || textoHtml.charAt(i) == 'q' || textoHtml.charAt(i) == 'r' || textoHtml.charAt(i) == 's' || textoHtml.charAt(i) == 't' || textoHtml.charAt(i) == 'v' || textoHtml.charAt(i) == 'w' || textoHtml.charAt(i) == 'x' || textoHtml.charAt(i) == 'y' || textoHtml.charAt(i) == 'z') numeroConsoantes++;
            else if(textoHtml.charAt(i) == '<'){
                if(textoHtml.charAt(i + 1) == 'b' && textoHtml.charAt(i + 2) == 'r' && textoHtml.charAt(i + 3) == '>') numeroBr++;
                else if(textoHtml.charAt(i + 1) == 't' && textoHtml.charAt(i + 2) == 'a' && textoHtml.charAt(i + 3) == 'b' && textoHtml.charAt(i + 4) == 'l' && textoHtml.charAt(i + 5) == 'e' && textoHtml.charAt(i + 6) == '>') numeroTable++;
            }
        }
        for(int i = 0; i < vogais.length; i++){
            System.out.print(vogais[i] + "(" + quantidadeVogais[i] + ") ");
        }
        System.out.print("consoante(" + numeroConsoantes + ") ");
        System.out.print("<br>(" + numeroBr + ") ");
        System.out.print("<table>(" + numeroTable + ") ");
    }
}