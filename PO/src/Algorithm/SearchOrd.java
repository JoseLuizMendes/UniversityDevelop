package Algorithm;

import java.util.Scanner;

public class SearchOrd {

    // ------------------- MENU -------------------
    public static void menu(Scanner sc, int[] arr) {
        System.out.println("\n\t    === SORTING MENU ===");
        System.out.println("1 - SELECTION SORT");
        System.out.println("2 - BUBBLESORT");
        System.out.println("3 - INSERTION SORT");
        System.out.println("4 - SHELLSORT");
        System.out.println("5 - HEAPSORT");
        System.out.println("0 - Exit");
        System.out.print("\nChoose an option: ");

        int op = sc.nextInt();
        Statistics st = null;

        switch (op) {
            case 1: st = selectionSort(arr); break;
            case 2: st = bubbleSort(arr); break;
            case 3: st = insertionSort(arr); break;
            case 4: st = shellSort(arr); break;
            case 5: st = heapSort(arr); break;
            case 0: System.out.println("Returning..."); return;
            default: System.out.println("Invalid option!");
        }

        if (st != null) {
            System.out.println(st);
        }
    }

    // ------------------- SELECTION SORT -------------------
    public static Statistics selectionSort(int[] arr) {
        long comps = 0, moves = 0;
        long start = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comps++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                moves += 3;
            }
        }

        long end = System.nanoTime();
        return new Statistics(comps, moves, end - start);
    }

    // ------------------- BUBBLESORT -------------------
    public static Statistics bubbleSort(int[] arr) {
        long comps = 0, moves = 0;
        long start = System.nanoTime();

        int n = arr.length - 1;
        int i, j;
        do {
            i = 0;
            for (j = 0; j < n; j++) {
                comps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    moves += 3;
                    i = j;
                }
            }
            n = i;
        } while (n >= 1);

        long end = System.nanoTime();
        return new Statistics(comps, moves, end - start);
    }

    // ------------------- INSERTION SORT -------------------
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

    // ------------------- SHELLSORT -------------------
    public static Statistics shellSort(int[] arr) {
        long comps = 0, moves = 0;
        long start = System.nanoTime();

        int n = arr.length;
        int h = 1;
        do {
            h = 3 * h + 1;
        } while (h < n);

        do {
            h = h / 3;
            for (int i = h; i < n; i++) {
                int temp = arr[i];
                moves++;
                int j = i;
                while (j >= h) {
                    comps++;
                    if (arr[j - h] > temp) {
                        arr[j] = arr[j - h];
                        moves++;
                        j -= h;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
                moves++;
            }
        } while (h > 1);

        long end = System.nanoTime();
        return new Statistics(comps, moves, end - start);
    }

    // ------------------- HEAPSORT -------------------
    public static Statistics heapSort(int[] arr) {
        long comps = 0, moves = 0;
        long start = System.nanoTime();

        int dir = arr.length - 1;
        int left = (dir - 1) / 2;

        while (left >= 0) {
            comps += rebuildHeap(arr, left--, arr.length - 1);
        }

        while (dir > 0) {
            int temp = arr[0];
            arr[0] = arr[dir];
            arr[dir--] = temp;
            moves += 3;
            comps += rebuildHeap(arr, 0, dir);
        }

        long end = System.nanoTime();
        return new Statistics(comps, moves, end - start);
    }

    private static long rebuildHeap(int[] arr, int left, int right) {
        long comps = 0;
        int i = left;
        int largestChild = 2 * i + 1;
        int root = arr[i];
        boolean heap = false;

        while ((largestChild <= right) && (!heap)) {
            if (largestChild < right) {
                comps++;
                if (arr[largestChild] < arr[largestChild + 1]) {
                    largestChild++;
                }
            }
            comps++;
            if (root < arr[largestChild]) {
                arr[i] = arr[largestChild];
                i = largestChild;
                largestChild = 2 * i + 1;
            } else {
                heap = true;
            }
        }
        arr[i] = root;
        return comps;
    }
}
