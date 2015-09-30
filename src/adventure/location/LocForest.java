package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Animal;
import adventure.Game;
import adventure.item.Item;

public class LocForest extends Location {

    @Override
    public String getName() {
        return "Forest";
    }

    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        map.put(Game.iWood, new Integer[] {5, 12});
        map.put(Game.iWeed, new Integer[] {0, 1});
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
        map.put(Game.aBear, 0.2f);
        return map;
    }

    @Override
    public boolean hasWater() {
        return true;
    }

}
