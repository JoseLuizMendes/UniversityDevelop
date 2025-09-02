package Algorithm;
import java.io.*;
import java.util.*;

public class GenRecord {
    
    public static void alert() {
        System.out.println(">>> Gerando e gravando números...");
    }
    
    public static int[] Gerar(int qnt) {
        int[] numeros = new int[qnt];
        for (int i = 0; i < qnt; i++) {
            numeros[i] = (int)(Math.random() * 100);
        }
        return numeros;
    }

    public static void gravarArquivo(String nomeArquivo, int[] numeros) {                
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int numero : numeros) {
                escritor.write(numero + System.lineSeparator());
            }
            System.out.println("Arquivo " + nomeArquivo + " criado com sucesso, contendo " + numeros.length + " números");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void Gravar(Scanner sc) {
        System.out.print("Informe o nome do arquivo (sem extensão): ");
        String nomeArquivo = sc.next() + ".txt";
        
        System.out.print("Agora informe a quantidade de números que deseja gravar no arquivo: ");
        int qnt = sc.nextInt();
        
        int[] numeros = Gerar(qnt);  
        gravarArquivo(nomeArquivo, numeros);     
    }
}
