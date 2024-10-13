#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <time.h>
#include <sys/time.h>

#define MAX_POKEMON 1000
#define MAX_STRING 256
#define MAX_ABILITIES 6
#define MAX_TYPES 3

typedef struct 
{
    char id[MAX_STRING];
    int generation;
    char name[MAX_STRING];
    char description[MAX_STRING];
    char types[MAX_TYPES][MAX_STRING];
    char abilities[MAX_ABILITIES][MAX_STRING];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    struct tm captureDate;
} Pokemon;


const char* getId(Pokemon *pokemon);
const char* getName(Pokemon *pokemon);
const char* getDescription(Pokemon *pokemon);
const char* getType(Pokemon *pokemon, int index);
const char* getAbility(Pokemon *pokemon, int index);
double getWeight(Pokemon *pokemon);
double getHeight(Pokemon *pokemon);
bool getIsLegendary(Pokemon *pokemon);
int getGeneration(Pokemon *pokemon);
int getCaptureRate(Pokemon *pokemon);
struct tm getCaptureDate(Pokemon *pokemon);


void trim(char *str) 
{
    char *end;
    while (isspace((unsigned char)*str)) str++;
    if (*str == 0) return;
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;
    end[1] = '\0';
}

void parseDate(char *dateStr, struct tm *date) 
{
    if (sscanf(dateStr, "%d/%d/%d", &date->tm_mday, &date->tm_mon, &date->tm_year) != 3) 
    {
        return;
    }
    date->tm_mon -= 1;
    date->tm_year -= 1900;
}


int split_csv_line(char *line, char **fields, int max_fields) 
{
    int field_count = 0;
    char *ptr = line;
    int in_quotes = 0;
    char *field_start = ptr;

    while (*ptr && field_count < max_fields) 
    {
        if (*ptr == '"') 
        {
            in_quotes = !in_quotes;
        } else if (*ptr == ',' && !in_quotes) 
        {
            *ptr = '\0';
            fields[field_count++] = field_start;
            field_start = ptr + 1;
        }
        ptr++;
    }
    
    if (field_count < max_fields) 
    {
        fields[field_count++] = field_start;
    }

    return field_count;
}


char *my_strdup(const char *str) 
{
    char *dup = malloc(strlen(str) + 1);
    if (dup) 
    {
        strcpy(dup, str);
    }
    return dup;
}


const char* getId(Pokemon *pokemon) 
{
    return pokemon->id;
}

const char* getName(Pokemon *pokemon) 
{
    return pokemon->name;
}

const char* getDescription(Pokemon *pokemon) 
{
    return pokemon->description;
}

const char* getType(Pokemon *pokemon, int index) 
{
    if (index >= 0 && index < MAX_TYPES) 
    {
        return pokemon->types[index];
    }
    return "";
}

const char* getAbility(Pokemon *pokemon, int index) 
{
    if (index >= 0 && index < MAX_ABILITIES) 
    {
        return pokemon->abilities[index];
    }
    return "";
}

double getWeight(Pokemon *pokemon) 
{
    return pokemon->weight;
}

double getHeight(Pokemon *pokemon) 
{
    return pokemon->height;
}

bool getIsLegendary(Pokemon *pokemon) 
{
    return pokemon->isLegendary;
}

int getGeneration(Pokemon *pokemon) 
{
    return pokemon->generation;
}

int getCaptureRate(Pokemon *pokemon) 
{
    return pokemon->captureRate;
}

struct tm getCaptureDate(Pokemon *pokemon) 
{
    return pokemon->captureDate;
}


