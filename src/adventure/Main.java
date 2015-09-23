package adventure;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
        player.inventory.add(Catalog.knife);
        player.inventory.add(Catalog.bottle);

        boolean foo = true;
        
        while (foo) {
            
            System.out.print("You... ");
            String[] input = sc.nextLine().split(" ");
            
            if (input[0].equals("gather")) {
                
                Item match = null;
                try {
                    for (Item i: game.items) itemcheck: {
                        for (String nick: i.nicks) {
                            if (input[1].toLowerCase().equals(nick.toLowerCase())) {
                                match = i;
                                break itemcheck;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Gather what?");
                }
                if (match != null) {
                    
                    System.out.println(match.name);
                } else {
                    System.out.println("Invalid argument, try again.");
                }
                
            } else if (input[0].equals("attack")) {

                if (input[1].equals("wolf")) {
                } else {
                    System.out.println("Attack what?");
                }

            } else if (input[0].equals("check")) {
                
                if (input[1].equals("inventory")) {
                    System.out.println(player.getInventoryNames());
                } else if (input[1].equals("location") || input[1].equals("surroundings")) {
                    System.out.printf("You are at the %s.\n", player.location.name);
                } else {
                    System.out.println("Check what?");
                }
            
            } else if (input[0].equals("wait") || input[0].equals("procrastinate")) {
                
                if (input.length < 2) {
                    System.out.println(input[0] + " how long?");
                } else {
                }

            } else if (input[0].equals("craft") || input[0].equals("make")) {
                
                
                
            } else if (input[0].equals("move") || input[0].equals("travel")) {
                
                
                
            } else {
                System.out.println("Invalid command, try again");
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
