package adventure.command;

import adventure.Game;
import adventure.Player;

public interface Command {
    
    /**
     * Callback function
     * @param player
     * @param game 
     * @param args Arguments, including the command sent.
     * @return time passed after command is finished
     */
    public float onCalled(Player player, Game game, String... args);
    
    /**
     * A string printed when the command 'help [cmd]' is called
     * @return help
     */
    public String getHelp();
    
    public default boolean isHidden() {
    	return false;
    }

}
