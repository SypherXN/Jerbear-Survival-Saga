package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.item.Item;

public class Anim4Chainz extends Animal {

    @Override
    public String getName() {
        return "4Chainz the robot";
    }

    @Override
    public String getDesc() {
        return "It was used for picking up recycling, now it's used for murdering people.";
    }

    @Override
    public float getHealth() {
        return 10f;
    }

    @Override
    public float getDamage() {
        return 10f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        map.put(Game.iPcb, 2);
        map.put(Game.iIron, 3);
        return map;
    }

}
