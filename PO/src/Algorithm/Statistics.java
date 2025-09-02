package Algorithm;

public class Statistics{
    public long comparacoes;
    public long movimentacoes;
    public long tempoExecucao; // em nanossegundos

    public Statistics(long comparacoes, long movimentacoes, long tempoExecucao) {
        this.comparacoes = comparacoes;
        this.movimentacoes = movimentacoes;
        this.tempoExecucao = tempoExecucao;
    }

    @Override
    public String toString() {
        return "Comparações: " + comparacoes + 
               " | Movimentações: " + movimentacoes + 
               " | Tempo: " + tempoExecucao + " ns";
    }
}
