package Algorithm;

import java.util.Scanner;

public class SearchOrd {

    // ------------------- MENU -------------------
    public static void Menu(Scanner sc, int[] vetor) {
        System.out.println("\n\t    === MENU ORDENAÇÃO ===");
        System.out.println("1 - SELEÇÃO DIRETA");
        System.out.println("2 - BUBBLESORT");
        System.out.println("3 - INSERÇÃO DIRETA");
        System.out.println("4 - SHELLSORT");
        System.out.println("5 - HEAPSORT");
        System.out.println("0 - Sair");
        System.out.print("\nDigite a opção que deseja executar: ");

        int op = sc.nextInt();
        Statistics est = null;

        switch (op) {
            case 1: est = selecaoDireta(vetor); break;
            case 2: est = bubbleSort(vetor); break;
            case 3: est = insercaoDireta(vetor); break;
            case 4: est = shellSort(vetor); break;
            case 5: est = heapSort(vetor); break;
            case 0: System.out.println("Voltando..."); return;
            default: System.out.println("Opção inválida!");
        }

        if (est != null) {
            System.out.println(est);
        }
    }

    // ------------------- SELEÇÃO DIRETA -------------------
    public static Statistics selecaoDireta(int[] vetor) {
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[minimo]) {
                    minimo = j;
                }
            }
            if (minimo != i) {
                int temp = vetor[minimo];
                vetor[minimo] = vetor[i];
                vetor[i] = temp;
                movimentacoes += 3;
            }
        }

        long fim = System.nanoTime();
        return new Statistics(comparacoes, movimentacoes, fim - inicio);
    }

    // ------------------- BUBBLESORT -------------------
    public static Statistics bubbleSort(int[] vetor) {
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = vetor.length - 1;
        int i, j;
        do {
            i = 0;
            for (j = 0; j < n; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    movimentacoes += 3;
                    i = j;
                }
            }
            n = i;
        } while (n >= 1);

        long fim = System.nanoTime();
        return new Statistics(comparacoes, movimentacoes, fim - inicio);
    }

    // ------------------- INSERÇÃO DIRETA -------------------
    public static Statistics insercaoDireta(int[] vetor) {
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int temp = vetor[i];
            movimentacoes++;
            int j = i - 1;
            while (j >= 0) {
                comparacoes++;
                if (vetor[j] > temp) {
                    vetor[j + 1] = vetor[j];
                    movimentacoes++;
                    j--;
                } else {
                    break;
                }
            }
            vetor[j + 1] = temp;
            movimentacoes++;
        }

        long fim = System.nanoTime();
        return new Statistics(comparacoes, movimentacoes, fim - inicio);
    }

    // ------------------- SHELLSORT -------------------
    public static Statistics shellSort(int[] vetor) {
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = vetor.length;
        int h = 1;
        do {
            h = 3 * h + 1;
        } while (h < n);

        do {
            h = h / 3;
            for (int i = h; i < n; i++) {
                int temp = vetor[i];
                movimentacoes++;
                int j = i;
                while (j >= h) {
                    comparacoes++;
                    if (vetor[j - h] > temp) {
                        vetor[j] = vetor[j - h];
                        movimentacoes++;
                        j -= h;
                    } else {
                        break;
                    }
                }
                vetor[j] = temp;
                movimentacoes++;
            }
        } while (h > 1);

        long fim = System.nanoTime();
        return new Statistics(comparacoes, movimentacoes, fim - inicio);
    }

    // ------------------- HEAPSORT -------------------
    public static Statistics heapSort(int[] vetor) {
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int dir = vetor.length - 1;
        int esq = (dir - 1) / 2;

        while (esq >= 0) {
            comparacoes += refazHeap(vetor, esq--, vetor.length - 1);
        }

        while (dir > 0) {
            int temp = vetor[0];
            vetor[0] = vetor[dir];
            vetor[dir--] = temp;
            movimentacoes += 3;
            comparacoes += refazHeap(vetor, 0, dir);
        }

        long fim = System.nanoTime();
        return new Statistics(comparacoes, movimentacoes, fim - inicio);
    }

    private static long refazHeap(int[] vetor, int esq, int dir) {
        long comparacoes = 0;
        int i = esq;
        int maiorFilho = 2 * i + 1;
        int raiz = vetor[i];
        boolean heap = false;

        while ((maiorFilho <= dir) && (!heap)) {
            if (maiorFilho < dir) {
                comparacoes++;
                if (vetor[maiorFilho] < vetor[maiorFilho + 1]) {
                    maiorFilho++;
                }
            }
            comparacoes++;
            if (raiz < vetor[maiorFilho]) {
                vetor[i] = vetor[maiorFilho];
                i = maiorFilho;
                maiorFilho = 2 * i + 1;
            } else {
                heap = true;
            }
        }
        vetor[i] = raiz;
        return comparacoes;
    }
}
