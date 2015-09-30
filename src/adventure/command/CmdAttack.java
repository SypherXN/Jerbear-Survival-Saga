package adventure.command;

import java.util.Scanner;

import adventure.Animal;
import adventure.Game;
import adventure.Player;

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
                System.out.printf("You have not found a %s, go find one.\n", animal.name);
                return 0f;
            }
            boolean doAttack = yesno(
                    sc,
                    String.format(
                        "Do you want to attack the %1$s?\n"
                        + "Your HP: %2$s    %1$s HP: %3$s\n",
                        animal.name, player.hp, animal.hp
                    )
            );
            if (!doAttack) {
                System.out.println("Aborted.");
                return 0f;
            }
            return player.attack(animal, false);
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
    
    public static boolean yesno(Scanner sc, String question) {
        System.out.print(question);
        while (true) {
            String response = sc.nextLine().toLowerCase();
            if (response.equals("y") || response.equals("yes") || response.equals("true")) {
                return true;
            } else if (response.equals("n") || response.equals("no") || response.equals("false")) {
                return false;
            } else {
                System.out.println("Invalid response, try again.");
            }
        }
    }
    
}
