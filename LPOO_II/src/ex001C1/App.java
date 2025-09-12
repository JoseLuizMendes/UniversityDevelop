package ex001C1;
import java.util.*;
public class App {
public static Scanner sc = new Scanner (System.in);
static int size;
	public static void main(String[] args) {
		/*Faça um programa que preencha uma ArrayList com
		números inteiros (ele deve parar de armazenar quando
		digitar zero), mostre a lista original na tela, retire todos os
		números pares da lista e imprima a lista final na tela*/
		
		menu();
		ArrayList<Integer> list = fill(size);
		show("Lista Original: ", list);
		ArrayList<Integer> oddNumbers = removeEvenNumbers(list);
		show("Lista após remover os pares: ", oddNumbers);
	}


	private static void menu() {
		System.out.println("Enter the size of the array: ");
		try {
			size = sc.nextInt();
			fill(size);
		}
		catch(Exception e){
			System.out.println("Erro: " + e);
		}
		
	}

	private static ArrayList<Integer> fill(int size) {
		ArrayList <Integer> list = new ArrayList(size);
		Random rand = new Random();
		
		for(int i=0; i<size; i++) {
			int randNum = rand.nextInt(100);
			list.add(randNum);	
		}
		return list;
		
	}
	private static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> list) {
		ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : list) {
            if (number % 2 != 0) { 
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
	}

	private static void show(String message, ArrayList<Integer> list) {
		System.out.println("\n" + message);
        if (list.isEmpty()) {
            System.out.println("Lista vazia");
        } else {
            System.out.println(list);
        }
        System.out.println();		
	}

}
