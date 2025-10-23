import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Animal> animal = new ArrayList<>();
        cadastrarAnimais(animal);
        exibirAnimais(animal);
        // cachorros latirem
        dogComunica(animal);
        // gatos miem
        catComunica(animal);
        // todos os animais caminhem
        allWalk(animal);
    }

    private static void allWalk(ArrayList<Animal> animal) {
        for (Animal a : animal) {
            a.caminha();
        }
    }

    private static void catComunica(ArrayList<Animal> animal) {
        for (Animal a : animal) {
            if (a instanceof Gato) {
                ((Gato) a).mia();
            }
        }
    }

    private static void dogComunica(ArrayList<Animal> animal) {
        for (Animal a : animal) {
            if (a instanceof Cachorro) {
                ((Cachorro) a).late();
            }
        }
    }

    private static void exibirAnimais(ArrayList<Animal> animal) {
        for (Animal a : animal) {
            System.out.println(a);
        }
    }

    private static void cadastrarAnimais(ArrayList<Animal> animal) {
        animal.add(new Cachorro("Rex", "Labrador"));
        animal.add(new Gato("Miau", "Siamês"));
        animal.add(new Papagaio("Loro", "Verde"));
        animal.add(new Cachorro("Bob", "Vira-lata"));
        animal.add(new Gato("Felix", "Persa"));
    }
}
