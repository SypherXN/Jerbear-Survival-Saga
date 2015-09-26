package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdAttack implements Command {

    @Override
    public float onCalled(Player player, Game game, String... args) {
        return 0;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }

}
