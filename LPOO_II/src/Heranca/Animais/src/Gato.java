public class Gato extends Animal {
    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    public void mia() {
        System.out.println("Miau Miau!");
    }

    @Override
    public void caminha() {
        System.out.println("O " + getNome() + " está saltando!");
    }

}