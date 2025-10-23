import Cartas.Carta;
import Cartas.CartaAtaque;
import Cartas.CartaDefesa;
import Jogador.Jogador;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

    private static List<Carta> baralho;
    private static List<Jogador> jogadores;
    private static final Random random = new Random();

    public static void main(String[] args) {

        inicializarJogo();
        lacoPrincipalDoJogo();
        exibirResultadoFinal();
    }

    private static void inicializarJogo() {

        jogadores = new ArrayList<>();
        // usar construtor simples que inicializa vida=2 e defesa=50
        jogadores.add(new Jogador("Bolsonaro"));
        jogadores.add(new Jogador("Lula"));

        baralho = new ArrayList<>();

        baralho.add(new CartaAtaque(" Golpe Lava-Jato  ", 10));
        baralho.add(new CartaAtaque(" Investida STF ", 20));
        baralho.add(new CartaAtaque(" Taxação Suprema ", 30));
        baralho.add(new CartaAtaque(" Impeachment ", 40));

        baralho.add(new CartaDefesa(" Escudo MST ", 10));
        baralho.add(new CartaDefesa(" Barreira INSS ", 15));
        baralho.add(new CartaDefesa(" Careca do Xandão ", 20));
    }

    private static void lacoPrincipalDoJogo() {

        while (contarJogadoresVivos() > 1 && Cartas.Carta.getCartasJogadas() <= 30) {
            System.out.println("\n=== RODADA " + (Cartas.Carta.getCartasJogadas() / 2 + 1) + " ===");

            Jogador player1 = jogadores.get(0);
            Jogador player2 = jogadores.get(1);

            if (player1.estaVivo()) {
                Carta carta = distribuirCarta();
                carta.jogar(player1, player2);
                // se o jogo terminou por morte do inimigo ou atingiu 30 cartas, não mostrar
                // parcial
                if (contarJogadoresVivos() <= 1 || Cartas.Carta.getCartasJogadas() > 30) {
                    break;
                }
                exibirResultadoParcial(player1.getNome(), player2.getNome());
            }

            if (player2.estaVivo() && Cartas.Carta.getCartasJogadas() <= 30) {
                Carta carta = distribuirCarta();
                carta.jogar(player2, player1);
                if (contarJogadoresVivos() <= 1 || Cartas.Carta.getCartasJogadas() > 30) {
                    break;
                }
                exibirResultadoParcial(player2.getNome(), player1.getNome());
            }
        }
    }

    private static Carta distribuirCarta() {
        int indiceAleatorio = random.nextInt(baralho.size());
        return baralho.get(indiceAleatorio);
    }

    private static void exibirResultadoParcial(String nomeJogador, String nomeInimigo) {
        System.out.println("Última jogada: " + nomeJogador + " vs " + nomeInimigo);
        System.out.println("--- STATUS PARCIAL ---");
        for (Jogador player : jogadores) {
            if (player.estaVivo()) {
                System.out.printf("%s | Vida: %d | Defesa: %d%n", player.getNome(), player.getVida(),
                        player.getDefesa());
            } else {
                System.out.printf("%s | MORTO%n", player.getNome());
            }
        }
        System.out.println("-------------------------");
    }

    private static int contarJogadoresVivos() {
        int vivos = 0;
        for (Jogador player : jogadores) {
            if (player.estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }

    private static void exibirResultadoFinal() {
        System.out.println("\n===== FIM DO JOGO =====");

        System.out.println("STATUS DOS JOGADORES");
        for (Jogador player : jogadores) {
            if (player.estaVivo()) {
                System.out.println("Está vivo: " + player.getNome() + " | Vida: " + player.getVida() + " | Defesa: "
                        + player.getDefesa());
            } else {
                System.out.println("MORTO: " + player.getNome());
            }
        }

        System.out.println("Cartas jogadas: " + Cartas.Carta.getCartasJogadas());

        Jogador vencedor = determinarVencedor();
        System.out.println("VENCEDOR: " + vencedor.getNome());
    }

    private static Jogador determinarVencedor() {

        if (contarJogadoresVivos() == 1) {
            for (Jogador player : jogadores) {
                if (player.estaVivo()) {
                    return player;
                }
            }
        }

        Jogador player1 = jogadores.get(0);
        Jogador player2 = jogadores.get(1);

        if (player1.getVida() > player2.getVida()) {
            return player1;
        } else if (player2.getVida() > player1.getVida()) {
            return player2;
        } else {

            return player1.getDefesa() >= player2.getDefesa() ? player1 : player2;
        }
    }
}