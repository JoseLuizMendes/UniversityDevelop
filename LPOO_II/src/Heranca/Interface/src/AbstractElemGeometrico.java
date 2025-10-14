public abstract class AbstractElemGeometrico implements CalcGeometrico {
    private int x;
    private int y;

    public AbstractElemGeometrico(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calcularAreaCirculo(int raio) {
        return Math.PI * Math.pow(raio, 2);
       
    }

    public double calcularPerimetroCirculo(int raio) {
        return 2 * Math.PI * raio;
    }
}