package adventure.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import adventure.Game;
import adventure.Player;
import adventure.item.Item;

public class CmdCheck implements Command {

    @Override
    public float onCalled(Player player, Game game, String... args) {
        if (args[1].equals("inventory")) {
            List<String> counts = new ArrayList<String>();
            HashMap<Item, Integer> inv = player.getInventory();
            for (Item i: inv.keySet()) {
                counts.add(String.format("%s %s", inv.get(i), i.name));
            }
            Collections.sort(counts);
            if (counts.size() == 2) {
                System.out.printf("You have %s and %s on hand.\n", counts.get(0), counts.get(1));
            } else {
                String out = "You have ";
                int i = 0;
                for (String s: counts) {
                    if (i == counts.size() - 1) {
                        out += "and " + s;
                    } else {
                        out += s + ", ";
                    }
                    i++;
                }
                System.out.println(out + " on hand.");
            }
        } else if (args[1].equalsIgnoreCase("location") || args[1].equalsIgnoreCase("surroundings")) {
            System.out.printf("You are at the %s.\n", player.location.getName());
        } else if (args[1].equalsIgnoreCase("time") || args[1].equalsIgnoreCase("day") || args[1].equalsIgnoreCase("calendar")) {
            System.out.printf("It is hour %s of day %s.\n", game.time, game.day);
        } else if (args[1].equalsIgnoreCase("stomach") || args[1].equalsIgnoreCase("hunger") || args[1].equalsIgnoreCase("thirst")) {
            System.out.printf("It is hour %s of day %s.\n", game.time, game.day);
        } else {
            System.out.println("Check what?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: check <stat>  Fetches a statistic.\n"
                + "The stat can be:\n"
                + "    calendar         Time and day\n"
                + "    day              Day \n"
                + "    inventory        Your inventory\n"
                + "    location         Where you are\n"
                + "    surroundings     Where you are\n"
                + "    time             Time of day";
    }

}
