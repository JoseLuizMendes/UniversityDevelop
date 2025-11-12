package trabalho;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerExibir {
	
		public static void alerta() {
			System.out.println(">>> Lendo arquivo... ");
		}

		public static int[] lerArquivo(String nomeArquivo) {
			List<Integer> numTemp = new ArrayList<>();
			try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
				String linha;
				while ((linha = leitor.readLine()) != null) {
					int num = Integer.parseInt(linha);
					numTemp.add(num);
				}
			} catch (FileNotFoundException e) {
				System.err.println("Erro: Arquivo " + nomeArquivo + " não encontrado! ");
			} catch (IOException e) {
				System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			} catch (NumberFormatException e) {
				System.err.println("Erro: O arquivo contém dados inválidos (não inteiros). ");
			}

			int[] numeros = new int[numTemp.size()];
			for (int i = 0; i < numTemp.size(); i++) {
				numeros[i] = numTemp.get(i);
			}
			return numeros;
		}

		public static void mostrarNumeros(int[] numeros, String nomeArquivo) {
			if (numeros.length == 0) {
				System.out.println("O arquivo " + nomeArquivo + " está vazio ou não pôde ser lido. ");
			} else {
				System.out.println("\n--- Conteúdo do arquivo: " + nomeArquivo + " ---\n");
				for (int num : numeros) {
					System.out.println(num);
				}
				System.out.println("--------------------------------------\n");
			}
		}

		public static void ler(Scanner sc) {
			System.out.print("Digite o nome do arquivo (sem extensão): ");
			String nomeArquivo = sc.next() + ".txt";

			int[] numeros = lerArquivo(nomeArquivo);
			mostrarNumeros(numeros, nomeArquivo);
		}
	}


