public abstract class Funcionario {
    private String nome;
    private int matricula;
    private static double salBase = 1000.0;
    
    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public static double getSalBase() {
        return salBase;
    }

    public static void setSalBase(double salBase) {
        Funcionario.salBase = salBase;
    }

    public abstract double calcularSalario();

    @Override
    public String toString(){
		return (this.getNome()+" - "+this.getMatricula());
	}
}