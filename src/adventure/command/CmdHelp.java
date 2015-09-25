package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdHelp implements Command {

    @Override
    public boolean onCalled(Player player, Game game, String... args) {
        if (args.length == 1) {
            String out = "Commands:\n";
            for (String alias: game.getCommands()) {
                out += alias + "\n";
            }
            System.out.println(out);
            return true;
        }
        if (args.length == 2) {
            Command cmd = game.getCommand(args[1]);
            if (cmd == null) {
                System.out.println("Invalid command, try again");
                return false;
            }
            System.out.println(cmd.getHelp());
            return true;
        }
        return false;
    }

    @Override
    public String getHelp() {
        return "A command that helps you.\n"
                + "Usage:\n"
                + "    help           Lists all the commands\n"
                + "    help <cmd>     Gives help for that command";
    }

}
