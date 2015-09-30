package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.location.Location;

public class CmdMove implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
        	Location match = game.getLocation(args[1]);
        	if (match == null) {
        	    System.out.println("Invalid location, try again.");
        	    return 0f;
        	}
        	if (match.isHidden()) {
        		System.out.printf("You have discovered the %s!\n", match.getName());
        	}
        	System.out.printf("You move to the %s.\n", match.getName());
        	player.location = match;
        	return 2f;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Move where?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: move <newlocation>	Moves the player to a location.";
    }

}
