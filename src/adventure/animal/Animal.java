package adventure.animal;

import java.util.Map;

import adventure.item.Item;

public abstract class Animal {

    public abstract String getName();
    
    public abstract String getDesc();
    
    public abstract float getHealth();

    public abstract float getDamage();

    public abstract Map<Item, Integer> getLoot();

    public boolean equals(Object other) {
        if (other instanceof Animal) {
            Animal animal = (Animal) other;
            return 
                    animal.getHealth() == this.getHealth()  && 
                    animal.getDamage() == this.getDamage()  && 
                    animal.getName().equals(this.getName()) &&
                    animal.getDesc().equals(this.getDesc());
        }
        return false;
    }
    
    public String toString() {
        return String.format("Animal(name=%s, hp=%s, dmg=%s)", getName(), getHealth(), getDamage());
    }

}
