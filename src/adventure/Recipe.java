package adventure;

import adventure.item.Item;

public class Recipe {
    
    public final Item[] tools, ingredients;
    public final Item result;
    public final int quantity;
    
    /**
     * A recipe that is used to craft an item.
     * @param tools Required objects that aren't consumed
     * @param ingredients Required objects that are consumed
     * @param result What you get
     */
    public Recipe(Item[] tools, Item[] ingredients, int quantity, Item result) {
        this.tools = tools;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.result = result;
    }

    /**
     * A recipe that is used to craft an item.
     * @param ingredients Required objects that are consumed
     * @param result What you get
     */
    public Recipe(Item[] ingredients, int quantity, Item result) {
        this(new Item[0], ingredients, quantity, result);
    }

}
