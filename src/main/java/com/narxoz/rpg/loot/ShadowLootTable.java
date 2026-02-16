package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ShadowLootTable extends AbstractLootTable {

    private static final List<String> SHADOW_ITEMS = Arrays.asList(
            "Shadow Gem",
            "Dark Essence",
            "Shadow Rune",
            "Void Crystal",
            "Soul Shard"
    );

    public ShadowLootTable() {
        super("Shadow Loot Table", SHADOW_ITEMS, 600, 1100);
    }

    private ShadowLootTable(String name, List<String> items, int goldDrop, int experienceDrop) {
        super(name, items, goldDrop, experienceDrop);
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(
                this.name,
                new ArrayList<>(this.items),
                this.goldDrop,
                this.experienceDrop
        );
    }
}