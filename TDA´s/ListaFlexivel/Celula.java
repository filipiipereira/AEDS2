public class Celula{
    public int valor;
    public Celula proximo;
    public Celula(){
        this.valor = 0;
        this.proximo = null;
    }
    public Celula(int x){
        this.valor = x;
        this.proximo = null;
    }
}