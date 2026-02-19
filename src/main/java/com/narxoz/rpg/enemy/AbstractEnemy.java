package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEnemy implements Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected String aiBehavior;
    protected List<Ability> abilities;
    protected LootTable lootTable;

    public AbstractEnemy(String name, int health, int damage, int defense,
                         int speed, String element, String aiBehavior,
                         List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.aiBehavior = aiBehavior;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.lootTable = lootTable;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public String getElement() { return element; }
    public String getAIBehavior() { return aiBehavior; }
    public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    public LootTable getLootTable() { return lootTable; }
    public boolean hasPhases() { return false; }
    public int getCurrentPhase() { return 1; }

    public void multiplyStats(double multiplier) {
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
        this.speed = (int)(this.speed * multiplier);
    }

    public void addAbility(Ability ability) {
        if (ability != null) this.abilities.add(ability);
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
    }

    public void setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " dmg: " + a.getDamage());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getName());
        }
    }

    public abstract Enemy clone();
}