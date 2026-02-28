/**
 * The game class that represents a single full game.
 */
public class Game {
    // Constants
    private static final int DEFAULT_SIZE = 4;
    private static final int DEFAULT_WIN_STREAK = 3;
    private final int NUM_0 = 0;
    private final int NUM_1 = 1;

    // Members of the class
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final int winStreak;
    private final Renderer renderer;

    /**
     * Default constructor.
     * @param playerX represents the player with the X mark.
     * @param playerO represents the player with the O mark.
     * @param renderer the renderer.
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this(playerX, playerO, DEFAULT_SIZE, DEFAULT_WIN_STREAK, renderer);
    }

    /**
     * Game constructor.
     * @param playerX represents the player with the X mark.
     * @param playerO represents the player with the O mark.
     * @param size the size of the board.
     * @param winStreak the win streak.
     * @param renderer the renderer.
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.board = new Board(size);
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.winStreak = winStreak;
    }

    /**
     * Gets the win streak.
     * @return win streak.
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * Gets the board size.
     * @return size of the board.
     */
    public int getBoardSize() {
        return board.getSize();
    }

    /**
     * Runs a complete game until one player has won or there are no more
     * cells on the board.
     * @return the player that won or null if the board got full before
     * a player won.
     */
    public Mark run() {
        Mark currentMark = Mark.X;

        while (true) {
            if (currentMark == Mark.X) {
                playerX.playTurn(board, Mark.X);
            } else {
                playerO.playTurn(board, Mark.O);
            }
            renderer.renderBoard(board);
            if (hasWon(currentMark)) {
                return currentMark;
            }
            if (isBoardFull()) {
                return Mark.BLANK;
            }
            currentMark = (currentMark == Mark.X) ? Mark.O : Mark.X;
        }
    }

    /**
     * Checks if the board is full.
     * @return true if the board is full and false otherwise.
     */
    private boolean isBoardFull() {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the given mark currently has a winning streak of length winStreak
     * on the board in a row, column, or diagonal.
     * @param mark the mark.
     * @return true if there is a win streak and false otherwise.
     */
    private boolean hasWon(Mark mark) {
        int size = board.getSize();
        for (int row = NUM_0; row < size; row++) {
            for (int col = NUM_0; col < size; col++) {
                if (board.getMark(row, col) != mark) {
                    continue;
                }
                if (hasStreakFrom(row, col, NUM_0, NUM_1, mark)
                        || hasStreakFrom(row, col, NUM_1, NUM_0, mark)
                        || hasStreakFrom(row, col, NUM_1, NUM_1, mark)
                        || hasStreakFrom(row, col, NUM_1, -NUM_1, mark)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there is a streak of length winStreak for mark starting
     * at (row, col) and moving by (dRow, dCol) each step.
     * @param row the current row.
     * @param col the current column.
     * @param dRow the direction for the row.
     * @param dCol the direction for the col.
     * @param mark the mark.
     * @return true if there is a win streak and false otherwise.
     */
    private boolean hasStreakFrom(int row, int col,
                                  int dRow, int dCol,
                                  Mark mark) {
        int size = board.getSize();
        for (int k = 0; k < winStreak; k++) {
            int r = row + k * dRow;
            int c = col + k * dCol;
            if (r < 0 || r >= size || c < 0 || c >= size) {
                return false;
            }
            if (board.getMark(r, c) != mark) {
                return false;
            }
        }
        return true;
    }
}
