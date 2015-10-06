package adventure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import adventure.item.Item;

public class Main {

    public static final Random rand = new Random();
    
    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String name = sc.nextLine();
        
        rollout(
                "Survival game",
                100l, ", programmed and designed by Maxim\n",
                100l, "You are stranded on an island.\n"
        );
        
        Game game = new Game();
        
        Player player = new Player(name);
        player.location = game.getLocation("beach");
        try {
            player.invAdd(Game.iKnife, Game.iBottle);
        } catch (InvOutOfVolumeException e1) {
            e1.printStackTrace();
        } catch (InvOutOfWeightException e1) {
            e1.printStackTrace();
        }
        
        while (true) {
            
            System.out.printf(
                    "Health: %s; Hunger: %s; Thirst: %s\n",
                    player.hp, player.hunger, player.thirst
            );
            System.out.print("You... ");
            String[] input = sc.nextLine().split(" ");
            try {
                player.command(game, sc, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command, please try again.");
            }
            
            if (player.hp <= 0) {
                System.out.println("You died. The end.");
                break;
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
	
    /**
     * Prints the question and possible choices, and outputs the number chosen.
     * @param question The question to be asked
     * @param sc The scanner used
     * @param choices All the choices (minus the numbers)
     * @return
     */
    public static int choice(Scanner sc, String question, String tag, Object... choices) {
        String prompt = "" + question + "\n";
        for (int n=1; n <= choices.length; n++) {
            prompt += String.format("%s: %s\n", n, choices[n-1]);
        }
        System.out.println(prompt + tag);
        while (true) {
            try {
                int i = Integer.parseInt(sc.nextLine());
                if (0 < i && i <= choices.length) {
                    return i;
                } else {
                    System.out.println("Invalid input, try again.");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input, try again.");
            }
        }
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
    
    
    public static boolean multiEquals(String a, String... other) {
        for (String s: other) {
            if (a.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static String listItems(Map<Item, Integer> items) {
        if (items.size() == 0) {
            return "nothing";
        }
        List<String> counts = new ArrayList<String>();
        for (Item i: items.keySet()) {
            counts.add(String.format("%s %s", items.get(i), i.name));
        }
        Collections.sort(counts);
        return listString(counts.toArray());
    }

    public static String listString(Object[] items) {
        if (items.length == 1) {
            return String.valueOf(items[0]);
        } else if (items.length == 2) {
            return String.format("%s and %s", items[0], items[1]);
        }
        String out = "";
        int i = 0;
        for (Object s: items) {
            if (i == items.length - 1) {
                out += "and " + String.valueOf(s);
            } else {
                out += String.valueOf(s) + ", ";
            }
            i++;
        }
        return out;
    }

}
