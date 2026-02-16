package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractLootTable implements LootTable {

    protected String name;
    protected List<String> items;
    protected int goldDrop;
    protected int experienceDrop;

    public AbstractLootTable(String name, List<String> items, int goldDrop, int experienceDrop) {
        this.name = name;
        this.items = new ArrayList<>(items);  // Defensive copy
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);  // Return copy to preserve encapsulation
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public String toString() {
        return String.format("%s: %d gold, %d XP, items: %s",
                name, goldDrop, experienceDrop, items);
    }

    @Override
    public abstract LootTable clone();
}