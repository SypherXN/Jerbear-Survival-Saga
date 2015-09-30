package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.item.Item;

public class AnimChicken extends Animal {

    @Override
    public String getName() {
        return "Chicken";
    }

    @Override
    public String getDesc() {
        return "Bok bok bok";
    }

    @Override
    public float getHealth() {
        return 10f;
    }

    @Override
    public float getDamage() {
        return 0f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        map.put(Game.iRchicken, 1);
        return map;
    }

}
