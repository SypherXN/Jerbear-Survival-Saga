package adventure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import adventure.item.Item;
import adventure.location.Location;

public class Player {
    
    public static final float MAXHUNGER = 25, // start with full, degrades 1 per hour, hurts for 5-hunger damage each hour below 5
                              MAXTHIRST = 20, // start with full 3L bottle, full thirst, degrades 2 per hour, hurts for 25 damage each hour at 0
                              MAXHEALTH = 200,
                              MAXWEIGHT = 15,
                              MAXVOLUME = 20;
    
    public Location location;
    public List<Item> inventory, storage;
    public float hp, hunger, thirst;
    
    public Player() {
        hp = MAXHEALTH;
        hunger = MAXHUNGER;
        thirst = MAXTHIRST;
        inventory = new ArrayList<Item>();
        storage = new ArrayList<Item>();
    }
    
    public void invAdd(Item... items) {
        invAdd(1, items);
    }
    
    public void invAdd(int n, Item... items) {
        for (int x=0; x < n; x++) {
            for (Item i: items) {
                inventory.add(i);
            }
        }
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
    
}
