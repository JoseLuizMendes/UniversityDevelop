public class Assistente extends Funcionario {

    public Assistente(String nome, int matricula) {
        super(nome, matricula);
    }
    @Override
    public double calcularSalario() {
        return getSalBase();
    }

}
