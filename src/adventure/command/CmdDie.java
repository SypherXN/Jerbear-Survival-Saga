package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdDie implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
        System.out.println("You died. The end.");
        System.exit(0);
        return true;
    }

}
