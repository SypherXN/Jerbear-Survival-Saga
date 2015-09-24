package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdAttack implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
        return false;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
