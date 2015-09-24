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
            System.out.printf("You are at the %s.\n", player.location.getName());
            return true;
        }
        System.out.println("Check what?");
        return false;
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