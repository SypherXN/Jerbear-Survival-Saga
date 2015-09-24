package adventure;

public class Catalog {
    
    /* ************************************** ITEMS ************************************** */
    
    // Materials
    public static final Item 
            wood =      new Item("Wood", "Made from trees", 0.5f, 1f),
            rock =      new Item("Rock", "It rocks", 1f, 0.5f),
            flint =     new Item("Flint", "It's sharp", 0.5f, 1f),
            vines =     new Item("Vine", "6-second videos", 0.5f, 1f),
            bottle =    new Item("Bottle", "Swallow", 0.25f, .25f),
    
    // Weapons
            arrow =     new Item("Arrow", "Pew-pew nevermind its a bow", 0.5f, 1f),
            bow =       new RangedWeapon("Bow", "Retractable shooty-thingy", 1.5f, 3f, 10f, arrow),
            hammer =    new Item("Hammer", "Hop, Stammertime", 2f, 0.5f, 10f),
            knife =     new Item("Knife", "For cutting and burning", 0.5f, 1f, 5f),
            spear =     new Item("Spear", "Poke", 4f, 5f, 20f),
    
    // Food
            rchicken = new Item("Raw Chicken", "Are you chicken?", 2f),
            cchicken = new Item("Cooked Chicken", "Kung Pao or KFC?", 5f),
            weed = new Item("Chris Item", new String[] {"weed", "chris"}, "It looks like a fan", 4.20f)
    ;

    /* ************************************ ANIMALS ************************************** */
    
    public static final Animal 
            chicken = new Animal("Chicken", 10f, 0f),
            wolf = new Animal("Wolf", 20f, 20f),
            deer = new Animal("Deer", 45f, 0f),
            bear = new Animal("Bear", 80f, 50f);
    
    /* *********************************** LOCATIONS ************************************** */
    
}
