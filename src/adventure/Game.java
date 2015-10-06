package adventure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adventure.animal.Anim4Chainz;
import adventure.animal.AnimBear;
import adventure.animal.AnimChicken;
import adventure.animal.AnimCrab;
import adventure.animal.AnimDeer;
import adventure.animal.AnimShia;
import adventure.animal.AnimWolf;
import adventure.animal.Animal;
import adventure.command.CmdAnimals;
import adventure.command.CmdAttack;
import adventure.command.CmdCheck;
import adventure.command.CmdCook;
import adventure.command.CmdCraft;
import adventure.command.CmdDie;
import adventure.command.CmdDrink;
import adventure.command.CmdEat;
import adventure.command.CmdGather;
import adventure.command.CmdHelp;
import adventure.command.CmdInfo;
import adventure.command.CmdMine;
import adventure.command.CmdMove;
import adventure.command.CmdNerdCheckLocation;
import adventure.command.CmdTiger;
import adventure.command.CmdTrack;
import adventure.command.CmdWait;
import adventure.command.Command;
import adventure.command.dev.CmdDevGive;
import adventure.item.Item;
import adventure.item.RangedWeapon;
import adventure.location.LocBeach;
import adventure.location.LocForest;
import adventure.location.LocLake;
import adventure.location.LocRuins;
import adventure.location.Location;

public class Game {
    	
    /*************************************** ITEMS ***************************************/
    public static final Item 
    
    // Materials and Mundanes
            iIron =             new Item("Iron", "Don't drop it on your toe", 2f, 0.5f),
            iWood =             new Item("Wood", "Made from trees", 0.5f, 1f),
            iRock =      	    new Item("Rock", "It rocks", 1f, 0.5f),
            iFlint =            new Item("Flint", "It's sharp", 0.5f, 1f),
            iTorch =            new Item("Torch", "It's kind of hot", 0.5f, 2f),
            iPcb =              new Item("PCB", "A printed circuit board for cannons", 0.1f, 1f),
            iVine =     	    new Item("Vine", "6-second videos", 0.5f, 1f),
            iBottle =    	    new Item("Bottle", "Glug glug glug", 0.25f, .25f),
    
    // Weapons
            iArrow =     	    new Item("Arrow", "Pew-pew wait nvm its not a laser", 0.5f, 1f),
            iBow =              new RangedWeapon("Bow", "Retractable shooty-thingy", 1.5f, 3f, 10f, iArrow),
            iCLemon =           new Item("Combustible Lemon", "It has a DMCA notice on it", 0.1f, 0.1f),
            iCLemonGun =        new RangedWeapon("Combustible Lemon Launcher", "For burning life's house down", 1.5f, 3f, 30f, iCLemon),
            iHammer =    	    new Item("Hammer", "Stop, hammertime", 2f, 0.5f, 10f),
            iKnife =            new Item("Knife", "For cutting and burning", 0.5f, 1f, 5f),
            iSpear =            new Item("Spear", "Poke", 4f, 5f, 20f),
            iFists =            new Item("Fists", "It's all you got...", 0f, 0f, 1f),
    
    // Food
            iRchicken =         new Item("Raw Chicken", "Are you chicken?", 2f),
            iCchicken =         new Item("Cooked Chicken", "Kung Pao or KFC?", 5f),
            iRcrab =            new Item("Raw Crab", "Are you crab?", 1.5f),
            iCcrab =            new Item("Cooked Crab", "Krusty Krab", 4f),
            iLemon =            new Item("Lemon", "It's sour", 0.5f),
            iPepper =           new Item("Chili Pepper", "It's spicy", 0.5f),

            iWeed = 		    new Item("Chris Item", "It looks like a fan", .420f)
    ;
    
    /************************************* ANIMALS ***************************************/
    public static final Animal 
    
    // Non-hostile
            aChicken =          new AnimChicken(),
            aCrab =             new AnimCrab(),
            aDeer = 			new AnimDeer(),
    
    // Hostile
            aBear =             new AnimBear(),
            aRobot =            new Anim4Chainz(),
            aShia =             new AnimShia(),
            aWolf = 			new AnimWolf()
    
