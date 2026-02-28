/**
 * Factory for building the player.
 */
public class PlayerFactory {
    /**
     * Default player constructor.
     */
    public PlayerFactory() {}

    /**
     * Method that builds the correct player tupe.
     * @param type a string for the player type.
     * @return a new player of the correct type.
     */
    public static Player buildPlayer(String type) {
        switch(type) {
            case "human":
                return new HumanPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "naive":
                return new NaivePlayer();
            case "smart":
                return new SmartPlayer();
        }
        return null;
    }
}
