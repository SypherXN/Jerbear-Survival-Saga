package adventure;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    int day;
    float time;
    
    List<Item> items;
    List<Recipe> recipes;
    
    public Game() {
        this.day = 0;
        this.time = 0;
        this.items = new ArrayList<Item>();
        items.add(Catalog.arrow);
        items.add(Catalog.bottle);
        items.add(Catalog.bow);
        items.add(Catalog.cchicken);
        items.add(Catalog.flint);
        items.add(Catalog.hammer);
        items.add(Catalog.knife);
        items.add(Catalog.rchicken);
        items.add(Catalog.rock);
        items.add(Catalog.spear);
        items.add(Catalog.vines);
        items.add(Catalog.wood);
        this.recipes = new ArrayList<Recipe>();
    }
    
    public void registerRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public boolean craft(Player player, Item item) {
        return false;
    }

}
