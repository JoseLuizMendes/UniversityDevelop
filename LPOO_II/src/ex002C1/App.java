package ex002C1;

import java.util.LinkedList;
import java.util.Scanner;

public class App {
    /*
     * Faça um programa que preencha uma LinkedList com
     * números inteiros (ele deve parar de armazenar quando
     * digitar zero), mostre a lista original na tela, peça ao usuário
     * um número e mostre na tela a quantidade de vezes esse
     * número aparece na lista.
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        menu.showMenu();
        addNumber(list);
        showList(list);
        menu.showSecondMenu();
        int number = sc.nextInt();
        countNumber(list, number);
    }
    private static void addNumber(LinkedList<Integer> list) {
        int number;
        do {
            System.out.println("Número: ");
            number = sc.nextInt();
            list.add(number);
        } while (number != 0);

    }

    private static void showList(LinkedList<Integer> list) {
        System.out.println("Lista: " + list);
    }

    private static void countNumber(LinkedList<Integer> list, int number) {
        int count = 0;
        for (Integer numberList : list) {
            if (numberList == number) {
                count++;
            }
        }
        System.out.println("O numero " + number + " aparece " + count + " vezes na lista");
    }

}

