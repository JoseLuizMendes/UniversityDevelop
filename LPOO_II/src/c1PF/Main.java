package c1PF;
import java.util.*;
public class Main {
public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PilhaInt pilha = new PilhaInt();
		FilaInt fila = new FilaInt();
		
		preencher(fila, pilha);
		exibir(fila, pilha);
	}


	private static void exibir(FilaInt fila, PilhaInt pilha) {
		//fila
		int numF;
		
		for(int i=0;i<fila.size();i++) {
			numF = fila.dequeue();
			System.out.print(numF + " ");
			fila.enqueue(numF);
		}
		
		//pilha
		PilhaInt aux = new PilhaInt();
		int numP,tam = pilha.size();

		System.out.println("\n");
		for(int i=0;i<tam;i++) {
			numP = pilha.pop();			
			System.out.print(numP+" ");
			aux.push(numP);
		}
		for(int i=0;i<tam;i++) {
			numP = aux.pop();
			pilha.push(numP);
		}
		
		
	}


	private static void preencher(FilaInt fila, PilhaInt pilha) {
		int num, numX, tam;
		
		System.out.println("Informe o tamanho da fila: ");
		tam= sc.nextInt();
		System.out.println("Informe um número inteiro: ");
		numX = sc.nextInt();
		for(int i=0; i<tam; i++) {
			num = (int)(Math.random()*100);
			if(num>numX) {
				pilha.push(num);
			}
			fila.enqueue(num);
		}
	}

}
