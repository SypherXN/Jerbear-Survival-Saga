package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;

public class CmdNerdCheckLocation implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        return Game.cCheck.onCalled(player, game, sc, "check", "location");
    }

    @Override
    public String getHelp() {
        return "A nerd-ass way of checking the where you are.";
    }

}
