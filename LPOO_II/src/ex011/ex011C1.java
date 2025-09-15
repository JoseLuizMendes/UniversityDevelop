package ex011;

import java.util.*;

public class ex011C1 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PilhaInt pilha = new PilhaInt();
		int total;
		
		preencher(pilha);
		imprimir(pilha);
		total = somar(pilha);
		imprimir(pilha);
		System.out.println();
		System.out.println("SOMA = "+total);

	}

	private static void preencher(PilhaInt pilha) {
		int tam, num;
		System.out.println("Entre com o tamanho da pilha: ");
		tam = sc.nextInt();

		for (int i = 0; i < tam; i++) {
			num = (int) (Math.random() * 100);
			pilha.push(num);

		}

	}

	private static void imprimir(PilhaInt pilha) {
		int num, tam = pilha.size();
		PilhaInt aux = new PilhaInt();
		for (int i = 0; i < tam; i++) {
			num = pilha.pop();
			System.out.print(num +" ");
			aux.push(num);
		}
		for (int i = 0; i < tam; i++) {
			num = aux.pop();
			pilha.push(num);
		}

	}
	
	private static int somar(PilhaInt pilha) {
		int num, tam = pilha.size(), total=0;
		PilhaInt aux = new PilhaInt();
		
		for (int i=0; i<tam; i++) {
			num = pilha.pop();
			total += num;
			aux.push(num);
		}	
		for (int i=0; i<tam; i++) {
			num = aux.pop();
			pilha.push(num);
		}
		return total;
	}

}