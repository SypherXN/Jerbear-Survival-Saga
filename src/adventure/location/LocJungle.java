package adventure.location;

import java.util.HashMap;
import java.util.Map;

import adventure.Animal;
import adventure.Catalog;
import adventure.Item;

public class LocJungle extends Location {

    @Override
    public String getName() {
        return "Jungle";
    }

    @Override
    public Map<Item, Integer[]> getResources() {
        Map<Item, Integer[]> map = new HashMap<Item, Integer[]>();
        map.put(Catalog.wood, new Integer[] {5, 12});
        map.put(Catalog.wood, new Integer[] {5, 12});
        return map;
    }

    @Override
    public Map<Animal, Integer[]> getFauna() {
        Map<Animal, Integer[]> map = new HashMap<Animal, Integer[]>();
        return map;
    }

}
