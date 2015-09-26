package adventure;

import adventure.item.Item;

public class Recipe {
    
    public final Item[] tools, ingredients;
    public final int quantity;
    
    /**
     * A recipe that is used to craft an item.
     * @param tools Required objects that aren't consumed
     * @param ingredients Required objects that are consumed
     */
    Recipe(int quantity, Item[] tools, Item... ingredients) {
        this.tools = tools;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    /**
     * A recipe that is used to craft an item.
     * @param ingredients Required objects that are consumed
     */
    Recipe(int quantity, Item... ingredients) {
        this(quantity, new Item[0], ingredients);
    }

}
