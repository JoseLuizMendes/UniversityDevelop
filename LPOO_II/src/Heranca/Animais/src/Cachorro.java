public class Cachorro extends Animal {
    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }
    public void late() {
        System.out.println("Au Au!");
    }
    public void caminha() {
        System.out.println("O " + getNome() + " está correndo!");
    }
}