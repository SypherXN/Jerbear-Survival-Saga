package adventure.exception;

import adventure.animal.Animal;

public class AnimalNameUsedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public final String name;
    public final Animal animal;
    
    public AnimalNameUsedException(String name, Animal animal) {
        super(String.format("Animal name %s has been taken, redefine animal %s.", name, animal));
        this.name = name;
        this.animal = animal;
    }

}
