package adventure.location;

import java.util.Map;

import adventure.Animal;
import adventure.item.Item;

public abstract class Location {
    
    private boolean hidden;
    
    public Location() {
        setHidden(getHiddenAtFirst());
    }
    
    public abstract String getName();
    
    public abstract Map<Item, Integer[]> getResources();
    
    public abstract Map<Animal, Integer[]> getFauna();
    
    public boolean getHiddenAtFirst() {
        return false;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    
    public Integer[] get(Item item) {
        return getResources().get(item);
    }

    public Integer[] get(Animal animal) {
        return getFauna().get(animal);
    }

}
