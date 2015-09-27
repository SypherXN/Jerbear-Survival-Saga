package adventure.command;

import adventure.Game;
import adventure.Player;

public class CmdWait implements Command {

    @Override
    public float onCalled(Player player, Game game, String... args) {
        try {
            float f = Float.parseFloat(args[1]);
            if (f <= 0) {
                System.out.println("Invalid input, try again.");
            } else if (f > 5) {
                System.out.println("You cannot wait for more than 5 hours at a time.");
            } else {
                System.out.printf("Waited %s hours.\n", f);
                return f;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wait how long?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: wait <hours>         Procrastinate your day away.";
    }

}
