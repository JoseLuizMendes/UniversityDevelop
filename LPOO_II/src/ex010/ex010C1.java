package ex010;
import java.util.*;
public class ex010C1 {
public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		FilaInt fila = new FilaInt();
		
		preencher(fila);
		imprimir(fila);
		retirarPar(fila);
		
		imprimir(fila);
		
	}
	private static void retirarPar(FilaInt fila) {
		int num, tam = fila.size(); 
		for(int i=0; i<fila.size(); i++) {
			num= fila.dequeue();
			if(num%2 == 1) {
				fila.enqueue(num);
			}
		}
	}
	private static void imprimir(FilaInt fila) {
		int num;
		System.out.println();
		for(int i=0; i<fila.size(); i++) {
			num = fila.dequeue();
			System.out.print(num + " ");
			fila.enqueue(num);
		}
		
	}
	private static void preencher(FilaInt fila) {
		System.out.println("Entre com o tamanho da fila: ");
		int tam = sc.nextInt();
		int num;
		for(int i=0; i<tam; i++) {
			num = (int)(Math.random()*100);
			fila.enqueue(num);
		}
	}

}
