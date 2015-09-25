package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final Random rand = new Random();
    
    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        //String name = sc.nextLine();
        
        rollout(
                "Survival game",
                100l, ", programmed by Maxim, designed by Matthew and Jerry\n",
                100l, "You are stranded on an island.\n"
        );
        
        Game game = new Game();
        
        Player player = new Player();
        player.location = game.getLocation("beach");
        player.invAdd(Game.iKnife, Game.bottle);

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
    
    public static Object[] subarray(Object[] array, int start, int end, int step) {
    	List<Object> list = new ArrayList<Object>();
    	for (int i=start; i < end; i += step) {
    		list.add(array[i]);
    	}
    	return list.toArray();
    }

	public static Object[] subarray(Object[] args, int start, int end) {
		return subarray(args, start, end, 1);
	}

}
