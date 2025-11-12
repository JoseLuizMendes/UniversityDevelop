package trabalho;

import java.util.Scanner;

import trabalho.Estatisticas;
public class PesquisaOrdenacao {
	public static Scanner sc = new Scanner(System.in);

	// ------------------- MENU -------------------
	public static void menu(Scanner scanner, int[] arr) {
		System.out.println("========== MENU DE ORDENAÇÃO ========= ");
		System.out.println("1 - QUICKSORT "); // perde eficiencia em arquivos pequenos
												//TODO:implementar inserção direta
		System.out.println("2 - PESQUISA SEQUENCIAL ");
		System.out.println("3 - PESQUISA MELHORADA");
		System.out.println("4 - PESQUISA BINARIA");
		System.out.println("0 - Sair ");
		System.out.print("===================================== ");
		System.out.print("\nEscolha uma opção: ");

		int opcao = scanner.nextInt();
		Estatisticas st = null;

		switch (opcao) {
			case 1:
				st = quickSort(arr);
				break;
			case 2:
				Search(arr, opcao);
				break;
			case 3:
				st = pesqMelhorada();
				break;
			case 4: 
				st = pesqBinaria();
				break;
			case 0:
				System.out.println("Retornando... ");
				return;
			default:
				System.out.println("Opção inválida! ");
		}

		if (st != null) {
			System.out.println(st);
		}
	}

	
	
	// ------------------- QUICKSORT (versão contagem exata) -------------------
	public static Estatisticas quickSort(int[] arr) {
		long comparacoes = 0, movimentacoes = 0;
		long inicio = System.nanoTime();
		
		if (arr.length > 1) {
			long[] contadores = new long[2];
			ordena(arr, 0, arr.length - 1, contadores);
			comparacoes = contadores[0];
			movimentacoes = contadores[1];
		}
		
		long fim = System.nanoTime();
		return new Estatisticas(comparacoes, movimentacoes, fim - inicio);
	}
	
	private static void ordena(int[] arr, int esq, int dir, long[] contadores) {
		int i = esq, j = dir;
		int pivo = arr[(i + j) / 2];
		
		do {
			
			contadores[0]++;
			while (i <= dir && arr[i] < pivo) {
				i++;
				contadores[0]++;
			}
			contadores[0]++;
			
			while (j >= esq && arr[j] > pivo) {
				j--;
				contadores[0]++;
			}
			
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				contadores[1] += 1;
				i++;
				j--;
			}
			
		} while (i <= j);
		
		if (esq < j)
		ordena(arr, esq, j, contadores);
		if (i < dir)
		ordena(arr, i, dir, contadores);
	}

	// ------------------- INSERÇÃO DIRETA -------------------
	public static Statistics insertionSort(int[] arr) {
        long comps = 0, moves = 0;
        long start = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            moves++;
            int j = i - 1;
            while (j >= 0) {
                comps++;
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    moves++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
            moves++;
        }

        long end = System.nanoTime();
        return new Statistics(comps, moves, end - start);
    }

	
	// ------------------- PESQUISA SEQUENCIAL -------------------
	private static boolean find(int[]arr){
		System.out.println("Informe o número desejado: ");
		int num = sc.nextInt();
		for(int i =0; i<arr.length; i++){
			if (arr[i] == num){
				return true;
			}
		}
		return false;
	}
	
	private static void Search (int[]arr,int num){
		if(find(arr)==false){
			System.out.println("Número não encontrado!");
		}
		else{
			System.out.println("Numero encontrado!");
		}
		
	}
	// ------------------- PESQUISA MELHORADA -------------------
	private static Estatisticas pesqMelhorada() {
	
		throw new UnsupportedOperationException("Unimplemented method 'pesqMelhorada'");
	}
	// ------------------- PESQUISA BINARIA -------------------
	private static Estatisticas pesqBinaria() {
		throw new UnsupportedOperationException("Unimplemented method 'pesqBinaria'");
	}


}