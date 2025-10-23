package Cartas;

import Jogador.Jogador;

public abstract class Carta {
    protected String nome;
    protected int poder;
    protected static int cartasJogadas = 0;

    public Carta(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public static int getCartasJogadas() {
        return cartasJogadas;
    }

    public abstract void jogar(Jogador jogador, Jogador oponente);

    @Override
    public String toString() {
        return "Nome: " + nome + ", Poder: " + poder;
    }
}
