public class Circulo extends AbstractElemGeometrico {
    private int raio;

    public Circulo(int x, int y, int raio) {
        super(x, y);
        this.raio = raio;
    }
    

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    @Override
    public double calcularAreaCirculo(int raio) {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetroCirculo(int raio) {
        return 2 * Math.PI * raio;
    }

    @Override
    public String desenhar() {
        return "Desenhando um círculo na posição (" + getX() + ", " + getY() + ") com raio " + raio;
    }
    @Override
    public void redimensionar(double fator) {
        this.raio *= fator;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }
    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}
