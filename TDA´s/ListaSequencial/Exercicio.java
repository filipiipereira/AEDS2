
class Exercicio{
    public static void main(String[] args) {
      System.out.println("==== LISTA SEQUENCIAL ====");
      ListaSequencial lista = new ListaSequencial(6);
      int x1, x2, x3;

      lista.InserirInicio(1);
      lista.InserirFim(7);
      lista.InserirFim(9);
      lista.InserirInicio(3);
      lista.Inserir(8, 3);
      lista.Inserir(4, 2);

      System.out.println("Apos insercoes: ");
      lista.Mostrar();

      x1 = lista.RemoverInicio();
      x2 = lista.RemoverFim();
      x3 = lista.Remover(2);

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
      lista.Mostrar();
    }
}