package Classes;

public class Aluno extends Pessoa {
    private String matricula, curso;

    public Aluno(String nome, String cpf, Endereco endereco, String matricula, String curso) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
        this.curso = curso;
    }
    public Aluno(){
        super();
        this.matricula = "";
        this.curso = "";
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", matricula=" + matricula + ", curso=" + curso ;
    }
}
