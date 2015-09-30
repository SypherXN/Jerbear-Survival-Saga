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
    
    /**
     * Animals that you can find using track.
     * @return A mapping of animals to the chance of finding one using track.
     */
    public abstract Map<Animal, Float> getFauna();
    
    /**
     * Animals that can ambush you while you do stuff.
     * @return A mapping of animals to the chance of getting ambushed per hour.
     */
    public abstract Map<Animal, Float> getPredators();
    
    public abstract boolean hasWater();
    
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

    public float get(Animal animal) {
        return getFauna().get(animal);
    }
    
}
