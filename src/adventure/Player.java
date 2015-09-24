package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        String s = "";
        for (int n=0; n < inventory.size() - 1; n++) {
            Item i = inventory.get(n);
            s += i.name + ", ";
        }
        s += "and " + inventory.get(inventory.size() - 1).name;
        return s;
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
    
    public static void main(String[] args) {
        Player player = new Player();
        player.invAdd(Catalog.arrow, Catalog.arrow, Catalog.bottle);
        System.out.println(player.getInventory());
    }
    
}
