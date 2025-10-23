package Cartas;

import Jogador.Jogador;

public class CartaAtaque extends Carta {

    public CartaAtaque(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogador, Jogador oponente) {
    
        System.out.println("-> " + jogador.getNome() + " joga (ATAQUE): '" + nome.trim() + "' | Poder: " + poder);

        oponente.atacar(poder);

        Carta.cartasJogadas++;


        System.out.println("   [Efeito] " + oponente.getNome() + " foi atacado com poder " + poder + ".");
    }
}