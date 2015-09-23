package adventure;

import java.util.Random;

public class RangedWeapon extends Item {
    
    public static final Random random = new Random();
    public static final float CRITCHANCE = 0.3f;
    public static final float CRITMULTI = 3f;
    Item ammo;

    public RangedWeapon(String name, String desc, float weight, float volume, float damage, Item ammo) {
        super(name, desc, weight, damage);
        this.ammo = ammo;
    }
    
    @Override
    public boolean attack(Player player, Animal animal) {
        if (!player.inventory.remove(ammo)) {
            return false;
        }
        if (random.nextFloat() < CRITCHANCE) {
            animal.hp -= CRITMULTI * damage;
        } else {
            animal.hp -= damage;
        }
        return true;
    }
    
}
