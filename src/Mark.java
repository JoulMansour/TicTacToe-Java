/**
 * Enum for the possible options for a cell in the board
 */
enum Mark{
    BLANK, X, O;

    /**
     * Converts the cell mark to a string and to null if it is blank.
     * @return
     */
    public String toString() {
        switch (this) {
            case BLANK:
                return null;
            case X:
                return "X";
            case O:
                return "O";
            default:
                return null;
        }
    }
}

