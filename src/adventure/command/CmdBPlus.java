package adventure.command;

import adventure.Game;
import adventure.Main;
import adventure.Player;

public class CmdBPlus implements Command {

    class InvalidGradeException extends RuntimeException {
        InvalidGradeException(String grade) {
            super(String.format("Unacceptable grade: %s", grade));
        }
    }
    
    @Override
    public float onCalled(Player player, Game game, String... args) {
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
        return Game.die.getHelp();
    }

}
