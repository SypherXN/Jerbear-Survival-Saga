package adventure.command;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdInfo implements Command {

	@Override
	public boolean onCalled(Player player, Game game, String... args) {
		if (args.length == 1) {
			System.out.println("Find info on what?");
			return false;
		}
        Item match = game.getItem(args[1]);
        if (match == null) {
            System.out.println("Invalid item.");
            return false;
        }
        System.out.println(match.desc);
        return true;
	}

	@Override
	public String getHelp() {
		return "Usage: info <item>			Retrieves information on an item.";
	}

}
