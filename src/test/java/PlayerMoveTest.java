import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerMoveTest {

    private Board board;
    private PlayerMove playerMove;

    @BeforeEach
    void setUp() {
        board = new Board();
        playerMove = new PlayerMove(board);
    }

    @Test
    void testPlaceMarkValid() {
        assertTrue(playerMove.placeMark(0, 0), "Placing mark should succeed on an empty spot");
        assertEquals('X', board.board[0][0], "Spot should have the mark X");
    }

    @Test
    void testPlaceMarkInvalid() {
        // First place a mark
        playerMove.placeMark(0, 0);
        // Try to place another mark at the same spot
        assertFalse(playerMove.placeMark(0, 0), "Placing mark should fail on a taken spot");
    }

    @Test
    void testChangePlayer() {
        playerMove.changePlayer();
        assertEquals('O', playerMove.getCurrentPlayerMark(), "Current player should be O after change");
        playerMove.changePlayer();
        assertEquals('X', playerMove.getCurrentPlayerMark(), "Current player should be X after change");
    }

    @Test
    void testGetCurrentPlayerMark() {
        assertEquals('X', playerMove.getCurrentPlayerMark(), "Initial current player should be X");
        playerMove.changePlayer();
        assertEquals('O', playerMove.getCurrentPlayerMark(), "Current player should be O after change");
    }
}
