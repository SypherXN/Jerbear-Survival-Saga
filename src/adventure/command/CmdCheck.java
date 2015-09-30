package adventure.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdCheck implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            String arg = args[1];
            if (multiEquals(arg, "inventory inv".split(" "))) {
                System.out.printf("You have %s on hand.", listItems(player.getInventory()));
            } else if (multiEquals(arg, "location surroundings".split(" "))) {
                System.out.printf("You are at the %s.\n", player.location.getName());
            } else if (multiEquals(arg, "day time clock calendar watch".split(" "))) {
                System.out.printf("It is hour %s of day %s.\n", game.time, game.day);
            } else if (multiEquals(arg, "stomach thirst hunger vitals health hp".split(" "))) {
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
    
    public static boolean multiEquals(String a, String... other) {
        for (String s: other) {
            if (a.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static String listItems(Map<Item, Integer> items) {
        List<String> counts = new ArrayList<String>();
        for (Item i: items.keySet()) {
            counts.add(String.format("%s %s", items.get(i), i.name));
        }
        Collections.sort(counts);
        return listString(counts.toArray());
    }

    public static String listString(Object[] items) {
        if (items.length == 1) {
            return String.valueOf(items[0]);
        } else if (items.length == 2) {
            return String.format("%s and %s", items[0], items[1]);
        }
        String out = "";
        int i = 0;
        for (Object s: items) {
            if (i == items.length - 1) {
                out += "and " + String.valueOf(s);
            } else {
                out += String.valueOf(s) + ", ";
            }
            i++;
        }
        return out;
    }

}
