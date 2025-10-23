package Cartas;

import Jogador.Jogador;

public class CartaDefesa extends Carta {

	public CartaDefesa(String nome, int poder) {
		super(nome, poder);
	}

	@Override
	public void jogar(Jogador jogador, Jogador oponente) {
		System.out.println("-> " + jogador.getNome() + " joga (DEFESA): '" + nome.trim() + "' | Poder: " + poder);

		jogador.defender(poder);

		Carta.cartasJogadas++;

		System.out.println("   [Efeito] " + jogador.getNome() + " aumentou defesa em " + this.poder + ".");
	}
}