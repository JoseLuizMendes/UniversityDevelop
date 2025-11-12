package trabalho;

import java.util.Scanner;
import java.util.Arrays;

public class App {



		public static Scanner sc = new Scanner(System.in);

		public static void mostrarMenu() {
			System.out.println("============== MENU ============== ");
			System.out.println("1 - Gerar e Salvar Dados em Arquivo ");
			System.out.println("2 - Ler e Exibir Dados do Arquivo ");
			System.out.println("3 - Ordenar ");
			System.out.println("0 - Sair ");
			System.out.println("================================== ");	
			System.out.print("\nEscolha uma opção: ");
		}

		public static void executarOpcao(int opcao) {
			switch (opcao) {
			case 1:
				GerarGravar.alerta();
				GerarGravar.salvar(sc);
				break;
			case 2:
				LerExibir.alerta();
				LerExibir.ler(sc);
				break;
			case 3:
				System.out.print("Digite o nome do arquivo (sem extensão): ");
				String nomeArquivo = sc.next() + ".txt ";

				int[] numeros = LerExibir.lerArquivo(nomeArquivo);

				if (numeros.length == 0) {
					System.out.println("Não há números para ordenar. ");
				} else {
					System.out.println("\n Números originais: ");
					System.out.println(Arrays.toString(numeros));

					PesquisaOrdenacao.menu(sc, numeros);

					System.out.println("\nNúmeros ordenados: ");
					System.out.println(Arrays.toString(numeros));
				}
				break;

			case 0:
				System.out.println("Saindo... ");
				break;
			default:
				System.out.println("Opção inválida! ");
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


