import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        PlayerMove playerMove = new PlayerMove(board);
        GameState gameState = new GameState(board);
        GameEndCheck gameEndCheck = new GameEndCheck(board);

        do {
            board.initializeBoard();
            boolean gameEnded = false;

            while (!gameEnded) {
                gameState.printBoard();
                int row, col;
                do {
                    System.out.println("Player " + playerMove.getCurrentPlayerMark() + ", enter a row (1-3) and a column (1-3): ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                } while (!playerMove.placeMark(row, col));

                gameEnded = gameEndCheck.checkForWin() || gameEndCheck.isBoardFull();

                if (!gameEnded) {
                    playerMove.changePlayer();
                }
            }

            gameState.printBoard();

            if (gameEndCheck.checkForWin()) {
                System.out.println("Player " + playerMove.getCurrentPlayerMark() + " wins!");
            } else {
                System.out.println("The game is a draw!");
            }

            System.out.println("Play again? (yes/no): ");
            scanner.nextLine(); // Consume the newline
        } while (scanner.nextLine().trim().equalsIgnoreCase("yes"));

        scanner.close();
    }
}
