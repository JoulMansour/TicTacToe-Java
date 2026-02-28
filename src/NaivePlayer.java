/**
 * This class implements the naive player.
 */
public class NaivePlayer implements Player {
    /**
     * Default constructor for the naive player.
     */
    public NaivePlayer() {}

    /**
     * The Naive player picks the first empty cell while searching every
     * column in each row and marks it.
     * @param board the game board.
     * @param mark the type of mark.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    board.putMark(mark, row, col);
                    return;
                }
            }
        }
    }
}
