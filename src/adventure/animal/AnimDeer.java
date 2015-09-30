package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.item.Item;

public class AnimDeer extends Animal {

    @Override
    public String getName() {
        return "Deer";
    }

    @Override
    public String getDesc() {
        return "Doe, a deer";
    }

    @Override
    public float getHealth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        return map;
    }

}
