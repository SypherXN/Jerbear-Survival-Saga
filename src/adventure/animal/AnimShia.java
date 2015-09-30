package adventure.animal;

import java.util.HashMap;
import java.util.Map;

import adventure.Game;
import adventure.item.Item;

public class AnimShia extends Animal {

    @Override
    public String getName() {
        return "Actual Cannibal Shia LaBeouf";
    }

    @Override
    public String getDesc() {
        return "Running from your life,\n"
                + "FROM SHIA LABEOUF!\n"
                + "He's brandishing a knife,\n"
                + "IT'S SHIA LABEOUF!";
    }

    @Override
    public float getHealth() {
        return 100f;
    }

    @Override
    public float getDamage() {
        return 25f;
    }

    @Override
    public Map<Item, Integer> getLoot() {
        Map<Item, Integer> map = new HashMap<Item, Integer>();
        map.put(Game.iKnife, 2);
        return map;
    }

}
