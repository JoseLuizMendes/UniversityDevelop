package c1PF;

import java.util.LinkedList;
/*
 * isEmpty -> pilha vazia
 * size -> tamanho 
 * peek -> retorna o primeiro;
 * enqueue -> adicionar no final (enfileirar)
 * dequeue -> retirar do inicio (desenfileirar)
 */


public class FilaInt {
	private LinkedList<Integer> queue;

	public FilaInt() {
		this.queue = new LinkedList<>();
	}
	
	public boolean isEmpty () {
		return (this.queue.isEmpty());
	}
	
	public int size() {
		return this.queue.size();
	}
	
	public Integer peek () {
		return this.queue.getFirst();
	}
	
	public void enqueue (int num) {
		this.queue.addLast(num);
	}
	
	public Integer dequeue () {
		return this.queue.removeFirst();
	}
}
