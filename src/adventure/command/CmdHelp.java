package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;

public class CmdHelp implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        if (args.length == 1) {
            String out = "Commands:\n";
            for (String alias: game.getShownCommands()) {
                out += alias + "\n";
            }
            System.out.println(out);
        }
        if (args.length == 2) {
            Command cmd = game.getCommand(args[1]);
            if (cmd == null) {
                System.out.println("Invalid command, try again");
                return 0f;
            }
            System.out.println(cmd.getHelp());
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "A command that helps you.\n"
                + "Usage:\n"
                + "    help           Lists all the commands\n"
                + "    help <cmd>     Gives help for that command";
    }

}
