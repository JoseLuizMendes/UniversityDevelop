package collections;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class ex001C1 {
    /*
     * Faça um programa que leia duas listas de inteiros e
     * preencha uma outra lista com todos os elementos das duas
     * listas originais, sem repetição e ordenados. Ao final, mostre
     * as três listas na tela. Por exemplo: [3,6,5,3,7] [2,9,7,5,1] ==>
     * [1,2,3,5,6,7,9]
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3;
        TreeSet<Integer> aux;

        fill(list1);
        fill(list2);

        // remove equal numbers from frist list1 and sort them
        aux = new TreeSet<Integer>(list1);

        // concat all numbers from list1 into list2
        aux.addAll(list2);

        list3 = new ArrayList<>(aux);

        showList(list1, list2, list3);
    }

    public static void fill(ArrayList<Integer> list) {
        int sizeList = 0, num;
        try {
            System.out.println("Informe o tamanho das listas: ");
            sizeList = sc.nextInt();

        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
        Random rand = new Random();

        for (int i = 0; i < sizeList; i++) {
            num = rand.nextInt(100);
            list.add(num);
        }
    }

    private static void showList(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        System.err.println("Lista 1: " + list1);
        System.err.println("Lista 2: " + list2);
        System.err.println("Lista 3: " + list3);
    }
}
