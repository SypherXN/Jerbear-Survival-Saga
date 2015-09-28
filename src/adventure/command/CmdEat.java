package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdEat implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            Item item = game.getItem(args[1]);
            if (item.hunger == 0) {
                System.out.printf("You cannot eat that %s.\n", item.name);
                return 0f;
            }
            player.hunger += item.hunger + 1;
            player.invRemove(item);
            System.out.printf("You ate the %s.", item.name);
            return 0.5f;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Eat what?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "POOTIS POOTIS POOTIS POOTIS";
    }

}
