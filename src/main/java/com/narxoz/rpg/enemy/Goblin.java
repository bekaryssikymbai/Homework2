package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class Goblin extends AbstractEnemy {

    public Goblin(String name) {
        super(name, 100, 15, 5, 35, "NONE", "BASIC", new ArrayList<>(), null);
    }

    public Goblin(String name, int health, int damage, int defense, int speed,
                  String element, String aiBehavior,
                  List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, element, aiBehavior,
                abilities, lootTable);
    }

    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());

        LootTable clonedLoot = this.lootTable != null ? this.lootTable.clone() : null;

        return new Goblin(name, health, damage, defense, speed,
                element, aiBehavior, clonedAbilities, clonedLoot);
    }
}