package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.exception.InvDoesNotContainItemException;
import adventure.exception.InvOutOfVolumeException;
import adventure.exception.InvOutOfWeightException;
import adventure.item.Item;

public class CmdCook implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        Item item = game.getItem(args[1]);
        if (item == null) {
            System.out.println("Invalid item, try again.");
            return 0f;
        }
        try {
            if (!player.invContains(Game.iTorch)) {
                System.out.println("You do not have a torch.");
                return 0f;
            }
            Item cooked = game.getCooked(item);
            player.invAdd(cooked);
            player.invRemove(item);
            System.out.printf("You cooked the %s and made %s.", item.name, cooked.name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cook what?");
        } catch (InvDoesNotContainItemException e) {
            System.out.printf("You do not have a %s.", e.item.name);
        } catch (InvOutOfVolumeException e) {
            System.out.println("Your inventory is out of space.");
            try {
                player.invRemove(item);
            } catch (InvDoesNotContainItemException e1) {
                e1.printStackTrace();
            }
        } catch (InvOutOfWeightException e) {
            System.out.println("You cannot carry anymore.");
            try {
                player.invRemove(item);
            } catch (InvDoesNotContainItemException e1) {
                e1.printStackTrace();
            }
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage:"
                + "    cook <item>      Cooks the item. You need a torch.";
    }

}