    ;
    
    /************************************ LOCATIONS ***************************************/
    public static final Location
    
    // Non-hidden
    		lBeach =			new LocBeach(),
    		lForest =		    new LocForest(),
    		lLake =			    new LocLake(),
    		lRuins = 	     	new LocRuins()
    // Hidden
    		
    ;
    
    /************************************  COMMANDS ***************************************/
    public static final Command
            cAnimals =          new CmdAnimals(),
            cAttack =           new CmdAttack(),
    		cTiger =            new CmdTiger(),
    		cCheck =			new CmdCheck(),
            cCook =             new CmdCook(),
            cCraft =            new CmdCraft(),
            cDie =              new CmdDie(),
            cDrink =            new CmdDrink(),
            cEat =              new CmdEat(),
    		cGather = 		    new CmdGather(),
    		cHelp = 			new CmdHelp(),
            cInfo =             new CmdInfo(),
            cLS =               new CmdNerdCheckLocation(),
			cMove = 			new CmdMove(),
            cMine =             new CmdMine(),
            cTrack =            new CmdTrack(),
    		cWait = 		    new CmdWait(),
    		
    		cdevGive =          new CmdDevGive()
    ;
    
    public int day;
    public float time;
    
    private List<String> shownCommands;
    
    private Map<String, Item> items;
    private Map<Item, Item> cookables;
    private Map<Item, Recipe> recipes;
    private Map<String, Command> commands;
    private Map<String, Location> locations;
    private Map<String, Animal> animals;
    
    public Game() {
        this(false);
    }
    
    public Game(boolean includeDev) {
                
        day = 0;
        time = 0;
        
        shownCommands = new ArrayList<String>();
        items =         new HashMap<String, Item>();
        cookables =     new HashMap<Item, Item>();
        recipes =       new HashMap<Item, Recipe>();
        commands =      new HashMap<String, Command>();
        locations =     new HashMap<String, Location>();
        animals =       new HashMap<String, Animal>();

        registerItem(iArrow,			"arrow");
        registerItem(iBottle,			"bottle", "canteen");
        registerItem(iBow,				"bow");
        registerItem(iCchicken,         "cookedchicken", "kungpao", "kfc");
        registerItem(iCcrab,            "cookedcrab", "popeye", "redlobster");
        registerItem(iCLemon,           "combustiblelemon", "cavelemon", "molotov", "incendiarylemon");
        registerItem(iCLemonGun,        "lemonlauncher", "lemongun");
        registerItem(iFlint,			"flint");
        registerItem(iHammer,			"hammer");
        registerItem(iKnife,            "knife");
        registerItem(iIron,             "metal", "ingot", "iron", "steel");
        registerItem(iPepper,           "pepper", "jalapeno", "spicy");
        registerItem(iPcb,              "pcb", "arduino", "raspberrypi");
        registerItem(iRchicken,         "rawchicken");
        registerItem(iRcrab,            "rawcrab");
        registerItem(iRock,				"rock", "stone");
        registerItem(iSpear,            "spear");
        registerItem(iTorch,            "torch", "burnystick");
        registerItem(iVine,				"vines", "vine");
        registerItem(iWeed,				"weed", "chris", "420");
        registerItem(iWood,             "wood");
        
        registerAnimal(aChicken,        "chicken", "duck", "livekfc", "livekungpao");
        registerAnimal(aCrab,           "crab", "pinchy", "lobster", "crustacean");
        registerAnimal(aDeer,           "deer", "moose", "meese");
        registerAnimal(aWolf,           "wolf", "dog", "canine", "rover", "dinner");
        registerAnimal(aRobot,          "robot", "4chainz", "beepboop", "blender", "hal");
        registerAnimal(aBear,           "bear", "arms", "amendment2");
        registerAnimal(aShia,           "shia", "cannibal");
        
        registerRecipe(iBow,        1,  new Item[] {iKnife},            iWood, iWood, iWood, iVine, iVine);
        registerRecipe(iCLemonGun,  1,  new Item[] {iHammer},           iPcb, iWood, iWood, iIron, iIron, iIron, iTorch);
        registerRecipe(iArrow,      4, 				    	            iFlint, iFlint, iWood, iVine);
        registerRecipe(iCLemon,     1,                                  iLemon, iPepper);
        registerRecipe(iHammer,     1,  new Item[] {iKnife},            iWood, iIron, iVine);
        registerRecipe(iSpear,      1,  new Item[] {iHammer},           iWood, iWood, iWood, iVine, iIron);
        registerRecipe(iKnife,      1,                                  iWood, iFlint);
        registerRecipe(iTorch,      1,  new Item[] {iFlint, iIron},     iWood);
        
        registerCookable(iRchicken, iCchicken);
        registerCookable(iRcrab, iCcrab);
        
        registerCommand(cAnimals,       "animals");
        registerCommand(cAttack,        "attack", "fight", "pwn", "rek");
        registerCommand(cCheck,         "check", "inspect");
        registerCommand(cCook,          "cook", "burn", "smelt", "melt", "fire");
        registerCommand(cCraft,         "craft", "make", "build", "smith");
        registerCommand(cDie, true,     "die", "suicide", "sepukku");
        registerCommand(cDrink,         "drink", "glug", "chug", "drown");
        registerCommand(cEat,           "eat", "nom", "consume");
        registerCommand(cGather, 		"gather", "fetch");
        registerCommand(cHelp, 			"help", "halp");
        registerCommand(cInfo,          "info");
        registerCommand(cLS, true,      "ls");
        registerCommand(cMove, 			"move", "travel", "cd");
        registerCommand(cMine, true,    "minesweeper");
        registerCommand(cTiger, true,   "a+ a- b+ b- c+ c- d+ d- f+ f-".split(" "));
        registerCommand(cTrack,         "track", "find");
        registerCommand(cWait,          "wait", "procrastinate");
        
        if (includeDev) {
            registerCommand(cdevGive,    "_give");
        }
        
        registerLocation(lBeach, 		"beach");
        registerLocation(lForest, 		"forest", "trees");
        registerLocation(lLake, 	    "lake");
        registerLocation(lRuins, 		"ruins");
        
        Collections.sort(shownCommands);
        
    }
    
