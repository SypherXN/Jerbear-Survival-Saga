package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;

public class CmdDie implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        System.out.println("You died. The end.");
        System.exit(0);
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: die            You kill yourself.";
    }
    
}
