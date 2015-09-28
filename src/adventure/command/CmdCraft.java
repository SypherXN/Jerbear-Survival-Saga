package adventure.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.Recipe;
import adventure.item.Item;

public class CmdCraft implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
        	Item item = game.getItem(args[1]);
        	if (item == null) {
        		System.out.println("Invalid item, try again.");
        		return 0f;
        	}
            Recipe r = game.getRecipe(item);
            if (r == null) {
                System.out.printf("You cannot craft %s.\n", item.name);
                return 0f;
            }
            Map<Item, Integer> items = new HashMap<Item, Integer>(); 
            for (Item i: r.ingredients) {
                if (items.get(i) == null) {
                    items.put(i, 0);
                }
                items.put(i, items.get(i) + 1);
            }
            System.out.printf("You require %s, are you sure?", CmdCheck.listItems(items));
            if (!player.canCraft(game, item)) {
                System.out.println("You are missing items.");
                return 0f;
            }
            player.invRemove(r.ingredients);
            player.invAdd(item);
        	return 0f;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Craft what?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
