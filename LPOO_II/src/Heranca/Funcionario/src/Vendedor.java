public class Vendedor extends Funcionario {
    private  double comissao= 200.0;

    public Vendedor(String nome, int matricula, double comissao) {
        super(nome, matricula);

    }
    @Override
    public double calcularSalario() {
        return getSalBase() + comissao;
    }
}
