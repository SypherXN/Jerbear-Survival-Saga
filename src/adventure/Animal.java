package adventure;

public class Animal {
    
    public final String name;
    public final float hp, damage;
    
    public Animal(String name, float hp, float damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    
    public boolean equals(Object other) {
        if (other instanceof Animal) {
            Animal animal = (Animal) other;
            return animal.hp == this.hp && animal.damage == this.damage && animal.name.equals(this.name);
        }
        return false;
    }
    
    public String toString() {
        return String.format("Animal(%s, %s, %s)", name, hp, damage);
    }

}
