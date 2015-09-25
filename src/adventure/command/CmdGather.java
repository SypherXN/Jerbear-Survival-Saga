package adventure.command;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.item.Item;

public class CmdGather implements Command {
    
    @Override
    public boolean onCalled(Player player, Game game, String... args) {
        Item match = game.getItem(args[1]);
        if (match == null) {
            System.out.println("Invalid item.");
            return false;
        }
        Integer[] range = player.location.get(match);
        if (range == null) {
            System.out.printf("There is no %s in the %s.\n", match.name.toLowerCase(), player.location.getName());
            return false;
        }
        int amount = Main.rand.nextInt(range[1] - range[0]) + range[0];
        player.invAdd(amount, match);
        System.out.printf("You gather %s %s.\n", amount, match.name.toLowerCase());
        return true;
    }

    @Override
    public String getHelp() {
        return "Usage: gather <item>  You attempt to gather an item. There may be \n"
                + "plenty or very little of that item depending on the location.";
    }
        
}
