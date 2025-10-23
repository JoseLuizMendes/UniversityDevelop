package Classes;

public class Pessoa {
    private String nome, cpf;
    private Endereco endereco;

    public Pessoa(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    public Pessoa(){
        this.nome = "";
        this.cpf = "";
        this.endereco = new Endereco();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco+ " "  ;
    }
}
