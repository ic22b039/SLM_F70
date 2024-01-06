import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GameStateTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Board board;
    private GameState gameState;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        board = new Board();
        gameState = new GameState(board);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPrintBoard() {
        gameState.printBoard();
        String expectedOutput = "-------------\n" +
                "|   |   |   | \n" +
                "-------------\n" +
                "|   |   |   | \n" +
                "-------------\n" +
                "|   |   |   | \n" +
                "-------------\n";
        String actualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

}
