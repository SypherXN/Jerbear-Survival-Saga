package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.item.Item;

public class AnimBear extends Animal {

    @Override
    public String getName() {
        return "Bear";
    }

    @Override
    public String getDesc() {
        return "Jer-bear";
    }

    @Override
    public float getHealth() {
        return 80f;
    }

    @Override
    public float getDamage() {
        return 50f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        return map;
    }

}
