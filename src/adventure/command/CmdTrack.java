package adventure.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import adventure.Game;
import adventure.Main;
import adventure.Player;
import adventure.animal.Animal;

public class CmdTrack implements Command {

    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        if (args.length == 1) {
            Map<Animal, Float> fauna = player.location.getFauna();
            List<String> foundAnimals = new ArrayList<String>();
            for (Animal a: fauna.keySet()) {
                if (Main.rand.nextFloat() <= fauna.get(a)); {
                    foundAnimals.add("a " + a.getName());
                    player.findAnimal(a);
                }
            }
            if (foundAnimals.size() == 0) {
                System.out.println("Found nothing."); 
            } else {
                System.out.printf("Found %s.\n", Main.listString(foundAnimals.toArray()));
            }
            return 1f;
        }
        return 0.5f;
    }

    @Override
    public String getHelp() {
        return "Usage:\n"
                + "    track            Search for animals nearby, if any."
                + "    track <animal>   Search for one animal (more time-efficient).";
    }

}
