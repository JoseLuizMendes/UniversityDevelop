public class Animal {
    private String nome;
    private String raca;

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void caminha(){
        System.out.println(nome + " esta caminhando.");
    }

    public void comunica(){
        System.out.println("O animal da raça " + raca + " está se comunicando.");
    }

    @Override
    public String toString() {
        return "Animal: " + nome + ", Raca: " + raca;
    }
}