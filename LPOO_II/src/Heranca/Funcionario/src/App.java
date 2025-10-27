import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Ana", 101));
        funcionarios.add(new Vendedor("Bruno", 102, 250.0));
        funcionarios.add(new Assistente("Carlos", 103));
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.calcularSalario());
        }
    }
}
