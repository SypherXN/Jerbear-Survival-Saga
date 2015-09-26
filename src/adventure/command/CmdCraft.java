package adventure.command;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdCraft implements Command {

    @Override
    public float onCalled(Player player, Game game, String... args) {
    	if (args.length == 1) {
    		System.out.println("Craft what?");
    		return 0f;
    	}
    	Item item = game.getItem(args[1]);
    	if (item == null) {
    		System.out.println("Invalid item, try again.");
    	}
    	if (!player.craft(game, item)) {
    	    //System.out.println("You are missing );
    	    return 0f;
    	}
        return 0f;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
