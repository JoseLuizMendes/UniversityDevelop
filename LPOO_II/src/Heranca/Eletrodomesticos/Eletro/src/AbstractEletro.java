public abstract class AbstractEletro {
    private Boolean ligado;
    private Integer voltagem;

    public AbstractEletro(Integer voltagem) {
        this.ligado = false;
        this.voltagem = voltagem;
    }

    public Boolean isLigado() {
        return ligado;
    }

    public void SetisLigado(Boolean ligado){
        this.ligado = ligado;
    }

    public Integer getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(Integer voltagem) {
        this.voltagem = voltagem;
    }

    public abstract void ligar();
    public abstract void desligar();
}
