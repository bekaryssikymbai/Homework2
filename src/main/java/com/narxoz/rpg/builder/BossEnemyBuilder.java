package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element = "NONE";
    private String aiBehavior = "AGGRESSIVE";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private Map<Integer, Integer> phases = new HashMap<>();
    private boolean canFly = false;
    private boolean hasBreathAttack = false;
    private int wingspan = 0;

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
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) { this.phases.put(phaseNumber, healthThreshold); return this; }
    public EnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public EnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    public Enemy build() {
        if (name == null || name.trim().isEmpty())
            throw new IllegalStateException("Boss name required!");
        if (health <= 0)
            throw new IllegalStateException("Health must be positive!");
        return new DragonBoss(name, health, damage, defense, speed, element,
                aiBehavior, abilities, lootTable, phases,
                canFly, hasBreathAttack, wingspan);
    }
}