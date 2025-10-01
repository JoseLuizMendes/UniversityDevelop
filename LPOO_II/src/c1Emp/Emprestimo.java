package c1Emp;

public class Emprestimo {
    private String nome;
    private String cpf;
    private double valorParcela;
    private int qntdParcela;
    private int parcelasPagas;

    // Construtor
    public Emprestimo(String nome, String cpf, double valorParcela, int qntdParcela, int parcelasPagas) {
        this.nome = nome;
        this.cpf = cpf;
        this.valorParcela = valorParcela;
        this.qntdParcela = qntdParcela;
        this.parcelasPagas = parcelasPagas;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public double getValorParcela() { return valorParcela; }
    public int getQntdParcela() { return qntdParcela; }
    public int getParcelasPagas() { return parcelasPagas; }

    public void pagarParcela() {
        if (parcelasPagas < qntdParcela) {
            parcelasPagas++;
        }
    }

    public double getSaldoDevedor() {
        return (qntdParcela - parcelasPagas) * valorParcela;
    }

    @Override
    public String toString() {
        return "Empréstimo de " + nome +
               "\nCPF: " + cpf +
               "\nValor parcela: " + valorParcela +
               "\nTotal parcelas: " + qntdParcela +
               "\nParcelas pagas: " + parcelasPagas +
               "\nSaldo devedor: " + getSaldoDevedor();
    }
}
