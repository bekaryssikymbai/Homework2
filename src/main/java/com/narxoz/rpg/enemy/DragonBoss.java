package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss extends AbstractEnemy {
    private Map<Integer, Integer> phases;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    private int currentPhase;

    // ИСПРАВЛЕНО: добавил public
    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, String aiBehavior, List<Ability> abilities,
                      LootTable lootTable, Map<Integer, Integer> phases,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {
        super(name, health, damage, defense, speed, element, aiBehavior,
                abilities, lootTable);
        this.phases = phases != null ? new HashMap<>(phases) : new HashMap<>();
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
        this.currentPhase = 1;
    }

    // остальной код без изменений...
    public boolean hasPhases() { return phases != null && !phases.isEmpty(); }
    public int getCurrentPhase() { return currentPhase; }
    public boolean canFly() { return canFly; }
    public boolean hasBreathAttack() { return hasBreathAttack; }
    public int getWingspan() { return wingspan; }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Boss: Fly=" + canFly + " Breath=" + hasBreathAttack
                + " Wingspan=" + wingspan);
        if (hasPhases()) {
            System.out.println("Phases: " + phases.size());
        }
    }

    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());

        LootTable clonedLoot = this.lootTable != null ? this.lootTable.clone() : null;
        Map<Integer, Integer> clonedPhases = new HashMap<>(this.phases);

        return new DragonBoss(name, health, damage, defense, speed, element,
                aiBehavior, clonedAbilities, clonedLoot, clonedPhases,
                canFly, hasBreathAttack, wingspan);
    }
}