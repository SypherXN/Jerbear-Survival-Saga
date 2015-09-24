package adventure;

import java.util.Random;
import java.util.Scanner;

import adventure.command.Command;

public class Main {

    public static final Random rand = new Random();
    
    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String name = sc.nextLine();
        
        rollout(
                "Survival game",
                1000l, ", programmed by Maxim, designed by Matthew and Jerry\n",
                1500l, "You are stranded by maxim on an island.\n"
        );
        
        Game game = new Game();
        
        Player player = new Player();
        player.location = Location.BEACH;
        player.invAdd(Catalog.knife, Catalog.bottle);

        boolean foo = true;
        
        while (foo) {
            
            System.out.print("You... ");
            String[] input = sc.nextLine().split(" ");
            try {
                game.command(player, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command, please try again.");
            }

        }
        
        sc.close();
        
    }
    
    /**
     * Prints out first arg, sleeps for second arg milliseconds, prints out third arg, etc.
     * <p>
     * NOTE: Prints without line break
     * @param objs Odd args print and even args are sleep times
     */
    public static void rollout(Object... objs) {
        boolean doSleep = false;
        for (Object o: objs) {
            if (doSleep) {
                sleep((long) o);
            } else {
                System.out.print(String.valueOf(o));
            }
            doSleep = !doSleep;             
        }
    }
    
    /**
     * Sleeps for first arg, prints second arg, sleeps third arg, etc.
     * <p>
     * NOTE: Prints without line break
     * @param objs Even args print and odd args are sleep times
     */
    public static void rollout(long ms, Object... objs) {
        sleep(ms);
        rollout(objs);
    }
    
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
