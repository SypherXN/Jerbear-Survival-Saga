package adventure.command;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.item.Item;

public class CmdCraft implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
    	if (args.length == 1) {
    		System.out.println("Craft what?");
    		return false;
    	}
    	Item item = game.getItem(String.join(" ", (String[]) Main.subarray(args, 1, args.length)).toLowerCase());
    	if (item == null) {
    		System.out.println("Invalid item, try again.");
    	}
        return false;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
