public class Retangulo extends AbstractElemGeometrico {
    private int lado1;
    private int lado2;

    public Retangulo(int x, int y, int lado1, int lado2) {
        super(x, y);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    
    @Override
    public String desenhar() {
        return String.format("Desenhando um retângulo na posição (%d, %d) com lados %d e %d", getX(), getY(), lado1, lado2);
    }
    @Override
    public double area() {
        return lado1 * lado2;
    }
    @Override
    public double perimetro() {
        return 2 * (lado1 + lado2);
    }
    @Override
    public void redimensionar(double fator) {
        lado1 = (int) (lado1 * fator);
        lado2 = (int) (lado2 * fator);
    }
}
