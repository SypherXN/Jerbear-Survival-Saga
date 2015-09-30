package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Animal;
import adventure.Game;
import adventure.item.Item;

public class LocRuins extends Location {

    @Override
    public String getName() {
        return "Ruins";
    }
    
    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        return map;
    }

    @Override
    public Map<Animal, Float> getFauna() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        map.put(Game.aCrab, 1f);
        return map;
    }
    
    @Override
    public Map<Animal, Float> getPredators() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        return map;
    }

    @Override
    public boolean hasWater() {
        return false;
    }
    
}
