package adventure;

public class Item {
    
    public final float weight, volume, hunger, damage;
    public final String[] nicks; // crafting and gathering
    public final String name, desc;

    /**
     * Full item constructor
     * @param name
     * @param desc
     * @param weight
     * @param volume
     * @param hunger
     * @param damage
     */
    public Item(String name, String[] nick, String desc, float weight, float volume, float hunger, float damage) {
        this.name = name;
        this.nicks = nick;
        this.desc = desc;
        this.weight = weight;
        this.volume = volume;
        this.hunger = hunger;
        this.damage = damage;
    }
    
    /**
     * Standard item constructor
     * @param name
     * @param desc
     * @param weight
     * @param volume
     * @param hunger
     * @param damage
     */
    public Item(String name, String desc, float weight, float volume, float hunger, float damage) {
        this(name, new String[] {name}, desc, weight, volume, hunger, damage);
    }

    /**
     * Mundane item
     * @param name
     * @param desc
     * @param weight
     * @param volume
     */
    public Item(String name, String desc, float weight, float volume) {
        this(name, desc, weight, volume, 0, 0);
    }
    
    /**
     * Typical food item, .25 weight and .25 volume
     * @param name
     * @param desc
     * @param hunger
     */
    public Item(String name, String desc, float hunger) {
        this(name, desc, 0.25f, 0.25f, hunger, 0);
    }
    
    /**
     * Typical food item, .25 weight and .25 volume
     * @param name
     * @param desc
     * @param hunger
     */
    public Item(String name, String[] nick, String desc, float hunger) {
        this(name, nick, desc, 0.25f, 0.25f, hunger, 0);
    }
    
    /**
     * A weapon
     * @param name
     * @param desc
     * @param weight
     * @param volume
     * @param damage
     */
    public Item(String name, String desc, float weight, float volume, float damage) {
        this(name, desc, weight, volume, 0, 0);
    }
    
    /**
     * Attack the target
     * @param player
     * @param target
     * @return if the attack was successful
     */
    public boolean attack(Player player, Animal target) {
        if (damage <= 0) {
            return false;
        }
        target.hp -= damage;
        return true;
    }
    
    public String toString() {
        return String.format("Item(name=\"%s\",wgt=%s,vol=%s,food=%s,dmg=%s)", name, weight, volume, hunger, damage);
    }
    
}
