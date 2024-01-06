import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testConstructor() {
        assertNotNull(board, "Board should not be null");
        assertNotNull(board.board, "Board array should not be null");
        assertEquals(3, board.board.length, "Board should be 3x3");
        assertEquals(3, board.board[0].length, "Board rows should be of length 3");
    }

    @Test
    void testInitializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.board[i][j], "Board should be initialized with spaces");
            }
        }
    }
}
