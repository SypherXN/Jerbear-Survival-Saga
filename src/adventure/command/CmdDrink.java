package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;

public class CmdDrink implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        System.out.println("Drank 0.5L.");
        player.water -= 0.5;
        player.thirst = Player.MAXTHIRST;
        return 0f;
    }

    @Override
    public String getHelp() {
        return "Usage: drink            Drinks 500mL and fully restores your thirst.\n"
                + "\"I don't always drink water, but when I do, I can continue "
                + "living. Stay thirsty, my friends.\"";
    }

}
