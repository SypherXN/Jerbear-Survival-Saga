package adventure;

public class Recipe {
    
    final Item[] tools, ingredients;
    final Item result;
    
    public Recipe(Item[] tools, Item[] ingredients, Item result) {
        this.tools = tools;
        this.ingredients = ingredients;
        this.result = result;
    }

}
