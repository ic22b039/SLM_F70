public class PlayerMove {
    private Board board;
    private char currentPlayerMark;

    public PlayerMove(Board board) {
        this.board = board;
        this.currentPlayerMark = 'X';
    }

    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (this.board.board[row][col] == ' ') {
                    this.board.board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }

    public void changePlayer() {
        currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }
}
