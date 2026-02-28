/**
 * The tournament class where multiple games can take place according to the
 * number of rounds.
 */
public class Tournament {
    // Constants
    private static final String RESULTS = "######### Results #########";
    private static final String PLAYER_1_MESSAGE = "Player 1, %s won: %d rounds";
    private static final String PLAYER_2_MESSAGE = "Player 2, %s won: %d rounds";
    private static final String NUMBER_OF_TIES_MESSAGE = "Ties: %d";
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;

    // Class members.
    private final int rounds;
    private final Renderer renderer;
    private final Player player1;
    private final Player player2;

    /**
     * Tournament constructor.
     * @param rounds number of rounds.
     * @param renderer the type of renderer.
     * @param player1 the first player.
     * @param player2 the second player.
     */
    public Tournament(int rounds, Renderer renderer,  Player player1, Player player2) {
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * A tournament is played for the number of rounds inputted
     * and a winner or a tie is declared at the end of the tournament.
     * @param size the size of the board.
     * @param winStreak the win streak.
     * @param playerName1 the type of the first player.
     * @param playerName2 the type of the second player.
     */
    public void playTournament(int size, int winStreak, String playerName1, String playerName2) {
        int player1Wins = NUM_0, player2Wins = NUM_0, ties = NUM_0;
        for (int round = NUM_0; round < rounds; round++) {
            boolean evenRound = (round % NUM_2 == NUM_0);
            Player xPlayer = evenRound ? player1 : player2;
            Player yPlayer = evenRound ? player2 : player1;
            Game game = new Game(xPlayer, yPlayer, size, winStreak, renderer);
            Mark winner = game.run();
            if (winner == Mark.X) {
                if (evenRound) {
                    player1Wins += NUM_1;
                } else {
                    player2Wins += NUM_1;
                }
            } else if (winner == Mark.O) {
                if (evenRound) {
                    player2Wins += NUM_1;
                } else {
                    player1Wins += NUM_1;
                }
            } else {
                ties += NUM_1;
            }
        }
        System.out.println(RESULTS);
        System.out.println(String.format(PLAYER_1_MESSAGE, playerName1, player1Wins));
        System.out.println(String.format(PLAYER_2_MESSAGE, playerName2, player2Wins));
        System.out.println(String.format(NUMBER_OF_TIES_MESSAGE, ties));
    }

    /**
     * Main to run the code.
     * @param args the code arguments.
     */
    public static void main(String[] args) {
        int rounds = Integer.parseInt(args[NUM_0]);
        int size = Integer.parseInt(args[NUM_1]);
        int winStreak = Integer.parseInt(args[NUM_2]);
        Renderer renderer = RendererFactory.buildRenderer(args[NUM_3], size);
        Player player1 = PlayerFactory.buildPlayer(args[NUM_4]);
        Player player2 = PlayerFactory.buildPlayer(args[NUM_5]);
        if (renderer == null || player1 == null || player2 == null) {
            return;
        }
        Tournament tournament = new Tournament(rounds, renderer, player1, player2);
        tournament.playTournament(size, winStreak, args[NUM_4], args[NUM_5]);
    }
}
