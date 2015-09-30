package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.animal.Animal;

public class CmdAttack implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        try {
            Animal animal = game.getAnimal(args[1]);
            if (animal == null) {
                System.out.println("Invalid animal, try again.");
                return 0f;
            }
            if (!player.hasFoundAnimal(animal)) {
                System.out.printf("You have not found a %s, go find one.\n", animal.getName());
                return 0f;
            }
            boolean doAttack = Main.yesno(
                    sc,
                    String.format(
                        "Do you want to attack the %1$s?\n"
                        + "Your HP: %2$s    %1$s HP: %3$s\n",
                        animal.getName(), player.hp, animal.getHealth()
                    )
            );
            if (!doAttack) {
                System.out.println("Aborted.");
                return 0f;
            }
            return player.fight(sc, game, animal, false);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Attack what?");
        }
        return 0f;
    }

    @Override
    public String getHelp() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
