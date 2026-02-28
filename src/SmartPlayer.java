import java.util.Random;

/**
 * This class implements the smart player.
 */
public class SmartPlayer implements Player{
    // Constants
    private static final int NUM_0 = 0;
    private static final int NUM_2 = 2;
    private static final int NUM_8 = 8;
    private static final int NUM_10 = 10;
    /**
     * Default constructor for the smart player.
     */
    public SmartPlayer() {}

    /**
     * The smart player starts by placing a mark on the third column with
     * a chance of 80% to prevent the naive player from winning.
     * @param board the game board.
     * @param mark the type of mark.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        int randomNum = random.nextInt(NUM_10);
        int size = board.getSize();
        if (randomNum < NUM_8) {
            for (int row = NUM_0; row < size; row++) {
                if (board.getMark(row, NUM_2) == Mark.BLANK) {
                    board.putMark(mark, row, NUM_2);
                    return;
                }
            }
        }
        while (true) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (board.getMark(row, col) == Mark.BLANK) {
                board.putMark(mark, row, col);
                return;
            }
        }
    }
}
