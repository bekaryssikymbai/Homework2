package com.narxoz.rpg.combat;


public abstract class AbstractAbility implements Ability {

    protected String name;
    protected int damage;
    protected String description;
    protected AbilityType type;

    public AbstractAbility(String name, int damage, String description, AbilityType type) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public AbilityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - %d damage: %s",
                name, type.getDisplayName(), damage, description);
    }

    @Override
    public abstract Ability clone();
}