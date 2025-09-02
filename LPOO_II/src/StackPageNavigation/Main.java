package StackPageNavigation;

import java.util.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		StackPage historico = new StackPage();

		int op;
		do {
			System.out.println("===== MENU =====");
			System.out.println("1 – Acessar nova página");
			System.out.println("2 – Voltar para página anterior");
			System.out.println("3 – Ver página atual");
			System.out.println("4 – Exibir histórico de navegação");
			System.out.println("5 – Sair");
			System.out.print("Escolha uma opção: ");

			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Informe o título da página: ");
				String titulo = sc.nextLine();
				System.out.println("Informe a URL da página: ");
				String url = sc.nextLine();

				historico.push(new Page(titulo, url));
				System.out.println("\nPágina acessada com sucesso!\n");
				break;
			case 2:
				Page removida = historico.pop();
				if (removida == null) {
					System.out.println("\nNão há páginas para voltar.");
				} else {
					System.out.println("\nVoltando da pagina " + removida);
				}
				break;
			case 3:
				Page atual = historico.peek();
				if (atual == null) {
					System.out.println("\nNenhuma página acessada no momento.\n");
				} else {
					System.out.println("\nPágina Atual: " + atual);
				}
				break;
			case 4:
				historico.showViewHistory();
				break;

			case 5:
				System.out.println("\nEncerrando Programa...");
				break;
			default:
				System.err.print("\nOpção Invalida!\nTente Novamente!\n\n");
			}
		} while (op != 5);

	}
}
