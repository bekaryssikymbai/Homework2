package com.narxoz.rpg.factory;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class TestFactories {
    public static void main(String[] args) {
        System.out.println("=== TESTING ABSTRACT FACTORIES ===\n");


        System.out.println("--- Fire Component Factory ---");
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        testFactory(fireFactory, "FIRE");


        System.out.println("\n--- Ice Component Factory ---");
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        testFactory(iceFactory, "ICE");


        System.out.println("\n--- Shadow Component Factory ---");
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        testFactory(shadowFactory, "SHADOW");
    }

    private static void testFactory(EnemyComponentFactory factory, String theme) {
        System.out.println("Theme: " + theme);
        System.out.println("AI Behavior: " + factory.createAIBehavior());


        List<Ability> abilities = factory.createAbilities();
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() +
                    " [" + ability.getType().getDisplayName() +
                    "] dmg: " + ability.getDamage());
        }


        LootTable loot = factory.createLootTable();
        System.out.println("Loot Table: " + loot.getName());
        System.out.println("  Gold: " + loot.getGoldDrop());
        System.out.println("  XP: " + loot.getExperienceDrop());
        System.out.println("  Items: " + loot.getItems());
    }
}