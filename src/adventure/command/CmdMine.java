package adventure.command;

import java.util.Scanner;

import adventure.Game;
import adventure.Player;
import minesweeper.Minesweeper;

public class CmdMine implements Command {
	
	@Override
	public float onCalled(Player player, Game game, Scanner sc, String... args) {
	    Minesweeper.play(sc);
		System.out.println("You also lost 2 hours because you played minesweeper. Now get back to work.");
		return 2f;
	}

	@Override
	public String getHelp() {
		return "Sweep some mines.";
	}
		
}
