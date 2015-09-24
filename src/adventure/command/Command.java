package adventure.command;

import adventure.Game;
import adventure.Player;

public interface Command {
    
    /**
     * Callback function
     * @param player
     * @param game 
     * @param args Arguments, including the command sent.
     * @return success
     */
    public boolean onCalled(Player player, Game game, String... args);

}
