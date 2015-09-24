package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Animal;
import adventure.Catalog;
import adventure.Item;

public class LocBeach extends Location {

    @Override
    public String getName() {
        return "beach";
    }

    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        map.put(Catalog.wood, new Integer[] {1, 4});
        return map;
    }

    @Override
    public Map<Animal, Integer[]> getFauna() {
        Map<Animal, Integer[]> map = new HashMap<Animal, Integer[]>();
        return map;
    }

}