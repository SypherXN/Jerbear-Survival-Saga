package adventure.command;

import java.util.List;
import java.util.Scanner;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.animal.Animal;

public class CmdAnimals implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        List<Animal> animals = player.getAnimalsFound();
        if (animals.size() == 0) {
            System.out.println("You have found nothing.");
            return 0f;
        }
        String[] names = new String[animals.size()];
        for (int i=0; i < names.length; i++) {
            names[i] = animals.get(i).getName();
        }
        System.out.printf("You have found a %s.", Main.listString(names));
        return 0;
    }

    @Override
    public String getHelp() {
        return null;
    }
    
}
