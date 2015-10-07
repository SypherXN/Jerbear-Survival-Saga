package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.exception.InvDoesNotContainItemException;
import adventure.item.Item;

public class CmdEat implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            Item item = game.getItem(args[1]);
            if (item == null) {
                System.out.println("Invalid item, try again.");
                return 0f;
            }
            if (item.hunger == 0) {
                System.out.printf("You cannot eat that %s.\n", item.name);
                return 0f;
            }
            player.invRemove(item);
            player.hunger += item.hunger + 1;
            System.out.printf("You ate the %s.", item.name);
            if (item.equals(Game.iWeed)) {
                System.out.println("You start seeing things.");
            }
            return 0.5f;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Eat what?");
        } catch (InvDoesNotContainItemException e) {
            System.out.printf("You do not have a %s.\n", e.item.name);
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "POOTIS POOTIS POOTIS POOTIS";
    }

}
