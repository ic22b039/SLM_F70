public class GameEndCheck {
    private Board board;

    public GameEndCheck(Board board) {
        this.board = board;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board.board[i][0], board.board[i][1], board.board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int j = 0; j < 3; j++) {
            if (checkRowCol(board.board[0][j], board.board[1][j], board.board[2][j])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (checkRowCol(board.board[0][0], board.board[1][1], board.board[2][2]) ||
                checkRowCol(board.board[0][2], board.board[1][1], board.board[2][0]));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }
}
