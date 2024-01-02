public class GameState {
    private Board board;

    public GameState(Board board) {
        this.board = board;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board.board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
