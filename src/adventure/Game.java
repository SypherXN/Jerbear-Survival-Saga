package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adventure.command.CmdAttack;
import adventure.command.CmdBPlus;
import adventure.command.CmdCheck;
import adventure.command.CmdCraft;
import adventure.command.CmdDie;
import adventure.command.CmdGather;
import adventure.command.CmdHelp;
import adventure.command.CmdInfo;
import adventure.command.CmdMine;
import adventure.command.CmdMove;
import adventure.command.CmdWait;
import adventure.command.Command;
import adventure.item.Item;
import adventure.item.RangedWeapon;
import adventure.location.LocBeach;
import adventure.location.LocJungle;
import adventure.location.LocLake;
import adventure.location.LocRuins;
import adventure.location.Location;

public class Game {
	
    /*************************************** ITEMS ***************************************/
    public static final Item 
    
    // Materials and Mundanes
            iWood =      	new Item("Wood", "Made from trees", 0.5f, 1f),
            iRock =      	new Item("Rock", "It rocks", 1f, 0.5f),
            iFlint =     	new Item("Flint", "It's sharp", 0.5f, 1f),
            iVine =     	new Item("Vine", "6-second videos", 0.5f, 1f),
            iBottle =    	new Item("Bottle", "Swallow", 0.25f, .25f),
    
    // Weapons
            iArrow =     	new Item("Arrow", "Pew-pew wait nvm its a bow", 0.5f, 1f),
            iBow =       	new RangedWeapon("Bow", "Retractable shooty-thingy", 1.5f, 3f, 10f, iArrow),
            iHammer =    	new Item("Hammer", "Hop, Stammertime", 2f, 0.5f, 10f),
            iKnife =     	new Item("Knife", "For cutting and burning", 0.5f, 1f, 5f),
            iSpear =     	new Item("Spear", "Poke", 4f, 5f, 20f),
    
    // Food
            iRchicken = 	new Item("Raw Chicken", "Are you chicken?", 2f),
            iCchicken = 	new Item("Cooked Chicken", "Kung Pao or KFC?", 5f),
            iWeed = 		new Item("Chris Item", "It looks like a fan", .420f)
    ;
    
    /************************************* ANIMALS ***************************************/
    public static final Animal 
    
    // Non-hostile
    		chicken = 		new Animal("Chicken", 10f, 0f),
            deer = 			new Animal("Deer", 50f, 0f),
    
    // Hostile
            wolf = 			new Animal("Wolf", 20f, 20f),
            bear = 			new Animal("Bear", 80f, 50f);
    
    /************************************ LOCATIONS ***************************************/
    public static final Location
    
    // Non-hidden
    		beach =			new LocBeach(),
    		jungle =		new LocJungle(),
    		lake =			new LocLake(),
    		ruins = 		new LocRuins()
    // Hidden
    		
    ;
    
    /************************************  COMMANDS ***************************************/
    public static final Command
    		attack = 		new CmdAttack(),
    		bplus =         new CmdBPlus(),
    		check =			new CmdCheck(),
    		craft = 		new CmdCraft(),
    		die = 			new CmdDie(),
    		gather = 		new CmdGather(),
    		help = 			new CmdHelp(),
    		info = 			new CmdInfo(),
			move = 			new CmdMove(),
			mine = 			new CmdMine(),
    		wait = 			new CmdWait()
    ;
    
    public int day;
    public float time;
    
    private Map<String, Item> items;
    private Map<Item, Recipe> recipes;
    private Map<String, Command> commands;
    private Map<String, Location> locations;
    
    public Game() {
        
        day = 0;
        time = 0;
        
        items = new HashMap<String, Item>();
        registerItem(iArrow,			"arrow");
        registerItem(iBottle,			"bottle", "canteen");
        registerItem(iBow,				"bow");
        registerItem(iCchicken,			"cookedchicken", "kungpao", "kfc");
        registerItem(iFlint,			"flint");
        registerItem(iHammer,			"hammer");
        registerItem(iKnife,			"knife");
        registerItem(iRchicken,			"rawchicken");
        registerItem(iRock,				"rock", "stone");
        registerItem(iSpear,			"spear");
        registerItem(iVine,				"vines", "vine");
        registerItem(iWeed,				"weed", "chris", "420");
        registerItem(iWood,				"wood");
        
        recipes = new HashMap<Item, Recipe>();
        registerRecipe(iBow, 1, new Item[]{iKnife}, iWood, iWood, iWood, iVine, iVine);
        registerRecipe(iArrow, 4, new Item[]{iFlint, iFlint, iWood, iVine});
        
        commands = new HashMap<String, Command>();
        registerCommand(bplus,          "a", "a- b+ b b- c+ c c- d+ d d- f".split(" "));
        registerCommand(check,          "check", "inspect");
        registerCommand(die, 			"die", "suicide", "sepukku", "disgrace");
        registerCommand(gather, 		"gather", "fetch");
        registerCommand(help, 			"help", "halp");
        registerCommand(info, 			"info");
        registerCommand(move, 			"move", "travel");
        registerCommand(mine, 			"minesweeper");
        
        locations = new HashMap<String, Location>();
        registerLocation(beach, 		"beach");
        registerLocation(jungle, 		"jungle");
        registerLocation(lake, 			"lake");
        registerLocation(ruins, 		"ruins");
        
    }
    
    private void registerRecipe(Item result, int quantity, Item[] tools, Item... ingredients) {
        this.recipes.put(result, new Recipe(quantity, tools, ingredients));
    }
    
    private void registerItem(Item item, String name1, String... names) {
		this.items.put(name1.toLowerCase(), item);
    	for (String n: names) {
    		this.items.put(n.toLowerCase(), item);
    	}
    }
    
    private void registerCommand(Command callback, String name1, String... names) {
        this.commands.put(name1.toLowerCase(), callback);
        for (String n: names) {
            this.commands.put(n.toLowerCase(), callback);
        }
    }
    
    private void registerLocation(Location location, String name1, String... names) {
		this.locations.put(name1, location);
    	for (String n: names) {
    		this.locations.put(n.toLowerCase(), location);
    	}
    }
    
    public List<String> getCommands() {
    	List<String> cmds = new ArrayList<String>();
    	for (String c: commands.keySet()) {
    		if (commands.get(c).isHidden()) {
    			continue;
    		}
    		cmds.add(c);
    	}
    	return cmds;
    }
    
    public Recipe getRecipe(Item item) {
        return recipes.get(item);
    }
    
    public Item getItem(String name) {
        return items.get(name.toLowerCase());
    }

    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }

	public Command getCommand(String alias) {
		return commands.get(alias.toLowerCase());
	}

}
