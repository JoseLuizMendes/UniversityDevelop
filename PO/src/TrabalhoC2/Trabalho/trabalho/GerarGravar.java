package trabalho;
import java.io.*;
import java.util.Scanner;

public class GerarGravar {

	    public static void alerta() {
	        System.out.println(">>> Gerando e salvando números...");
	    }

	    public static int[] gerar(int quantidade, Scanner teclado) {
	        int[] numeros = new int[quantidade];
	        boolean entradaValida = false;
	        boolean entradaValida2;
	        int opcao = 0;

	        do {
	            entradaValida2 = false;
	            do {
	                try {
	                    System.out.println("===== Escolha o tipo de vetor a ser gerado =====");
	                    System.out.println("1 - Aleatório");
	                    System.out.println("2 - Ordenado Crescente");
	                    System.out.println("3 - Ordenado Decrescente");
	                    System.out.print("Opção: ");
	                    opcao = teclado.nextInt();
	                    teclado.nextLine();
	                    entradaValida2 = true;
	                } catch (java.util.InputMismatchException e) {
	                    System.err.println("ENTRADA INVÁLIDA! DIGITE UM NÚMERO INTEIRO!");
	                    teclado.nextLine();
	                }
	            } while (!entradaValida2);

	            switch (opcao) {
	                case 1:
	                    for (int i = 0; i < quantidade; i++) {
	                        numeros[i] = (int) (Math.random() * 100);
	                    }
	                    entradaValida = true;
	                    break;
	                case 2:
	                    for (int i = 0; i < quantidade; i++) {
	                        numeros[i] = (int) (Math.random() * 100);
	                    }
	                    java.util.Arrays.sort(numeros);
	                    entradaValida = true;
	                    break;
	                case 3:
	                    for (int i = 0; i < quantidade; i++) {
	                        numeros[i] = (int) (Math.random() * 100);
	                    }
	                    java.util.Arrays.sort(numeros);
	                    for (int i = 0; i < quantidade / 2; i++) {
	                        int temp = numeros[i];
	                        numeros[i] = numeros[quantidade - i - 1];
	                        numeros[quantidade - i - 1] = temp;
	                    }
	                    entradaValida = true;
	                    break;
	                default:
	                    System.err.println("Opção inválida! Digite 1, 2 ou 3");
	                    break;
	            }
	        } while (!entradaValida);

	        return numeros;
	    }

	    public static void salvarEmArquivo(String nomeArquivo, int[] numeros) {
	        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
	            for (int num : numeros) {
	                escritor.write(num + System.lineSeparator());
	            }
	            System.out.println("Arquivo " + nomeArquivo + " criado com sucesso com " + numeros.length + " números.");
	        } catch (IOException e) {
	            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
	        }
	    }

	    public static void salvar(Scanner sc) {
	        System.out.print("Digite o nome do arquivo (sem extensão): ");
	        String nomeArquivo = sc.next() + ".txt";

	        System.out.print("Digite quantos números você deseja salvar: ");
	        int quantidade = sc.nextInt();

	        int[] numeros = gerar(quantidade, sc); // agora passa o Scanner
	        salvarEmArquivo(nomeArquivo, numeros);
	    }
	}


