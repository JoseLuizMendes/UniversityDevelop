package collections;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ex002C1 {
    /*
     * Faça um programa que leia uma lista de inteiros e, a partir
     * dela, construa uma outra lista que contém os mesmos
     * elementos da primeira porém em ordem invertida. Em
     * seguida, as duas listas serão mostradas na tela.
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        fill(list1);

        list2 = invert(list1);
        System.err.println("Lista 1: " + list1);
        System.err.println("Lista 2: " + list2);
    }

    public static void fill(ArrayList<Integer> list) {
        int sizeList = 0, num;
        try {
            System.err.println("Enter the size list: ");
            sizeList = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        Random rand = new Random();

        for (int i = 0; i < sizeList; i++) {
            num = rand.nextInt(100);
            list.add(num);
        }
    }

    public static ArrayList<Integer> invert(ArrayList<Integer> list) {
        ArrayList<Integer> aux = new ArrayList<>();
        for (int num : list) {
            aux.addFirst(num);
        }
        return aux;
    }
}
