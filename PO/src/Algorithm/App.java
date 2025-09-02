package Algorithm;

import java.util.*;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n\t    === MENU ===");
        System.out.println("1 - Gerar e Gravar Dados em Arquivo");
        System.out.println("2 - Ler e Exibir Dados de um Arquivo");
        System.out.println("3 - Ordenar");
        System.out.println("0 - Sair");
        System.out.print("\nDigite a opção que deseja executar: ");
    }

    public static void executarOpcao(int op) {
        switch (op) {
            case 1:
                GenRecord.alert();
                GenRecord.Gravar(sc);
                break;
            case 2:
                ReadShow.alert();
                ReadShow.Ler(sc);
                break;
            case 3:
                System.out.print("Informe o nome do arquivo (sem extensão): ");
                String nomeArquivo = sc.next() + ".txt";

                int[] numeros = ReadShow.lerArquivo(nomeArquivo);

                if (numeros.length == 0) {
                    System.out.println("Não há números para ordenar.");
                } else {
                    System.out.println("\nNúmeros originais:");
                    System.out.println(Arrays.toString(numeros));

                    SearchOrd.Menu(sc, numeros);

                    System.out.println("\nNúmeros ordenados:");
                    System.out.println(Arrays.toString(numeros));
                }
                break;

            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void main(String[] args) {
        int op;
        do {
            mostrarMenu();
            op = sc.nextInt();
            executarOpcao(op);
        } while (op != 0);

    }
}
