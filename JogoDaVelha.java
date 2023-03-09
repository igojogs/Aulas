import java.util.Scanner;

public class JogoDaVelha {
    private static final char VAZIO = ' ';
    private static final char JOGADOR_X = 'X';
    private static final char JOGADOR_O = 'O';
    private static final int TAMANHO_TABULEIRO = 3;

    private char[][] tabuleiro;
    private char jogadorAtual;
    private int jogadas;

    public JogoDaVelha() {
        tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        jogadorAtual = JOGADOR_X;
        jogadas = 0;
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    private void imprimirTabuleiro() {
        System.out.println("   0  1  2");
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print("|" + tabuleiro[i][j]);
            }
            System.out.println("|");
            System.out.println("  ---------");
        }
    }

    private void proximoJogador() {
        jogadorAtual = (jogadorAtual == JOGADOR_X) ? JOGADOR_O : JOGADOR_X;
    }

    private boolean jogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= TAMANHO_TABULEIRO || coluna < 0 || coluna >= TAMANHO_TABULEIRO) {
            System.out.println("Coordenadas inválidas. Tente novamente.");
            return false;
        }
        if (tabuleiro[linha][coluna] != VAZIO) {
            System.out.println("Posição já ocupada. Tente novamente.");
            return false;
        }
        return true;
    }

    private boolean houveVitoria() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }
        return false;
    }

    private boolean empate() {
        return jogadas == TAMANHO_TABULEIRO * TAMANHO_TABULEIRO;
    }
    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (!houveVitoria() && !empate()) {
            System.out.println("Jogador " + jogadorAtual + ", é a sua vez:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();
            if (jogadaValida(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;
                imprimirTabuleiro();
                if (houveVitoria()) {
                    System.out.println("Parabéns, jogador " + jogadorAtual + "! Você ganhou!");
                } else if (empate()) {
                    System.out.println("Empate!");
                } else {
                    proximoJogador();
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        JogoDaVelha jogoDaVelha = new JogoDaVelha();
        jogoDaVelha.jogar();
    }
}
