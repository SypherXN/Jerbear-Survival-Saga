package adventure.exception;

import adventure.location.Location;

public class LocationNameUsedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public final String name;
    public final Location location;
    
    public LocationNameUsedException(String name, Location location) {
        super(String.format("Location name %s has been taken, redefine location %s.", location, name));
        this.name = name;
        this.location = location;
    }

}
