/**
 * This class implements the human player.
 */
public class HumanPlayer implements Player {
    // Constants for the requests.
    private static final String INPUT_REQUEST = "Player %s, type coordinates: ";
    private static final String ILLEGAL_OUT_OF_BOUNDS_REQUEST = "Invalid mark position." +
            " Please choose a valid position: ";
    private static final String ILLEGAL_OCCUPIED_CELL_REQUEST = "Mark position is already" +
            " occupied. Please choose a valid position: ";
    // Constant for the number 10.
    private static final int NUM_10 = 10;

    /**
     * Default human player constructor.
     */
    public HumanPlayer() {}

    /**
     * Method for a human player that plays a turn in the game.
     * @param board the game board.
     * @param mark the type of mark.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        System.out.printf(INPUT_REQUEST, mark);
        while(true) {
            int playerInput = KeyboardInput.readInt();
            int rowInput = playerInput/NUM_10;
            int colInput = playerInput%NUM_10;
            if (rowInput >= board.getSize() || colInput >= board.getSize()) {
                System.out.println(ILLEGAL_OUT_OF_BOUNDS_REQUEST);
                continue;
            }
            if (board.getMark(rowInput, colInput) != Mark.BLANK) {
                System.out.println(ILLEGAL_OCCUPIED_CELL_REQUEST);
                continue;
            }
            board.putMark(mark, rowInput, colInput);
            break;
        }
    }
}
