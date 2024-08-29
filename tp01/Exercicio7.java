import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
class Exercicio7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String url_nome = scanner.nextLine();
        try {
            URL url = new URL(url_nome);
            System.out.println(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}