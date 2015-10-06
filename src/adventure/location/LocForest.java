package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.animal.Animal;
import adventure.item.Item;

public class LocForest extends Location {

    @Override
    public String getName() {
        return "Forest";
    }

    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        map.put(Game.iLemon, new Integer[] {0, 3});
        map.put(Game.iPepper, new Integer[] {0, 3});
        map.put(Game.iWood, new Integer[] {3, 6});
        map.put(Game.iWeed, new Integer[] {-10, 1});
        map.put(Game.iVine, new Integer[] {2, 5});
        return map;
    }

    @Override
    public Map<Animal, Float> getFauna() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        map.put(Game.aShia, 0.01f);
        map.put(Game.aBear, 0.1f);
        map.put(Game.aDeer, 0.5f);
        return map;
    }

    @Override
    public Map<Animal, Float> getPredators() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        map.put(Game.aShia, 0.01f);
        map.put(Game.aBear, 0.1f);
        return map;
    }

    @Override
    public boolean hasWater() {
        return true;
    }

}