void lerPokemon(FILE *file, Pokemon *pokedex, int *n) 
{
    char line[1024];

    fgets(line, sizeof(line), file); 

    while (fgets(line, sizeof(line), file) != NULL) 
    {
        line[strcspn(line, "\n")] = '\0'; 

        Pokemon p;
        memset(&p, 0, sizeof(Pokemon)); 

        char *fields[12]; 
        int field_count = split_csv_line(line, fields, 12);

    
        strncpy(p.id, fields[0], MAX_STRING);


        p.generation = atoi(fields[1]);


        strncpy(p.name, fields[2], MAX_STRING);


        strncpy(p.description, fields[3], MAX_STRING);

        strncpy(p.types[0], fields[4], MAX_STRING);
        if (strlen(fields[5]) > 0) 
        {
            strncpy(p.types[1], fields[5], MAX_STRING);
        }

        
        char *abilities_field = fields[6];

        if (abilities_field[0] == '"' && abilities_field[strlen(abilities_field) - 1] == '"') 
        {
            abilities_field[strlen(abilities_field) - 1] = '\0';
            abilities_field++;
        }
        
        if (abilities_field[0] == '[' && abilities_field[strlen(abilities_field) - 1] == ']') 
        {
            abilities_field[strlen(abilities_field) - 1] = '\0';
            abilities_field++;
        }


        char *abilityToken;
        char *restAbilities = abilities_field;
        int abilityIndex = 0;
        while ((abilityToken = strtok(restAbilities, ",")) && abilityIndex < MAX_ABILITIES)
        {

            while (*abilityToken == ' ' || *abilityToken == '\'') abilityToken++;
            char *tempEnd = abilityToken + strlen(abilityToken) - 1;
            while (tempEnd > abilityToken && (*tempEnd == ' ' || *tempEnd == '\'')) 
            {
                *tempEnd = '\0';
                tempEnd--;
            }
            if (strlen(abilityToken) > 0 && abilityIndex < MAX_ABILITIES) 
            {
                strncpy(p.abilities[abilityIndex], abilityToken, MAX_STRING);
                abilityIndex++;
            }
            restAbilities = NULL;
        }

        p.weight = atof(fields[7]);


        p.height = atof(fields[8]);


        p.captureRate = atoi(fields[9]);

        
        p.isLegendary = atoi(fields[10]);

        
        struct tm captureDate = {0};
        parseDate(fields[11], &captureDate);
        p.captureDate = captureDate;

        pokedex[*n] = p;
        (*n)++;
    }
}
void imprimirPokemon(Pokemon* pokemon){
    char dateStr[11];
    strftime(dateStr, sizeof(dateStr), "%d/%m/%Y", &pokemon->captureDate);

    printf(
            "[#%s -> %s: %s - [", 
            getId(pokemon), 
            getName(pokemon), 
            getDescription(pokemon)
    );

    // Tipos
    for (int j = 0; j < MAX_TYPES && strlen(getType(pokemon, j)) > 0; j++) 
    {
        if (j > 0) printf(", ");
        printf("'%s'", getType(pokemon, j));
    }
    printf("] - [");

    // Habilidades
    for (int j = 0; j < MAX_ABILITIES && strlen(getAbility(pokemon, j)) > 0; j++) 
    {
        if (j > 0) printf(", ");
        printf("'%s'", getAbility(pokemon, j));
    }
    printf("] - ");

    // Peso, altura, taxa de captura, se é lendário, geração e data de captura
    printf("%.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n", 
        getWeight(pokemon), 
        getHeight(pokemon), 
        getCaptureRate(pokemon), 
        getIsLegendary(pokemon) ? "true" : "false", 
        getGeneration(pokemon), 
        dateStr
    );
}
long long now() {
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return (tv.tv_sec * 1000LL) + (tv.tv_usec / 1000);  
}
//int quantidadeComparacoes = 0;
//int quantidadeMovimentacoes = 0;
int compareDates(struct tm date1, struct tm date2) {
    time_t time1 = mktime(&date1);
    time_t time2 = mktime(&date2);

    if (time1 > time2) {
        return 1;
    } else if (time1 < time2) {
        return -1;
    } else {
        return 0;
    }
}
void insercaoParcial(Pokemon array[], int n){
    int k = 0;
    while(k < 10){
        for (int i = 1; i < n; i++) {
            Pokemon tmp = array[i];
            int j = i - 1;
            while ((j >= 0) && compareDates(array[j].captureDate, tmp.captureDate) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        
        for (int i = 1; i < n; i++) {
            Pokemon key = array[i];
            int j = i - 1;

            while (j >= 0 && compareDates(array[j].captureDate, key.captureDate) == 0 && 
            strcmp(array[j].name, key.name) > 0) {
            array[j + 1] = array[j];
            j--;
        }
            array[j + 1] = key;
        }
        k++;
    }
}
int main() {
    //long long inicio = now();
    FILE *file = fopen("/tmp/pokemon.csv", "r");
    if (file == NULL) 
    {        perror("Erro ao abrir arquivo");
        return 1;
    }

    Pokemon pokedex[MAX_POKEMON];
    int comparacoes = 0;
    int quantidadePokemons = 0;
    lerPokemon(file, pokedex, &quantidadePokemons);
    fclose(file);


    char numero[MAX_STRING];
    Pokemon pokemonsSelecionados[MAX_POKEMON];
    int id;
    int quantidadePokemonsSelecionados = 0;
    bool encontrou;

    scanf("%s",numero);
    while(strcmp(numero,"FIM") != 0) {
        id = atoi(numero);
        encontrou = false;
        int i=0;
        while(encontrou == false && i < MAX_POKEMON) {
            comparacoes++;
            if (atoi(pokedex[i].id) == id) {
                pokemonsSelecionados[quantidadePokemonsSelecionados] = pokedex[i];
                quantidadePokemonsSelecionados++;
                encontrou = true;
            }
            i++;
        }
        if(encontrou == false) {
            printf("Pokemos com ID %d nao encontrado.",id);
        }
        scanf("%s",numero);
    }

    insercaoParcial(pokemonsSelecionados, quantidadePokemonsSelecionados);
    for(int i = 0; i < 10; i++){
        imprimirPokemon(&pokemonsSelecionados[i]);
    }

    //long long fim = now();
    /*
    FILE *arq = fopen("matrícula_radixsort.txt", "w");
    if (arq == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }
    fprintf(arq, "851234\t%d\t%d\t%lf", quantidadeComparacoes, quantidadeMovimentacoes, (double)(fim - inicio) / 1000.0);
    fclose(arq);
    return 0;
    */
}