package adventure.command.dev;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.command.Command;
import adventure.item.Item;

/**
 * Developer command: Give
 *
 */
public class CmdDevGive implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            Item i = game.getItem(args[1].toLowerCase());
            player.invAdd(i);
            System.out.printf("Gave %s\n", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
