package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class IceLootTable extends AbstractLootTable {

    private static final List<String> ICE_ITEMS = Arrays.asList(
            "Ice Gem",
            "Frost Scale",
            "Ice Rune",
            "Permafrost Shard",
            "Yeti Fur"
    );

    public IceLootTable() {
        super("Ice Loot Table", ICE_ITEMS, 450, 950);
    }

    private IceLootTable(String name, List<String> items, int goldDrop, int experienceDrop) {
        super(name, items, goldDrop, experienceDrop);
    }

    @Override
    public LootTable clone() {
        return new IceLootTable(
                this.name,
                new ArrayList<>(this.items),
                this.goldDrop,
                this.experienceDrop
        );
    }
}