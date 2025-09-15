package ex011;

import java.util.LinkedList;

public class PilhaInt {
	/*
	 * 1. Verificar se a pilha está vazia
	 * 2.Retornar o tamanho da pilha
	 * 3.Retorna o topo da pilha (top)
	 * 4.Push (Inserir um elemento na pilha)
	 * 5.Pop (Remover um elemento da pilha)
	 */
	private LinkedList<Integer> stack;
	
	public PilhaInt (){
		this.stack = new LinkedList<Integer>();
	}
	
	public boolean isEmpty() {
		if (this.stack.size()==0){
			return true;
		}
		return false;
	}
	
	public int size () {
		return this.stack.size();
	}
	
	public Integer top () {
		return this.stack.getFirst();
	}
	
	public void push (int num) {
		this.stack.addFirst(num);
	}
	
	public Integer pop () {
		return this.stack.removeFirst();
	}
}
