public class ListaFlexivel{
    private Celula primeiro;
    private Celula ultimo; 
    public ListaFlexivel(){
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    } 
    public void InserirInicio(int x){
        Celula tmp = new Celula(x);
        tmp.proximo = this.primeiro.proximo;
        this.primeiro.proximo = tmp;
        if(this.primeiro == this.ultimo) this.ultimo = tmp;
        tmp = null;
    }
    public void InserirFim(int x){
        Celula tmp = new Celula(x);
        this.ultimo.proximo = tmp;
        this.ultimo = tmp;
        tmp = null;
    }
    public int Tamanho(){
        Celula contaCelulas = this.primeiro;
        int tamanho = 0;
        while(contaCelulas != this.ultimo){
            tamanho++;
            contaCelulas = contaCelulas.proximo;
        }
        return tamanho;
    }
    public void Inserir(int x, int posicao){
        int tamanho = this.Tamanho();
        if(posicao >= 0 && posicao <= tamanho){
            if(posicao == 0){
                InserirInicio(x);
            }
            else if(posicao == tamanho){
                InserirFim(x);
            }
            else{
                Celula i = this.primeiro;
                int j = -1;
                while(j < posicao){
                    i = i.proximo;
                    j++;
                }
                Celula tmp = new Celula(x);
                tmp.proximo = i.proximo;
                i.proximo = tmp;
                i = null;
                tmp = null;
            }
        }
    }
    public int RemoverInicio(){
        int valor;
        if(this.primeiro != this.ultimo){
            Celula tmp = primeiro.proximo;
            valor = tmp.valor;
            primeiro.proximo = tmp.proximo;
            tmp.proximo = null; 
            tmp = null;
        }
        else valor = 0;
        return valor;
    }
    public int RemoverFim(){
        
    }
}