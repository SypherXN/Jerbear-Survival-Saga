package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdCheck implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
        if (args[1].equals("inventory")) {
            System.out.println(player.getInventoryNames());
            return true;
        } else if (args[1].equals("location") || args[1].equals("surroundings")) {
            System.out.printf("You are at the %s.\n", player.location.name);
            return true;
        }
        System.out.println("Check what?");
        return false;
    }

}
