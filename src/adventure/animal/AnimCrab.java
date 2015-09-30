package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.item.Item;

public class AnimCrab extends Animal {

    @Override
    public String getName() {
        return "Crab";
    }

    @Override
    public String getDesc() {
        return "Snappyface";
    }

    @Override
    public float getHealth() {
        return 5f;
    }

    @Override
    public float getDamage() {
        return 0f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        map.put(Game.iRcrab, 1);
        return map;
    }

}
