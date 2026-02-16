package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FireLootTable extends AbstractLootTable {

    private static final List<String> FIRE_ITEMS = Arrays.asList(
            "Fire Gem",
            "Dragon Scale",
            "Flame Rune",
            "Burning Ember",
            "Phoenix Feather"
    );

    public FireLootTable() {
        super("Fire Loot Table", FIRE_ITEMS, 500, 1000);
    }


    private FireLootTable(String name, List<String> items, int goldDrop, int experienceDrop) {
        super(name, items, goldDrop, experienceDrop);
    }

    @Override
    public LootTable clone() {

        return new FireLootTable(
                this.name,
                new ArrayList<>(this.items),
                this.goldDrop,
                this.experienceDrop
        );
    }
}