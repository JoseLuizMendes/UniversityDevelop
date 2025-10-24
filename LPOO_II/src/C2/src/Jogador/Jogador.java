package Jogador;

public class Jogador implements IJogavel {
    protected String nome;
    protected int vida;
    protected int defesa;

    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 2;
        this.defesa = 50;
    }

    public Jogador(String nome, int vida, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getDefesa() {
        return defesa;
    }

    @Override
    public void atacar(int poder) {
        defesa -= poder;
        if (defesa < 0) {
            vida -= 1;
            defesa += 100;
        }
    }

    @Override
    public void defender(int poder) {
        defesa += poder;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }
}
