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
            }},
            new HashMap<Animal, Float>() {{
            }}
    ),
    RUINS   ("ruins",
            new HashMap<Item, Integer[]>() {{
                put(Catalog.wood, new Integer[] {1, 4});
            }},
            new HashMap<Animal, Float>() {{
            }}
    ),
    LAKE    ("lake",
            new HashMap<Item, Integer[]>() {{
                put(Catalog.wood, new Integer[] {1, 4});
            }},
            new HashMap<Animal, Float>() {{
            }}
    );
    
    final String name;
    final HashMap<Item, Integer[]> resources;
    final HashMap<Animal, Float> animals;
    
    Location(String name, HashMap<Item, Integer[]> items, HashMap<Animal, Float> animals) {
        this.name = name;
        this.resources = items;
        this.animals = animals;
    }

}
