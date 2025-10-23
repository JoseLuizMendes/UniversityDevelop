package Jogador;

//define o contrato para qualquer entidade que possa
//participar do jogo
public interface IJogavel {
    public void atacar(int poder);
	public void defender(int poder);		
	public boolean estaVivo();
}
