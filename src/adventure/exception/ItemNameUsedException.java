package adventure.exception;

import adventure.item.Item;

public class ItemNameUsedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public final String name;
    public final Item item;
    
    public ItemNameUsedException(String name, Item item) {
        super(String.format("Item name %s has been taken, redefine item %s.", name, item));
        this.name = name;
        this.item = item;
    }

}
