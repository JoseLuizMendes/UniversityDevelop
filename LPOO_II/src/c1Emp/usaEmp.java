package c1Emp;

import java.util.*;

public class usaEmp {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Emprestimo> lista = new ArrayList<>(10);

		cadastrar(lista);
		exibir(lista);
	}

	private static void exibir(ArrayList<Emprestimo> lista) {
		for (Emprestimo e: lista) {
			if(e.getSaldoDevedor()==0) {
				System.out.println("QUITADO");
				System.out.println("Nome: " + e.getNome() + "CPF: " + e.getCpf());
			}
			else {
				System.out.println("PENDENTE");
				System.out.println("Nome: " + e.getNome() + "CPF: " + e.getCpf() + "PENDÊNCIA: " + e.getSaldoDevedor());
			}
		}
		
	}

	private static void cadastrar(ArrayList<Emprestimo> lista) {
		
		for (int i=0;i<10;i++) {
		System.out.println("INFORME O NOME: ");	
		String nome = sc.nextLine();
		System.out.println("INFORME O CPF: ");
		String cpf  = sc.nextLine();
		System.out.println("INFORME O VALOR DA PARCELA: ");
		double valorParcela = sc.nextDouble();
		System.out.println("INFORME A QUANTIDADE DE PARCELAS A PAGAR: ");
		int qntdParcelas = sc.nextInt();
		System.out.println("INFORME A QUANTIDADE DE PARCELAS PAGAS: ");
		int parcelasPagas = sc.nextInt();
		
		lista.add(new Emprestimo(nome, cpf, valorParcela, qntdParcelas, parcelasPagas));
		}
	}

}
