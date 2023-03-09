import java.util.Scanner;

public class JogoDaVelhaV1 {
    public static void main(String[] args) {
        char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int jogadas = 0;
        char jogador = 'X';
        boolean vitoria = false;
        Scanner input = new Scanner(System.in);

        while (jogadas < 9 && !vitoria) {
            System.out.println("Jogador " + jogador + ", faça sua jogada (linha, coluna):");
            int linha = input.nextInt();
            int coluna = input.nextInt();

            if (tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogador;
                jogadas++;

                // Verifica se houve vitória
                if ((tabuleiro[linha][0] == jogador && tabuleiro[linha][1] == jogador && tabuleiro[linha][2] == jogador) ||
                        (tabuleiro[0][coluna] == jogador && tabuleiro[1][coluna] == jogador && tabuleiro[2][coluna] == jogador) ||
                        (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                        (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
                    vitoria = true;
                }

                // Alterna o jogador
                jogador = (jogador == 'X') ? 'O' : 'X';

                // Imprime o tabuleiro atualizado
                System.out.println("   0  1  2");
                System.out.println("0 " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
                System.out.println("  ---------");
                System.out.println("1 " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
                System.out.println("  ---------");
                System.out.println("2 " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
            } else {
                System.out.println("Posição já ocupada, tente novamente.");
            }
        }

        // Imprime o resultado
        if (vitoria) {
            System.out.println("Parabéns, jogador " + jogador + ", você ganhou!");
        } else {
            System.out.println("Empate!");
        }
    }
}
