package adventure;

import java.util.HashMap;

@SuppressWarnings("serial")
public enum Location {
    
    BEACH   ("beach", 
            new HashMap<Item, Integer[]>() {{
                put(Catalog.wood, new Integer[] {1, 4});
            }},
            new HashMap<Animal, Float>() {{
            }}
    ),
    JUNGLE  ("jungle",
            new HashMap<Item, Integer[]>() {{
                put(Catalog.wood, new Integer[] {4, 10});
                put(Catalog.weed, new Integer[] {5, 15});
            }},
            new HashMap<Animal, Float>() {{
            }}
    ),
    RUINS   ("ruins",
            new HashMap<Item, Integer[]>() {{
            }},
            new HashMap<Animal, Float>() {{
            }}
    ),
    LAKE    ("lake",
            new HashMap<Item, Integer[]>() {{
            }},
            new HashMap<Animal, Float>() {{
            }}
    );
    
    public final String name;
    public final HashMap<Item, Integer[]> resources;
    public final HashMap<Animal, Float> animals;
    public final boolean hidden;
    
    Location(String name, HashMap<Item, Integer[]> items, HashMap<Animal, Float> animals) {
        this(name, items, animals, true);
    }
    
    Location(String name, HashMap<Item, Integer[]> items, HashMap<Animal, Float> animals, boolean hidden) {
        this.name = name;
        this.resources = items;
        this.animals = animals;
        this.hidden = hidden;
    }

}