    private void registerRecipe(Item result, int quantity, Item[] tools, Item... ingredients) {
        this.recipes.put(result, new Recipe(quantity, tools, ingredients));
    }
    
    private void registerRecipe(Item result, int quantity, Item... ingredients) {
    	registerRecipe(result, quantity, new Item[0], ingredients);
    }
    
    private void registerItem(Item item, String... names) {
        for (String n: names) {
            this.items.put(n.toLowerCase(), item);
        }
    }
    
    private void registerCookable(Item raw, Item cooked) {
        this.cookables.put(raw, cooked);
    }
    
    private void registerAnimal(Animal animal, String... names) {
        for (String n: names) {
            this.animals.put(n.toLowerCase(), animal);
        }
    }
    
    private void registerCommand(Command callback, String... names) {
        registerCommand(callback, false, names);
    }
    
    private void registerCommand(Command callback, boolean hidden, String... names) {
        try {
            if (!hidden) {
                shownCommands.add(names[0]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Did not specify a name for the command!");
        }
        for (String n: names) {
            this.commands.put(n.toLowerCase(), callback);
        }
    }
    
    private void registerLocation(Location location, String... names) {
    	for (String n: names) {
    		this.locations.put(n.toLowerCase(), location);
    	}
    }
    
    public List<String> getShownCommands() {
    	return shownCommands;
    }
    
    public Recipe getRecipe(Item item) {
        return recipes.get(item);
    }
    
    public Item getItem(String name) {
        return items.get(name.toLowerCase());
    }

    public Item getCooked(Item item) {
        return cookables.get(item);
    }

    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }

	public Command getCommand(String alias) {
		return commands.get(alias.toLowerCase());
	}

    public Animal getAnimal(String name) {
        return animals.get(name);
    }

}
