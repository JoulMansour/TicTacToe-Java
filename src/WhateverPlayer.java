import java.util.Random;

/**
 * This class implements the whatever player for the game.
 */
public class WhateverPlayer implements Player{
    /**
     * Default whatever player constructor.
     */
    public WhateverPlayer() {}

    /**
     * The whatever player randomly picks a cell and puts the
     * mark if the cell is legal.
     * @param board the game board.
     * @param mark the type of mark.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        while(true) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            if (board.getMark(row, col) == Mark.BLANK) {
                board.putMark(mark, row, col);
                break;
            }
        }
    }
}
