public class Papagaio extends Animal {
    public Papagaio(String nome, String raca) {
        super(nome, raca);
    }

    public void fala() {
        System.out.println("O papagaio está falando!");
    }

    @Override
    public void caminha() {
        System.out.println("O " + getNome() + " está voando!");
    }

}