package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import adventure.animal.Animal;
import adventure.command.Command;
import adventure.item.Item;
import adventure.location.Location;

public class Player {
    
    public static final float MAXHUNGER = 25, // start with full, degrades 2 per hour, hurts for 5-hunger damage each hour below 5
                              MAXTHIRST = 20, // start with full 3L bottle, full thirst, degrades 2 per hour, hurts for 25 damage each hour at 0
                              MAXHEALTH = 200,
                              MAXWEIGHT = 15,
                              MAXVOLUME = 20,
                              MAXBOTTLECAP = 3;
    
    public Location location;
    private List<Item> inventory, storage;
    private List<Animal> foundAnimals;
    public float water, hp, hunger, thirst;
    
    public final String name;
    
    public Player(String name) {
        inventory = new ArrayList<Item>();
        storage = new ArrayList<Item>();
        foundAnimals = new ArrayList<Animal>();
        water = getMaxWater();
        hp = MAXHEALTH;
        hunger = MAXHUNGER;
        thirst = MAXTHIRST;
        this.name = name;
    }
    
    /**
     * Fight mode
     * @param animal The target
     * @param isHiding Is sneak attacking
     * @return How long the fight lasts
     */
    public float fight(Scanner sc, Game game, Animal animal, boolean isHiding) {
        float timeElapsed = 0f, enemyHp = animal.getHealth();
        Item weapon;
        List<Item> weapons = new ArrayList<Item>();
        for (Item i: this.inventory) {
            if (i.damage > 0) {
                weapons.add(i);
            }
        }
        if (weapons.size() == 1) {
            weapon = weapons.get(0);
            System.out.printf("You use your %s.\n", weapon.name);
        } else if (weapons.size() == 0) {
            System.out.println("You have no weapons, so you use your fists.");
            weapon = Game.iFists;
        } else {
            System.out.println("Which weapon do you use?");
            while (true) {
                Item w = game.getItem(sc.nextLine());
                if (w != null) {
                    weapon = w;
                    break;
                } else {
                    System.out.println("Invalid item, try again.");
                }
            }
        }
        System.out.println("");
        while (true) {
            /*
             * hiding, ambush animals
             * attack
             * run
             */
            int choice = Main.choice(sc, "What do you do?", "You... ", "Attack", "Run");
            if (choice == 1) {
                System.out.printf("You attack the %s for %s damage.\n", animal.getName(), weapon.damage);
                enemyHp -= weapon.damage;
            } else if (choice == 2) {
                System.out.printf("You run from the %s.\n", animal.getName());
                break;
            }
            // enemy turn
            if (animal.getDamage() > 0) {
                System.out.printf("The %s damages you for %s damage.\n", animal.getName(), animal.getDamage());
                this.hp -= animal.getDamage();
            }
            if (this.hp <= 0) {
                System.out.printf("The %s defeated you in combat.\n", animal.getName());
                break;
            }
            if (enemyHp <= 0) {
                Map<Item, Integer> loot = animal.getLoot();
                try {
                    for (Item i: loot.keySet()) {
                        this.invAdd(i, loot.get(i));
                    }
                    System.out.printf(
                            "You killed the %s, salvaging %s from its body.\n", 
                            animal.getName(), Main.listItems(loot));
                } catch (InvOutOfVolumeException | InvOutOfWeightException e) {
                    System.out.printf(
                            "You killed the %s, but could not carry everything.\n", 
                            animal.getName()
                    );
                }
                break;
            }
            timeElapsed += 0.05f;
        }
        return timeElapsed;
    }
    
    public void invAdd(Item... items) throws InvOutOfVolumeException, InvOutOfWeightException {
        float itemWeights = 0, itemVolumes = 0;
        for (Item i: items) {
            itemWeights += i.weight;
            itemVolumes += i.volume;
        }
        if (itemWeights + this.getVolume() > MAXWEIGHT) {
            throw new InvOutOfWeightException();
        }
        if (itemVolumes + this.getWeight() > MAXVOLUME) {
            throw new InvOutOfVolumeException();
        }
        for (Item i: items) {
            inventory.add(i);
        }
    }
    
    public void invAdd(Item item, int n) throws InvOutOfVolumeException, InvOutOfWeightException {
        float itemWeights = item.weight * (float) n, itemVolumes = item.volume * (float) n;
        if (itemWeights > MAXWEIGHT) {
            throw new InvOutOfWeightException();
        }
        if (itemVolumes > MAXVOLUME) {
            throw new InvOutOfVolumeException();
        }
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
    
    public float getMaxWater() {
        float liters = 0;
        for (Item i: inventory) {
            if (i.equals(Game.iBottle)) {
                liters += MAXBOTTLECAP;
            }
        }
        return liters;
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
    
    public List<Animal> getAnimalsFound() {
        return foundAnimals;
    }
    
    public void findAnimal(Animal animal) {
        if (foundAnimals.contains(animal)) {
            System.out.println("fo");
            return;
        }
        foundAnimals.add(animal);
    }
    
    public boolean hasFoundAnimal(Animal animal) {
        System.out.println(foundAnimals);
        return foundAnimals.contains(animal);
    }
    
    public void command(Game game, Scanner sc, String... args) throws IllegalArgumentException {
        Command cmd = game.getCommand(args[0].toLowerCase());
        if (cmd == null) {
            throw new IllegalArgumentException("Invalid command");
        }
        float time = cmd.onCalled(this, game, sc, args);
        Location loc = this.location;
        for (Animal a: loc.getPredators().keySet()) {
            if (Main.rand.nextFloat() * time < loc.getPredators().get(a)) {
                System.out.printf("A %s ambushes you!\n", a.getName(), args[0]);
                game.time += this.fight(sc, game, a, false);
                break;
            }
        }
        game.time += time;
        while (game.time >= 24) {
            game.day += 1;
            game.time -= 24;
        }
        hunger = cap(hunger - 2 * time, 0, MAXHUNGER);
        thirst = cap(thirst - 2 * time, 0, MAXTHIRST);
        if (hunger < 5) {
            hp -= (5-hunger) * 5 * time;
        } else if (hunger > 20) {
            hp += 10;
            if (hp > MAXHEALTH) {
                hp = MAXHEALTH;
            }
        }
        if (thirst == 0) {
            hp -= 50 * time;
        }
    }
    
    public float cap(float x, float min, float max) {
        if (x > max) {
            return max;
        } else if (x < min) {
            return min;
        }
        return x;
    }
    
}
