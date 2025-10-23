package Classes;

public class Automovel {
    private static final int NUMEROMAXIMOPRESTACOES = 24;
    public static final int GASOLINA = 1;
    public static final int FLEX = 2;
    public static final int DIESEL = 3;
    public static final int GAS = 4;
    private String modelo, cor;
    private int combustivel;

    public Automovel(String modelo, String cor, int combustivel) {
        this.modelo = modelo;
        this.cor = cor; 
        this.combustivel = combustivel;
    }

    public Automovel() {

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public int getnumeroPrestacoes() {
        return NUMEROMAXIMOPRESTACOES;
    }

    public String tipoCombustivel() {
        switch (combustivel) {
            case GASOLINA:
                return "Gasolina";
            case FLEX:
                return "Flex";
            case DIESEL:
                return "Diesel";
            case GAS:
                return "Gás";
            default:
                return "Desconhecido";
        }
    }

    public double valor() {
        switch (combustivel) {
            case GASOLINA:
                return 70000;
            case FLEX:
                return 95000;
            case DIESEL:
                return 90000;
            case GAS:
                return 80000;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + "-" + "Cor: " + cor + "-" + "Movido a: " + tipoCombustivel();
    }
}
