/**
 * Interface for the player.
 */
public interface Player {
    /**
     * Determines the strategy of the player.
     * @param board the game board.
     * @param mark the type of mark.
     */
    public void playTurn(Board board, Mark mark);
}
