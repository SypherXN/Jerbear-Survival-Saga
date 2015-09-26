package adventure.command;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.item.Item;

public class CmdGather implements Command {
    
    @Override
    public float onCalled(Player player, Game game, String... args) {
        if (args.length == 1) {
            System.out.println("Gather what?");
            return 0f;
        }
        Item item = game.getItem(args[1]);
        if (item == null) {
            System.out.println("Invalid item.");
            return 0f;
        }
        Integer[] range = player.location.get(item);
        if (range == null) {
            System.out.printf("There is no %s in the %s.\n", item.name, player.location.getName());
            return 1f;
        }
        int amount = Main.rand.nextInt(range[1] - range[0]) + range[0];
        player.invAdd(item, amount);
        System.out.printf("You gather %s %s.\n", amount, item.name.toLowerCase());
        return 1f;
    }

    @Override
    public String getHelp() {
        return "Usage: gather <item>  You attempt to gather an item. There may be \n"
                + "plenty or very little of that item depending on the location.";
    }
        
}
