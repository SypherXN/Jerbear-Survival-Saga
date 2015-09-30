package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Main;
import adventure.Player;

public class CmdTiger implements Command {
    
    @Override
    public float onCalled(Player player, Game game, Scanner sc, String... args) {
        if (args[0].equals("a+")) {
            System.out.println("Good job, but you could have done better.");
            return 0f;
        }
        Main.rollout(
                args[0].toUpperCase() + "...\n",
                1000l, args[0].toUpperCase() + "...\n",
                1000l, args[0].toUpperCase() + "!!!\n",
                1000l, args[0].toUpperCase() + " AGAIN!?\n",
                1000l, "YOU ARE SHAMEFURR DISPRAY TO YOUR FAMORRY!\n",
                1000l, "COMMIT SUDOKU!\n", 500l);
        throw new InvalidGradeException(args[0].toUpperCase());
    }

    @Override
    public String getHelp() {
        return Game.cDie.getHelp();
    }
    
}

class InvalidGradeException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    InvalidGradeException(String grade) {
        super(String.format("Unacceptabru grade: %s\nPlayer spanked", grade));
    }
}
