class Exercicio10{
    public static void main(String[] args) {
        String string = MyIO.readLine();
        while(!"FIM".equals(string)){
            if(ehPalindromoRec(string)) System.out.println("SIM");
            else System.out.println("NAO");
            string = MyIO.readLine();
        }
    }
    private static boolean ehPalindromoRec(String string){
        return ehPalindromoRec2(string, 0, string.length() - 1);
    }
    private static boolean ehPalindromoRec2(String string, int i, int j){
        boolean ehPalindromo;
        if(i < j) ehPalindromo = string.charAt(i) == string.charAt(j) && ehPalindromoRec2(string, i+1, j-1);
        else ehPalindromo = true;
        return ehPalindromo;
    }
}