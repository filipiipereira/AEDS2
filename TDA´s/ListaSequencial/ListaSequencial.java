



public class ListaSequencial{
    private int[] array;
    private int contador;
    public ListaSequencial(int tamanho){
        this.array = new int[6];
        this.contador = 0;
    }
    public ListaSequencial(){
        this.array = new int[10];
        this.contador = 0;
    }
    public void Inserir(int a, int posicao){
        if(posicao >= 0 && posicao <= this.contador){
            for(int i = this.contador; i > posicao; i--){
                this.array[i] = this.array[i - 1];
            }
            this.array[posicao] = a;
            this.contador++;
        }
    }
    public void InserirInicio(int a){
        this.Inserir(a, 0);
    }
    public void InserirFim(int a){
        this.Inserir(a, this.contador);
    }
    public void Mostrar(){
        if(contador != 0){
            for(int i = 0; i < contador; i++){
                System.out.print(this.array[i] + " ");
            }
        }
    }
    public int Remover(int posicao){
        int valor;
        if(posicao <= this.contador - 1){
            valor = this.array[posicao];
            for(int i = posicao; i < this.contador - 1; i++){
                this.array[i] = this.array[i + 1];
            }
            this.contador--; 
        }
        else{
            System.out.println("Nao ha elementos");
            valor = -200;
        }
        return valor;
    }
    public int RemoverInicio(){
        return this.Remover(0);
    }
    public int RemoverFim(){
        return this.Remover(contador - 1);
    }
}