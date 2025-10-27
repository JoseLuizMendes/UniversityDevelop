public class Gerente extends Funcionario {
 

    public Gerente(String nome, int matricula) {
        super(nome, matricula);
    }    

    @Override
    public double calcularSalario() {
        return getSalBase() * 2;
    }

}
