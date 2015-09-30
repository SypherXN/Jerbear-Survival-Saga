package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Main;
import adventure.Player;

public class CmdCheck implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            String arg = args[1];
            if (Main.multiEquals(arg, "inventory inv".split(" "))) {
                System.out.printf(
                        "Volume (%s/%s)    Weight (%s/%s)\nYou have %s on hand.\n", 
                        player.getVolume(), Player.MAXVOLUME, 
                        player.getWeight(), Player.MAXWEIGHT, 
                        Main.listItems(player.getInventory())
                );
            } else if (Main.multiEquals(arg, "location surroundings".split(" "))) {
                System.out.printf("You are at the %s.\n", player.location.getName());
            } else if (Main.multiEquals(arg, "day time clock calendar watch".split(" "))) {
                System.out.printf("It is hour %s of day %s.\n", game.time, game.day);
            } else if (Main.multiEquals(arg, "stomach thirst hunger vitals health hp".split(" "))) {
                System.out.printf(
                        "You have %s/%s hp, %s/%s thirst, and %s/%s hunger.\n",
                        player.hp, Player.MAXHEALTH,
                        player.thirst, Player.MAXTHIRST,
                        player.hunger, Player.MAXHUNGER
                );
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Check what?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: check <stat>  Fetches a statistic.\n"
                + "The stat can be:\n"
                + "    day              Day \n"
                + "    inventory        Your inventory\n"
                + "    location         Where you are\n"
                + "    vitals           Health, thirst, and hunger."
        ;
    }

}
