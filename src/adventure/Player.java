package adventure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import adventure.command.Command;
import adventure.item.Item;
import adventure.location.Location;

public class Player {
    
    public static final float MAXHUNGER = 25, // start with full, degrades 1 per hour, hurts for 5-hunger damage each hour below 5
                              MAXTHIRST = 20, // start with full 3L bottle, full thirst, degrades 2 per hour, hurts for 25 damage each hour at 0
                              MAXHEALTH = 200,
                              MAXWEIGHT = 15,
                              MAXVOLUME = 20;
    
    public Location location;
    private List<Item> inventory, storage;
    public float hp, hunger, thirst;
    
    public Player() {
        hp = MAXHEALTH;
        hunger = MAXHUNGER;
        thirst = MAXTHIRST;
        inventory = new ArrayList<Item>();
        storage = new ArrayList<Item>();
    }
    
    public void invAdd(Item... items) {
        for (Item i: items) {
            inventory.add(i);
        }
    }
    
    public void invAdd(Item item, int n) {
        for (int x=0; x < n; x++) {
            inventory.add(item);
        }
    }
    
    public void invRemove(Item... items) {
        for (Item i: items) {
            if (!invContains(i)) {
                throw new IllegalArgumentException(String.format("The inventory is missing %s.", i));
            }
        }
        for (Item i: items) {
            inventory.remove(i);
        }
    }
    
    public void invRemove(Item item, int n) {
        if (!invContains(item)) {
            throw new IllegalArgumentException(String.format("The inventory is missing %s.", item));
        }
        for (int x=0; x < n; x++) {
            inventory.remove(item);
        }
    }
    
    public boolean invContains(Item item) {
        return inventory.contains(item);
    }
    
    public void storageAdd(Item... items) {
        for (Item i: items) {
            storage.add(i);
        }
    }
    
    public void storageAdd(Item item, int n) {
        for (int x=0; x < n; x++) {
            storage.add(item);
        }
    }
    
    public void storageRemove(Item... items) {
        for (Item i: items) {
            if (!storageContains(i)) {
                throw new IllegalArgumentException(String.format("The storage is missing %s.", i));
            }
        }
        for (Item i: items) {
            storage.remove(i);
        }
    }
    
    public void storageRemove(Item item, int n) {
        if (!storageContains(item)) {
            throw new IllegalArgumentException(String.format("The storage is missing %s.", item));
        }
        for (int x=0; x < n; x++) {
            storage.remove(item);
        }
    }
    
    public boolean storageContains(Item item) {
        return storage.contains(item);
    }
    
    public float getVolume() {
        float sum = 0;
        for (Item i: inventory) {
            sum += i.volume;
        }
        return sum;
    }
    
    public float getWeight() {
        float sum = 0;
        for (Item i: inventory) {
            sum += i.weight;
        }
        return sum;
    }
    
    public String getInventoryNames() {
        List<String> counts = new ArrayList<String>();
        HashMap<Item, Integer> inv = getInventory();
        for (Item i: inv.keySet()) {
            counts.add(String.format("%s %s", inv.get(i), i.name));
        }
        Collections.sort(counts);
        if (counts.size() == 2) {
            return String.format("You have %s and %s on hand.", counts.get(0), counts.get(1));
        }
        String out = "You have ";
        int i = 0;
        for (String s: counts) {
            if (i == counts.size() - 1) {
                out += "and " + s;
            } else {
                out += s + ", ";
            }
            i++;
        }
        out += " on hand.";
        return out;
    }
    
    public HashMap<Item, Integer> getInventory() {
        HashMap<Item, Integer> inv = new HashMap<Item, Integer>();
        for (Item i: inventory) {
            if (!inv.containsKey(i)) {
                inv.put(i, 0);
            }
            inv.put(i, inv.get(i) + 1);
        }
        return inv;
    }
        
    public boolean canCraft(Game game, Item item) {
        Recipe r = game.getRecipe(item);
        if (r == null) {
            return false;
        }
        for (Item i: r.ingredients) {
            if (!invContains(i)) {
                return false;
            }
        }
        for (Item i: r.tools) {
            if (!invContains(i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean craft(Game game, Item item) {
        if (!canCraft(game, item)) {
            return false;
        }
        Recipe r = game.getRecipe(item);
        invRemove(r.ingredients);
        invAdd(item);
        return true;
    }
    
    public void command(Game game, String... args) throws IllegalArgumentException {
        Command cmd = game.getCommand(args[0].toLowerCase());
        if (cmd == null) {
            throw new IllegalArgumentException("Invalid command");
        }
        cmd.onCalled(this, game, args);
    }
    
}
