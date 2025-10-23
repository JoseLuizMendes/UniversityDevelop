package Classes;

public class AutomovelLuxo extends AutomovelBasico {
    private boolean direcaoHidraulica, cambioAutomatico, vidroETravaEletrica;
    public static final int NUMEROMAXIMOPRESTACOES = 36;

    public AutomovelLuxo(String modelo, String cor, int combustivel, boolean retrovisorDoPassageiro,
            boolean limpadorTraseiro, boolean radioAmFm, boolean direcaoHidraulica, boolean cambioAutomatico,
            boolean vidroETravaEletrica) {
        super(modelo, cor, combustivel, retrovisorDoPassageiro, limpadorTraseiro, radioAmFm);
        this.direcaoHidraulica = direcaoHidraulica;
        this.cambioAutomatico = cambioAutomatico;
        this.vidroETravaEletrica = vidroETravaEletrica;
    }

    public AutomovelLuxo() { 
        super();
        this.direcaoHidraulica = true;
        this.cambioAutomatico = true;
        this.vidroETravaEletrica = true;
    }

    public boolean isDirecaoHidraulica() {
        return direcaoHidraulica;
    }
    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }
    public boolean isVidroETravaEletrica() {
        return vidroETravaEletrica;
    }
    public void setDirecaoHidraulica(boolean direcaoHidraulica) {
        this.direcaoHidraulica = direcaoHidraulica;
    }
    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }
    public void setVidroETravaEletrica(boolean vidroETravaEletrica) {
        this.vidroETravaEletrica = vidroETravaEletrica;
    }
    @Override
    public int getnumeroPrestacoes() {
        return NUMEROMAXIMOPRESTACOES;
    }
    public double valor() {
        double valorBase = super.valor();
        if (direcaoHidraulica) {
            valorBase += 5000;
        }
        if (cambioAutomatico) {
            valorBase += 8000;
        }
        if (vidroETravaEletrica) {
            valorBase += 3500;
        }
        return valorBase;
    }
    @Override
    public String toString() {
        return "AutomovelLuxo: " +
                "Modelo: " + getModelo() +
                ", Cor: " + getCor() +
                ", Combustivel: " + tipoCombustivel() +
                ", Retrovisor do Passageiro: " + (isRetrovisorDoPassageiro() ? "Sim" : "Não") +
                ", Limpador Traseiro: " + (isLimpadorTraseiro() ? "Sim" : "Não") +
                ", Rádio AM/FM: " + (isRadioAmFm() ? "Sim" : "Não") +
                ", Direção Hidráulica: " + (direcaoHidraulica ? "Sim" : "Não") +
                ", Câmbio Automático: " + (cambioAutomatico ? "Sim" : "Não") +
                ", Vidro e Trava Elétrica: " + (vidroETravaEletrica ? "Sim" : "Não") +
                ", Valor: R$" + String.format("%.2f", valor());
    }
}
