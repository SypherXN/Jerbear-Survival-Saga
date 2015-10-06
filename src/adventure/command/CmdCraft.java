package adventure.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import adventure.Game;
import adventure.InvDoesNotContainItemException;
import adventure.InvOutOfVolumeException;
import adventure.InvOutOfWeightException;
import adventure.Main;
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
            if (!Main.yesno(sc, String.format("You require %s, are you sure?", Main.listItems(items)))) {
                System.out.println("Aborted.");
                return 0f;
            }
            if (!player.canCraft(game, item)) {
                System.out.println("You are missing items.");
                return 0f;
            }
            player.invAdd(item);
            player.invRemove(r.ingredients);
        	return 0.5f;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Craft what?");
        } catch (InvOutOfVolumeException e) {
            System.out.println("Your inventory is out of space.");
        } catch (InvOutOfWeightException e) {
            System.out.println("You are overburdened and cannot craft.");
        } catch (InvDoesNotContainItemException e) {
            e.printStackTrace();
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
