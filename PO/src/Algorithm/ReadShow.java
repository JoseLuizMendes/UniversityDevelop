package Algorithm;
import java.io.*;
import java.util.*;

public class ReadShow {
    
    public static void alert() {
        System.out.println(">>> Lendo arquivo...");
    }

    public static int[] lerArquivo(String nomeArquivo) {
        List<Integer> numerosTemp = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                int numero = Integer.parseInt(linha);
                numerosTemp.add(numero);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro: O arquivo " + nomeArquivo + " não foi encontrado!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro: O arquivo contém dados inválidos (não são inteiros).");
        }

        // Converter List<Integer> para int[]
        int[] numeros = new int[numerosTemp.size()];
        for (int i = 0; i < numerosTemp.size(); i++) {
            numeros[i] = numerosTemp.get(i);
        }
        return numeros;
    }

    public static void exibirNumeros(int[] numeros, String nomeArquivo) {
        if (numeros.length == 0) {
            System.out.println("O arquivo " + nomeArquivo + " está vazio ou não pôde ser lido.");
        } else {
            System.out.println("\n--- Conteúdo do arquivo " + nomeArquivo + " ---\n");
            for (int numero : numeros) {
                System.out.println(numero);
            }
            System.out.println("----------------------------------------------\n");
        }
    }
    
    public static void Ler(Scanner sc) {
        System.out.print("Informe o nome do arquivo (sem extensão): ");
        String nomeArquivo = sc.next() + ".txt";
        
        int[] numeros = lerArquivo(nomeArquivo);   
        exibirNumeros(numeros, nomeArquivo);                
    }
}
