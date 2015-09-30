package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.item.Item;

public class AnimWolf extends Animal {

    @Override
    public String getName() {
        return "Wolf";
    }

    @Override
    public String getDesc() {
        return "Woof, I'm a dog";
    }

    @Override
    public float getHealth() {
        return 25f;
    }

    @Override
    public float getDamage() {
        return 20f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        return map;
    }

}
