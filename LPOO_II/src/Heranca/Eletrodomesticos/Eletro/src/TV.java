public class TV extends AbstractEletro {
    private Integer canal, volume, tamanho;

    public TV(Integer voltagem, Integer tamanho) {
        super(voltagem);
        this.canal = 1;
        this.volume = 25;
        this.tamanho = tamanho;
    }

    public Integer getCanal() {
        return canal;
    }

    public void setCanal(Integer canal) {
        this.canal = canal;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    @Override
    public void ligar() {
        if (!isLigado()) {
            System.err.println("A TV já está Ligada!");
        } else {
            SetisLigado(isLigado() == true);
            System.err.println("A TV foi ligada!");
            this.canal = 1;
            this.volume = 10;
        }
    }

    public void desligar() {
        if (isLigado()) {
            System.err.println("A TV já está desligada!");
        } else {
            SetisLigado(isLigado());
            System.out.println("A TV foi desligada!");
            this.canal = 0;
            this.volume = 0;
        }
    }
}
