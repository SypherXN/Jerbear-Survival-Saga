package adventure;

import adventure.item.Item;

public class InvDoesNotContainItemException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public final Item item;
    
    public InvDoesNotContainItemException(Item i) {
        this.item = i;
    }

}
