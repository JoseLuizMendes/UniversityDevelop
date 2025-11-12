package trabalho;

public class Estatisticas {

		public long comparacoes;
		public long movimentacoes;
		public long tempoExecucao; // Em nanossegundos

		public Estatisticas(long comparacoes, long movimentacoes, long tempoExecucao) {
			this.comparacoes = comparacoes;
			this.movimentacoes = movimentacoes;
			this.tempoExecucao = tempoExecucao;
		}

		@Override
		public String toString() {
			double segundos = tempoExecucao;
			return "Comparações: " + comparacoes + " | Movimentações: " + movimentacoes + " | Tempo: " + segundos + "ns ";
		}
	}
