import java.util.*;

public class CalculadoraBinDec {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int con = 1;
        // Loop do algoritmo
        while (con != 2) {
            System.out.println("\n CALCULADORA BINÁRIO-DECIMAL \n");
            System.out.println("Escolha uma das duas opções: \n");
            System.out.println("1 - Converter de Binário para Decimal.");
            System.out.println("2 - Converter de Decimal para Binário. \n");
            String ops = scan.next();
            // Permite apenas números inteiros
            try {
                int op = Integer.parseInt(ops);
                // Apenas opções permitidas
                if (op != 1 && op != 2) {
                    System.out.println("Opção inválida! \n");
                } else if (op == 1) {
                    System.out.println("Digite o número Binário: ");
                    String bins = scan.next();
                    // Permite apenas binários
                    for (int i = 0; i < bins.length(); i++) {
                        char c = bins.charAt(i);
                        if (c != '0' && c != '1') {
                            System.out.println("\n Binário Inválido! \n");
                            System.exit(0);
                            ;
                        }
                    }
                    // Permite apenas números inteiros
                    try {
                        System.out.println("\n O inteiro de " + String.valueOf(bins) + " é "
                                + BinDec(String.valueOf(bins)) + ". \n");
                    } catch (NumberFormatException e) {
                        System.out.println("\n O programa apenas aceita números inteiros!");
                    }
                } else {
                    System.out.println("Digite o número Inteiro: ");
                    String decs = scan.next();
                    // Permite apenas números inteiros
                    try {
                        int dec = Integer.parseInt(decs);
                        System.out.println("\n O binário de " + dec + " é " + DecBin(dec) + ". \n");
                    } catch (NumberFormatException e) {
                        System.out.println("\n O programa apenas aceita números inteiros!");
                        break;
                    }
                }
                System.out.println("Deseja continuar? \n");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO \n");
                scan.nextLine();
                String cons = scan.next();
                // Permite apenas números inteiros
                try {
                    con = Integer.parseInt(cons);
                } catch (NumberFormatException e) {
                    System.out.println("\n O programa apenas aceita números inteiros!");
                    break;
                }
                // Apenas opções permitidas
                if (con != 1 && con != 2) {
                    System.out.println("Opção inválida! \n");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n O programa apenas aceita números inteiros!");
                break;
            }
        }
        scan.close();
    }

    // Função para converter binário para decimal
    static int BinDec(String bin) {
        int decimal = 0, exp = 0;
        // Array necessária para separar o binário
        char tam[] = bin.toCharArray();
        // Loop inverso para pegar os índices
        for (int i = tam.length - 1; i >= 0; i--) {
            // Verifica se é 0 ou 1
            if (tam[i] == '0') {
                exp = exp + 1;
            }
            if (tam[i] == '1') {
                decimal = decimal + (int) Math.pow(2, exp);
                exp = exp + 1;
            }
        }
        return decimal;
    }

    // Função para converter decimal para binário
    static String DecBin(int decimal) {
        String binario = "";
        // Faz as divisões até não restar nada
        while (decimal > 0) {
            // Pega o resto de cada divisão
            int resto = decimal % 2;
            // Monta o código binário
            binario = binario + resto;
            // Faz o próximo número a ser dividido
            decimal /= 2;
        }
        // Separa os números para melhor visualização
        StringBuilder resultado = new StringBuilder(binario);
        for (int i = 4; i < resultado.length(); i += 5) {
            resultado.insert(i, ' ');
        }
        return resultado.reverse().toString();
    }
}