package Classes;

public class AutomovelBasico extends Automovel {
    private boolean retrovisorDoPassageiro, limpadorTraseiro, radioAmFm;

    public AutomovelBasico(String modelo, String cor, int combustivel, boolean retrovisorDoPassageiro,
            boolean limpadorTraseiro, boolean radioAmFm) {
        super(modelo, cor, combustivel);
        this.retrovisorDoPassageiro = retrovisorDoPassageiro;
        this.limpadorTraseiro = limpadorTraseiro;
        this.radioAmFm = radioAmFm;
 
    }

    public AutomovelBasico() {
        super();
        this.retrovisorDoPassageiro = true;
        this.limpadorTraseiro = true;
        this.radioAmFm = true;
    }

    public boolean isRetrovisorDoPassageiro() {
        return retrovisorDoPassageiro;
    }

    public boolean isLimpadorTraseiro() {
        return limpadorTraseiro;
    }

    public boolean isRadioAmFm() {
        return radioAmFm;
    }

    public void setRetrovisorDoPassageiro(boolean retrovisorDoPassageiro) {
        this.retrovisorDoPassageiro = retrovisorDoPassageiro;
    }

    public void setLimpadorTraseiro(boolean limpadorTraseiro) {
        this.limpadorTraseiro = limpadorTraseiro;
    }

    public void setRadioAmFm(boolean radioAmFm) {
        this.radioAmFm = radioAmFm;
    }

    @Override
    public double valor(){
        double valorBase = super.valor();
        if (retrovisorDoPassageiro) {
            valorBase += 1250;
        }
        if (limpadorTraseiro) {
            valorBase += 2500;
        }
        if (radioAmFm) {
            valorBase += 7500;
        }
        return valorBase;
    }

    @Override
    public String toString() {
        return "AutomovelBasico: " +
                "Modelo: " + getModelo() +
                ", Cor: " + getCor() +
                ", Combustivel: " + tipoCombustivel() +
                ", Retrovisor do Passageiro: " + (retrovisorDoPassageiro ? "Sim" : "Não") +
                ", Limpador Traseiro: " + (limpadorTraseiro ? "Sim" : "Não") +
                ", Rádio AM/FM: " + (radioAmFm ? "Sim" : "Não") +
                ", Valor: R$" + String.format("%.2f", valor());
    }
}
