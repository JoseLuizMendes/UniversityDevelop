package Classes;

public class Endereco {
    private String logradouro, complemento, cidade, estado;
    private int numero,cep;
    public Endereco(String logradouro, String complemento, String cidade, String estado, int numero, int cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.cep = cep;
       
    }
    public Endereco(){
        this.logradouro = "";
        this.complemento = "";
        this.cidade = "";
        this.estado = "";
        this.numero = 0;
        this.cep = 0;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public int getNumero() {
        return numero;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public int getCep() {
        return cep;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    @Override
    public String toString() {
        return "logradouro=" + logradouro + ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + ", numero="
                + numero + ", cep=" + cep + "";
    }
}
