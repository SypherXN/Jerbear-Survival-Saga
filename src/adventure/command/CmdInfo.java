package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdInfo implements Command {

	@Override
	public float onCalled(Player player, Game game, Scanner sc, String... args) {
		try {
            Item item = game.getItem(args[1]);
            if (item == null) {
                System.out.println("Invalid item.");
            }
            System.out.println(item.desc);
		} catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Find info on what?");
		}
        return 0f;
	}

	@Override
	public String getHelp() {
		return "Usage: info <item>			Retrieves information on an item.";
	}

}
