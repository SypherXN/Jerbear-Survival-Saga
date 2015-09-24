package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adventure.command.CmdAttack;
import adventure.command.CmdCheck;
import adventure.command.CmdCraft;
import adventure.command.CmdDie;
import adventure.command.CmdGather;
import adventure.command.CmdHelp;
import adventure.command.CmdMove;
import adventure.command.CmdWait;
import adventure.command.Command;
import adventure.location.LocBeach;
import adventure.location.LocJungle;
import adventure.location.LocLake;
import adventure.location.LocRuins;
import adventure.location.Location;

public class Game {
    
    public int day;
    public float time;
    
    public List<Item> items;
    public List<Recipe> recipes;
    public Map<String, Command> commands;
    public Map<String, Location> locations;
    
    public Game() {
        
        day = 0;
        time = 0;
        
        items = new ArrayList<Item>();
        registerItem(Catalog.arrow);
        registerItem(Catalog.bottle);
        registerItem(Catalog.bow);
        registerItem(Catalog.cchicken);
        registerItem(Catalog.flint);
        registerItem(Catalog.hammer);
        registerItem(Catalog.knife);
        registerItem(Catalog.rchicken);
        registerItem(Catalog.rock);
        registerItem(Catalog.spear);
        registerItem(Catalog.vines);
        registerItem(Catalog.weed);
        registerItem(Catalog.wood);
        
        recipes = new ArrayList<Recipe>();
        
        commands = new HashMap<String, Command>();
        registerCommand("attack",       new CmdAttack());
        registerCommand("check",        new CmdCheck());
        registerCommand("craft",        new CmdCraft());
        registerCommand("die",          new CmdDie());
        registerCommand("gather",       new CmdGather());
        registerCommand("help",         new CmdHelp());
        registerCommand("make",         new CmdCraft());
        registerCommand("move",         new CmdMove());
        registerCommand("suicide",      new CmdDie());
        registerCommand("travel",       new CmdDie());
        registerCommand("procrastinate",new CmdDie());        
        registerCommand("wait",         new CmdWait());
        
        locations = new HashMap<String, Location>();
        registerLocation("beach",       new LocBeach());
        registerLocation("jungle",      new LocJungle());
        registerLocation("lake",        new LocLake());
        registerLocation("ruins",       new LocRuins());
        
    }
    
    public void registerRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public void registerItem(Item item) {
        this.items.add(item);
    }
    
    public void registerCommand(String command, Command callback) {
        this.commands.put(command, callback);
    }
    
    public void registerLocation(String name, Location location) {
        this.locations.put(name, location);
    }
    
    public boolean craft(Player player, Item item) {
        return false;
    }
    
    public void command(Player player, String... args) throws IllegalArgumentException {
        Command cmd = commands.get(args[0]);
        if (cmd == null) {
            throw new IllegalArgumentException("Invalid command");
        }
        cmd.onCalled(player, this, args);
    }

}
