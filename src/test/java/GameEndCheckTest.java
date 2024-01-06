import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEndCheckTest {

    private Board board;
    private GameEndCheck gameEndCheck;

    @BeforeEach
    void setUp() {
        board = new Board();
        gameEndCheck = new GameEndCheck(board);
    }

    @Test
    void testIsBoardFull_Full() {
        fillBoard('X');
        assertTrue(gameEndCheck.isBoardFull(), "Board should be full");
    }

    @Test
    void testIsBoardFull_NotFull() {
        board.board[0][0] = 'X';
        assertFalse(gameEndCheck.isBoardFull(), "Board should not be full");
    }

    @Test
    void testCheckForWin_NoWin() {
        board.board[0][0] = 'X';
        board.board[1][1] = 'O';
        assertFalse(gameEndCheck.checkForWin(), "Should not be a win");
    }

    // Hilfsmethode zum Füllen des Boards
    private void fillBoard(char symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.board[i][j] = symbol;
            }
        }
    }
}
