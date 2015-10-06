package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.animal.Animal;
import adventure.item.Item;

public class LocRuins extends Location {

    @Override
    public String getName() {
        return "Ruins";
    }
    
    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        map.put(Game.iIron, new Integer[] {-1, 2});
        map.put(Game.iPcb, new Integer[] {-20, 1});
        map.put(Game.iRock, new Integer[] {3, 6});
        map.put(Game.iWood, new Integer[] {1, 3});
        return map;
    }

    @Override
    public Map<Animal, Float> getFauna() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        map.put(Game.aRobot, 0.01f);
        return map;
    }
    
    @Override
    public Map<Animal, Float> getPredators() {
        Map<Animal, Float> map = new HashMap<Animal, Float>();
        map.put(Game.aRobot, 0.005f);
        return map;
    }

    @Override
    public boolean hasWater() {
        return false;
    }
    
}
