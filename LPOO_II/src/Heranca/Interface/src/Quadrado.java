public class Quadrado extends Retangulo {

    public Quadrado(int x, int y, int lado) {
        super(x, y, lado, lado);
    }

    @Override
    public String desenhar() {
        return String.format("Desenhando um quadrado na posição (%d, %d) com lados %d e %d", getX(), getY(), getLado1(), getLado2());
    }
}
