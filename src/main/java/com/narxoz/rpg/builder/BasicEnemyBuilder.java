package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element = "NONE";
    private String aiBehavior = "BASIC";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    public EnemyBuilder setName(String name) { this.name = name; return this; }
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    public EnemyBuilder setElement(String element) { this.element = element; return this; }
    public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }
    public EnemyBuilder addAbility(Ability ability) { this.abilities.add(ability); return this; }
    public EnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = new ArrayList<>(abilities); return this; }
    public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) { return this; }
    public EnemyBuilder setCanFly(boolean canFly) { return this; }
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { return this; }
    public EnemyBuilder setWingspan(int wingspan) { return this; }

    public Enemy build() {
        if (name == null || name.trim().isEmpty())
            throw new IllegalStateException("Name required!");
        if (health <= 0)
            throw new IllegalStateException("Health must be positive!");
        return new Goblin(name, health, damage, defense, speed,
                element, aiBehavior, abilities, lootTable);
    }
}