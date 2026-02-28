/**
 * This class creates the board.
 */

public class Board {
    // Constant for the default board size.
    private static final int DEFAULT_SIZE = 4;
    // Private members of the class.
    private int boardSize;
    private Mark[][] marks;

    /**
     * Default constructor that creates a board with the default size.
     */
    public Board() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor that creates a board with the given board size.
     * @param boardSize the board size.
     */
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.marks = new Mark[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                marks[row][col] =  Mark.BLANK;
            }
        }
    }

    /**
     * Method that return the board size.
     * @return the size of the board.
     */
    public int getSize() {
        return boardSize;
    }

    /**
     * Method that assigns the given mark to a given cell.
     * @param mark the mark to be placed on a cell(X or O).
     * @param row the row where the mark will be placed.
     * @param col the col where the mark will be placed.
     * @return true if the mark was placed successfully and false otherwise.
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (row >= boardSize || col >= boardSize  || row < 0 || col < 0) {
            return false;
        }
        if (mark == null || mark == Mark.BLANK || marks[row][col] != Mark.BLANK) {
            return false;
        }
        marks[row][col] = mark;
        return true;
    }

    /**
     * Method that return the mark for a given cell.
     * @param row the row where the mark is placed.
     * @param col the column where the mark is placed.
     * @return the mark in the given coordinates and null for illegal coordinates.
     */
    public Mark getMark(int row, int col) {
        if (row >= boardSize || col >= boardSize  || row < 0 || col < 0) {
            return Mark.BLANK;
        }
        return marks[row][col];
    }
}
