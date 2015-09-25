package adventure.command;

import adventure.Game;
import adventure.Player;
import adventure.location.Location;

public class CmdMove implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
    	if (args.length == 1) {
    		System.out.println("Move where?");
    		return false;
    	}
    	Location match = game.getLocation(args[1]);
    	if (match.isHidden()) {
    		System.out.printf("You have discovered the %s!\n", match.getName());
    	}
    	System.out.printf("You move to the %s.\n", match.getName());
    	player.location = match;
        return true;
    }

    @Override
    public String getHelp() {
        return "Usage: move <newlocation>	Moves the player to a location.";
    }

}
