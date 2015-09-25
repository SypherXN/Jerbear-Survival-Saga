package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Animal;
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
    public Map<Animal, Integer[]> getFauna() {
        Map<Animal, Integer[]> map = new HashMap<Animal, Integer[]>();
        return map;
    }
    
}
