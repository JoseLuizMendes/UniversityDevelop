package StackPageNavigation;

import java.util.LinkedList;

public class StackPage {
	private LinkedList<Page> stack;

	public StackPage() {
		stack = new LinkedList<>();
	}

	public void push(Page p) {
		stack.addFirst(p);
	}

	public Page pop() {
		if (isEmpty()) {
			return null;
		}
		return stack.removeFirst();
	}

	public Page peek() {
		if (isEmpty()) {
			return null;
		}
		return stack.getFirst();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void showViewHistory() {
		if (isEmpty()) {
			System.out.println("\nHistórico vazio.");
		} else {
			System.out.println("\nHistórico de Navegação: \n");

			for (Page p : stack) {
				System.out.println(p);
			}
		}
	}
}
