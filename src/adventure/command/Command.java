package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;

public interface Command {
    
    /**
     * Callback function
     * @param player
     * @param game 
     * @param sc 
     * @param args Arguments, including the command sent.
     * @return time passed after command is finished
     */
    public float onCalled(Player player, Game game, Scanner sc, String... args);
    
    /**
     * A string printed when the command 'help [cmd]' is called
     * @return help
     */
    public String getHelp();
    
}
