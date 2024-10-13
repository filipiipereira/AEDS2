import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Pokemon {
    private int id;
    private int generation;
    private String name;
    private String description;
    private String[] types;
    private String[] abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id; 
    }
    public int getGeneration(){
        return generation; 
    }
    public void setGeneration(int generation){
        this.generation = generation;
    }
    public String getName() {
    return name; 
    }
    public void setName(String name) {
        this.name = name; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public String[] getTypes() { 
        return types; 
    }
    public void setTypes(String[] types) { 
        this.types = types; 
    }
    public String[] getAbilities() { 
        return abilities; 
    }
    public void setAbilities(String[] abilities) { 
        this.abilities = abilities; 
    }
    public double getWeight() { 
        return weight; 
    }
    public void setWeight(double weight) { 
        this.weight = weight; 
    }
    public double getHeight() { 
        return height; 
    }
    public void setHeight(double height) { 
        this.height = height; 
    }
    public int getCaptureRate() { 
        return captureRate; 
    }
    public void setCaptureRate(int captureRate) { 
        this.captureRate = captureRate; 
    }
    public boolean isLegendary() { 
        return isLegendary; 
    }
    public void setIsLegendary(boolean isLegendary) { 
        this.isLegendary = isLegendary; 
    }
    public Date getCaptureDate() { 
        return captureDate; 
    }
    public void setCaptureDate(Date captureDate) { 
        this.captureDate = captureDate; 
    }
    public void ler(String linha) {
        String[] data = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        setId(Integer.parseInt(data[0].trim()));
        setGeneration(Integer.parseInt(data[1].trim()));
        setName(data[2].trim());
        setDescription(data[3].trim());
        List<String> typesList = new ArrayList<>();
        typesList.add(data[4].trim());
        if (!data[5].trim().isEmpty()) typesList.add(data[5].trim());
        setTypes(typesList.toArray(new String[0]));
        String abilitiesStr = data[6].replaceAll("[\\[\\]\"']", "").trim();
        setAbilities(abilitiesStr.split(",\\s*"));
        setWeight(data[7].trim().isEmpty() ? 0 : Double.parseDouble(data[7].trim()));
        setHeight(data[8].trim().isEmpty() ? 0 : Double.parseDouble(data[8].trim()));
        setCaptureRate(data[9].trim().isEmpty() ? 0 : Integer.parseInt(data[9].trim()));
        setIsLegendary(data[10].trim().equals("1") || data[10].trim().equalsIgnoreCase("true"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse(data[11].trim()); 
            setCaptureDate(date);
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
        }
    }
    public void imprimir() {
        System.out.print("[#" + getId() + " -> " + getName() + ": " + getDescription() + " - [");
        for(int i = 0; i < getTypes().length; i++) {
            System.out.print("'" + getTypes()[i] + "'");
            if(i != getTypes().length -1) System.out.print(", ");
        }
        System.out.print("] - [");
        for(int i = 0; i < getAbilities().length; i++) {
            System.out.print("'" + getAbilities()[i] + "'");
            if(i != getAbilities().length -1) System.out.print(", ");
        }
        System.out.print("] - ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(getWeight() + "kg - " + getHeight() + "m - " + getCaptureRate() + "% - " + isLegendary() + " - " + getGeneration() + " gen] - " + dateFormat.format(getCaptureDate()));
    }
}
class Exercicio13{
    public static int quantidadeMovimentacoes = 0;
    public static int quantidadeComparacoes = 0;
    public static List<Pokemon> lerPokedex() {
        List<Pokemon> pokedex = new ArrayList<>();
        String linha;
        boolean isFirstLine = true;
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/pokemon.csv"))) {
            while ((linha = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                }
                else{
                    Pokemon pokemon = new Pokemon();
                    pokemon.ler(linha);
                    pokedex.add(pokemon);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
        return pokedex;
    }
    public static Pokemon[] selecionarPokemons(List<Pokemon> pokedex, Scanner scanner){
        String numero;
        List<Pokemon> pokemonsSelecionados = new ArrayList<>();
        int id;
        int quantidadePokemons = 0;
        boolean encontrou;
        while(!(numero = scanner.nextLine()).equals("FIM")) {
            id = Integer.parseInt(numero);
            encontrou = false;
            int i = 0;
            while(!encontrou && i < pokedex.size()){
                if(pokedex.get(i).getId() == id){
                    pokemonsSelecionados.add(pokedex.get(i));
                    quantidadePokemons++;
                    encontrou = true;
                }
                i++;
            }
            if (!encontrou) {
                System.out.println("Pokémon com ID " + id + " não encontrado.");
            }
        }
        return pokemonsSelecionados.toArray(new Pokemon[0]);
    }
    public static void escrevePokemons(Pokemon[] pokemons){
        for(Pokemon pokemon : pokemons){
            pokemon.imprimir();
        }
    }
    public static void mergeSort(Pokemon[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(Pokemon[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(array, esq, meio);
            mergeSort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    public static void intercalar(Pokemon[] array, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Pokemon[] a1 = new Pokemon[n1];
        Pokemon[] a2 = new Pokemon[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
            quantidadeMovimentacoes++;
        }

        for (int j = 0; j < n2; j++) {
            a2[j] = array[meio + 1 + j];
            quantidadeMovimentacoes++;
        }

        int i = 0, j = 0;
        int k = esq;

        while (i < n1 && j < n2) {
            int typeComparison = a1[i].getTypes()[0].compareTo(a2[j].getTypes()[0]);    
            quantidadeComparacoes++;
            if (typeComparison < 0) {
                array[k] = a1[i];
                i++;
                quantidadeMovimentacoes++;
            } else if (typeComparison > 0) {
                array[k] = a2[j];
                j++;
                quantidadeMovimentacoes++;
            } else {
                quantidadeComparacoes++;
                int nameComparison = a1[i].getName().compareTo(a2[j].getName());
                quantidadeComparacoes++;
                if (nameComparison < 0) {
                    array[k] = a1[i];
                    i++;
                    quantidadeMovimentacoes++;
                } else {
                    array[k] = a2[j];
                    j++;
                    quantidadeMovimentacoes++;
                }
            }
            k++;
        }

        while (i < n1) {
            array[k] = a1[i];
            i++;
            k++;
            quantidadeMovimentacoes++;
        }

        while (j < n2) {
            array[k] = a2[j];
            j++;
            k++;
            quantidadeMovimentacoes++;
        }
    }
    public static void main(String[] args) {
        double inicio = new Date().getTime();
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokedex = lerPokedex();
        Pokemon[] pokemonsSelecionados = selecionarPokemons(pokedex, scanner);
        mergeSort(pokemonsSelecionados);
        escrevePokemons(pokemonsSelecionados);
        double fim = new Date().getTime();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_mergesort.txt"))) {
            writer.write("851234\t" + quantidadeComparacoes + "\t" + quantidadeMovimentacoes + "\t" + (fim-inicio)/1000.0);
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo de log: " + e.getMessage());
        }
    }
}
