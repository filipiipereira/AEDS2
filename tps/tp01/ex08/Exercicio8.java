import java.io.RandomAccessFile;

class Exercicio8{
    public static void main(String[] args) throws Exception {
        int n = MyIO.readInt();
        RandomAccessFile raf = new RandomAccessFile("reais.txt", "rw");
        double numero;
        for(int i = 0; i < n; i++){
            numero = MyIO.readDouble();
            raf.writeDouble(numero);
        }
        raf.close();
        raf = new RandomAccessFile("reais.txt", "r");
        for(int i = n-1; i >= 0; i--){
            raf.seek(i * 8);
            double leitura = raf.readDouble();
            if(leitura % 1 == 0) System.out.println((int)leitura);
            else System.out.println(leitura);
        }
        raf.close();
    }
}