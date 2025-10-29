package trabalho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PesquisaOrdenacao {
	public static Scanner sc = new Scanner(System.in);

	// resultado auxiliar para pesquisas: estatísticas + posição/encontrado
	private static class SearchResult {
		public Estatisticas stats;
		public boolean found;
		public int pos;

		public SearchResult(Estatisticas stats, boolean found, int pos) {
			this.stats = stats;
			this.found = found;
			this.pos = pos;
		}
	}

	// ------------------- MENU -------------------
	public static void menu(Scanner scanner, int[] arr) {
		System.out.println("========== MENU DE ORDENAÇÃO ========= ");
		System.out.println("1 - QUICKSORT "); // perde eficiencia em arquivos pequenos
		System.out.println("2 - INSERÇÃO DIRETA "); // eficiente para arquivos pequenos
		System.out.println("3 - PESQUISA SEQUENCIAL ");
		System.out.println("4 - PESQUISA MELHORADA");
		System.out.println("5 - PESQUISA BINARIA");
		System.out.println("6 - PESQUISA HASHING");
		System.out.println("7 - ECONTRAR MAIOR E MENOR");
		System.out.println("8 - CALCULAR MODA");
		System.out.println("9 - COMPARAR DESEMPENHO (SEQUENCIAL VS BINARIA)");
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
				st = insertionSort(arr);
				break;
			case 3:
				st = Search(arr);
				break;
			case 4:
				st = optimizedSearchPrompt(arr);
				break;
			case 5:
				st = pesqBinaria(arr);
				break;
			case 6:
				st = HashingSearch(arr);
				break;
			case 7:
				st = maiorMenor(arr);
				break;
			case 8:
				st = moda(arr);
				break;
			case 9:
				System.out.println("Comparando desempenho entre Pesquisa Sequencial e Pesquisa Binária...");
				st = compararDesempenho(arr, opcao);
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
	public static Estatisticas insertionSort(int[] arr) {
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
		return new Estatisticas(comps, moves, end - start);
	}

	// ------------------- PESQUISA SEQUENCIAL -------------------
	private static boolean find(int[] arr) {
		System.out.println("Informe o número desejado: ");
		int num = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}

	// wrapper que solicita o valor e mostra o resultado
	private static Estatisticas Search(int[] arr) {
		System.out.println("Informe o número desejado: ");
		int chave = sc.nextInt();
		SearchResult r = sequentialSearchInternal(arr, chave, true);
		return r.stats;
	}

	// versão que recebe o valor e mostra o resultado
	private static Estatisticas Search(int[] arr, int num) {
		SearchResult r = sequentialSearchInternal(arr, num, true);
		return r.stats;
	}

	// pesquisa sequencial interna (silenciosa quando printResult == false)
	private static SearchResult sequentialSearchInternal(int[] arr, int chave, boolean printResult) {
		long inicio = System.nanoTime();
		long comparacoes = 0;
		long movimentacoes = 0;
		boolean encontrado = false;
		int pos = -1;
		for (int i = 0; i < arr.length; i++) {
			comparacoes++;
			movimentacoes++;
			if (arr[i] == chave) {
				encontrado = true;
				pos = i;
				if (printResult)
					System.out.println("Número encontrado na posição " + i + "!");
				break;
			}
		}
		if (!encontrado && printResult) {
			System.out.println("Nenhum número encontrado!");
		}
		long fim = System.nanoTime();
		return new SearchResult(new Estatisticas(comparacoes, movimentacoes, fim - inicio), encontrado, pos);
	}

	// ------------------- PESQUISA SEQUENCIAL OTIMIZADA -------------------
	// percorre vetor ordenado e para se encontrar um elemento maior que a chave
	private static SearchResult sequentialOptimizedInternal(int[] arrSorted, int chave, boolean printResult) {
		long inicio = System.nanoTime();
		long comparacoes = 0;
		long movimentacoes = 0;
		boolean encontrado = false;
		int pos = -1;
		for (int i = 0; i < arrSorted.length; i++) {
			comparacoes++; // comparacao arr[i] vs chave
			movimentacoes++; // acesso
			if (arrSorted[i] == chave) {
				encontrado = true;
				pos = i;
				if (printResult)
					System.out.println("Número encontrado na posição " + pos + "!");
				break;
			} else if (arrSorted[i] > chave) {
				// como o vetor está ordenado, podemos parar
				break;
			}
		}
		if (!encontrado && printResult)
			System.out.println("Nenhum número encontrado!");
		long fim = System.nanoTime();
		return new SearchResult(new Estatisticas(comparacoes, movimentacoes, fim - inicio), encontrado, pos);
	}

	// wrapper que pergunta ao usuário e usa a versão otimizada (ordenando uma
	// cópia)
	private static Estatisticas optimizedSearchPrompt(int[] arr) {
		System.out.println("Informe o número desejado: ");
		int chave = sc.nextInt();
		int[] copia = arr.clone();
		java.util.Arrays.sort(copia);
		SearchResult r = sequentialOptimizedInternal(copia, chave, true);
		return r.stats;
	}

	// ------------------- PESQUISA MELHORADA -------------------
	private static boolean Maior(int[] arr) {
		System.out.println("Informe o número desejado: ");
		int num = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > num) {
				return true;
			}
		}
		return false;
	}

	private static void MelhoradaSearch(int[] arr, int num) {
		if (find(arr) == false) {
			System.out.println("Nenhum número maior que " + num + " encontrado!");
		} else {
			System.out.println("Número maior que " + num + " encontrado na posição " + Maior(arr) + "!");
		}

	}

	// ------------------- PESQUISA BINARIA -------------------
	// versão que solicita o valor e delega para a versão que recebe a chave
	private static Estatisticas pesqBinaria(int[] arr) {
		System.out.println("Informe o número desejado: ");
		int chave = sc.nextInt();
		// binary search precisa do vetor ordenado -> usaremos uma cópia ordenada
		int[] copia = arr.clone();
		java.util.Arrays.sort(copia);
		SearchResult r = pesqBinariaInternal(copia, chave, true);
		return r.stats;
	}

	// pesquisa binária interna que retorna posição e estatísticas; pode ficar
	// silenciosa
	private static SearchResult pesqBinariaInternal(int[] arr, int chave, boolean printResult) {
		long inicio = System.nanoTime();
		long comparacoes = 0;
		long movimentacoes = 0;
		int esq = 0;
		int dir = arr.length - 1;
		boolean encontrado = false;
		int pos = -1;
		while (esq <= dir) {
			int meio = esq + (dir - esq) / 2;
			comparacoes++;
			movimentacoes++; // avaliação do meio
			if (arr[meio] == chave) {
				encontrado = true;
				pos = meio;
				if (printResult)
					System.out.println("Número encontrado na posição " + pos + "!");
				break;
			} else if (arr[meio] < chave) {
				esq = meio + 1;
			} else {
				dir = meio - 1;
			}
		}
		if (!encontrado && printResult) {
			System.out.println("Nenhum número encontrado!");
		}
		long fim = System.nanoTime();
		return new SearchResult(new Estatisticas(comparacoes, movimentacoes, fim - inicio), encontrado, pos);
	}

	private static Estatisticas HashingSearch(int[] arr) {
		// tabela hash por encadeamento e realiza inserção de todos os elementos
		long inicio = System.nanoTime();
		long comparacoes = 0;
		long movimentacoes = 0;

		int M = Math.max(3, arr.length * 2 + 1);

		HashTableChaining table = new HashTableChaining(M);

		for (int v : arr) {
			table.insert(v);
			movimentacoes++;
		}

		System.out.println("Informe o número desejado para buscar na tabela hash:");
		int chave = sc.nextInt();

		boolean encontrado = table.contains(chave);
		comparacoes = table.getLastSearchComparisons();
		if (encontrado) {
			System.out.println("Chave " + chave + " encontrada na tabela hash.");
		} else {
			System.out.println("Chave " + chave + " NÃO encontrada na tabela hash.");
		}

		long fim = System.nanoTime();
		return new Estatisticas(comparacoes, movimentacoes, fim - inicio);
	}

	// função de hashing por divisão
	public static int Hashing(int chave, int M) {
		int idx = chave % M;
		if (idx < 0)
			idx += M;
		return idx;
	}

	private static Estatisticas compararDesempenho(int[] arr, int num) {
		// pedir uma única vez o valor ao usuário
		System.out.println("Informe o número desejado: ");
		int chave = sc.nextInt();

		// Pesquisa sequencial (no vetor original) - silenciosa
		SearchResult seqR = sequentialSearchInternal(arr, chave, false);

		// Pesquisa binária (em uma cópia ordenada) - silenciosa
		int[] copiaOrdenada = arr.clone();
		java.util.Arrays.sort(copiaOrdenada);
		SearchResult binR = pesqBinariaInternal(copiaOrdenada, chave, false);

		// Relatório comparativo simples
		System.out.println("\n--- Relatório comparativo ---");
		if (seqR.found)
			System.out.println("Pesquisa Sequencial: encontrado na posição " + seqR.pos + " -> " + seqR.stats);
		else
			System.out.println("Pesquisa Sequencial: não encontrado -> " + seqR.stats);

		if (binR.found)
			System.out.println("Pesquisa Binária:    encontrado na posição " + binR.pos + " -> " + binR.stats);
		else
			System.out.println("Pesquisa Binária:    não encontrado -> " + binR.stats);

		if (seqR.stats.tempoExecucao < binR.stats.tempoExecucao) {
			System.out.println("Resultado: Pesquisa Sequencial foi mais rápida (por tempo).\n");
		} else if (seqR.stats.tempoExecucao > binR.stats.tempoExecucao) {
			System.out.println("Resultado: Pesquisa Binária foi mais rápida (por tempo).\n");
		} else {
			System.out.println("Resultado: Empate no tempo.\n");
		}

		// retornar estatísticas sequenciais como resumo (compatibilidade)
		return seqR.stats;
	}

	// tabela hash com encadeamento
	private static class HashTableChaining {
		private ArrayList<LinkedList<Integer>> table;
		private int M;
		private long lastSearchComparisons = 0;

		public HashTableChaining(int M) {
			this.M = M;
			table = new ArrayList<>(M);
			for (int i = 0; i < M; i++) {
				table.add(new LinkedList<>());
			}
		}

		public void insert(int chave) {
			int idx = Hashing(chave, M);
			LinkedList<Integer> bucket = table.get(idx);
			for (Integer v : bucket) {
				if (v == chave)
					return;
			}
			bucket.add(chave);
		}

		public boolean contains(int chave) {
			lastSearchComparisons = 0;
			int idx = Hashing(chave, M);
			LinkedList<Integer> bucket = table.get(idx);
			for (Integer v : bucket) {
				lastSearchComparisons++;
				if (v == chave)
					return true;
			}
			return false;
		}

		public long getLastSearchComparisons() {
			return lastSearchComparisons;
		}
	}

	private static Estatisticas maiorMenor(int[] arr) {
		int maior = arr[0];
		int menor = arr[0];
		long inicio = System.nanoTime();
		long movimentacoes = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maior) {
				maior = arr[i];
				movimentacoes++;
			} else if (arr[i] < menor) {
				menor = arr[i];
				movimentacoes++;
			}
		}
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		long fim = System.nanoTime();
		return new Estatisticas(0, movimentacoes, fim - inicio);

	}

	private static Estatisticas moda(int[] arr) {
		long inicio = System.nanoTime();
		long movimentacoes = 0;
		int moda = arr[0];
		int maxCount = 0;
		for (int i = 1; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				moda = arr[i];
				movimentacoes++;
			}
		}
		long fim = System.nanoTime();
		System.out.println("Moda: " + moda + " (ocorrências: " + maxCount + ")");
		return new Estatisticas(0, movimentacoes, fim - inicio);
	}

}