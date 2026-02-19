package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.combat.ShadowStrike;

public class TestPrototype {
    public static void main(String[] args) {
        System.out.println("=== TESTING PROTOTYPE PATTERN ===\n");

        // Создаем фабрики
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        // Создаем реестр
        EnemyRegistry registry = new EnemyRegistry();

        //  Создаем и регистрируем шаблоны
        System.out.println("--- Creating Base Templates ---");

        // Базовый гоблин
        EnemyBuilder basicBuilder = new BasicEnemyBuilder();
        Enemy baseGoblin = basicBuilder
                .setName("Base Goblin")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(35)
                .setElement("NONE")
                .setAI("BASIC")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .build();

        registry.registerTemplate("goblin", baseGoblin);
        System.out.println("Registered: goblin");

        // Базовый дракон
        EnemyBuilder bossBuilder = new BossEnemyBuilder();
        Enemy baseDragon = bossBuilder
                .setName("Base Dragon")
                .setHealth(5000)
                .setDamage(250)
                .setDefense(150)
                .setSpeed(50)
                .setElement("FIRE")
                .setAI("AGGRESSIVE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .addPhase(1, 5000)
                .addPhase(2, 3000)
                .addPhase(3, 1500)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(40)
                .build();

        registry.registerTemplate("dragon", baseDragon);
        System.out.println("Registered: dragon");

        // Базовый скелет
        Enemy baseSkeleton = basicBuilder
                .setName("Base Skeleton")
                .setHealth(80)
                .setDamage(20)
                .setDefense(3)
                .setSpeed(25)
                .setElement("NONE")
                .setAI("BASIC")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .build();

        registry.registerTemplate("skeleton", baseSkeleton);
        System.out.println("Registered: skeleton\n");

        registry.listTemplates();
        System.out.println();

        // ЧАСТЬ 2: Варианты сложности
        System.out.println("--- Difficulty Variants (Goblin) ---");

        Enemy normalGoblin = registry.createFromTemplate("goblin");
        System.out.println("Normal Goblin - Health: " + normalGoblin.getHealth());

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        System.out.println("Elite Goblin (2x) - Health: " + eliteGoblin.getHealth());

        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.addAbility(new ShadowStrike());
        System.out.println("Champion Goblin (5x) - Health: " + championGoblin.getHealth()
                + ", Abilities: " + championGoblin.getAbilities().size());
        System.out.println();

        // ЧАСТЬ 3: Элементальные варианты
        System.out.println("--- Elemental Variants (Dragon) ---");

        Enemy fireDragon = registry.createFromTemplate("dragon");
        System.out.println("Fire Dragon - Element: " + fireDragon.getElement());

        Enemy iceDragon = registry.createFromTemplate("dragon");
        iceDragon.setElement("ICE");
        iceDragon.setAbilities(iceFactory.createAbilities());
        iceDragon.setAI(iceFactory.createAIBehavior());
        iceDragon.setLootTable(iceFactory.createLootTable());
        System.out.println("Ice Dragon - Element: " + iceDragon.getElement()
                + ", AI: " + iceDragon.getAIBehavior());

        Enemy shadowDragon = registry.createFromTemplate("dragon");
        shadowDragon.setElement("SHADOW");
        shadowDragon.setAbilities(shadowFactory.createAbilities());
        shadowDragon.setAI(shadowFactory.createAIBehavior());
        shadowDragon.setLootTable(shadowFactory.createLootTable());
        System.out.println("Shadow Dragon - Element: " + shadowDragon.getElement()
                + ", AI: " + shadowDragon.getAIBehavior());
        System.out.println();

        // ЧАСТЬ 4: Проверка глубокого копирования
        System.out.println("--- Deep Copy Verification ---");

        Enemy original = registry.createFromTemplate("skeleton");
        Enemy clone = original.clone();

        System.out.println("Original abilities: " + original.getAbilities().size());

        clone.addAbility(new ShadowStrike());

        System.out.println("Clone abilities after adding: " + clone.getAbilities().size());
        System.out.println("Original abilities after clone modified: " + original.getAbilities().size());

        if (original.getAbilities().size() != clone.getAbilities().size()) {
            System.out.println("✓ DEEP COPY WORKS! Original unchanged.");
        } else {
            System.out.println("✗ Shallow copy detected!");
        }
        System.out.println();

        // ЧАСТЬ 5: Массовое производство
        System.out.println("--- Mass Production Demo ---");
        System.out.println("Creating 5 Elite Goblins:");

        for (int i = 1; i <= 5; i++) {
            Enemy goblin = registry.createFromTemplate("goblin");
            goblin.multiplyStats(2.0);
            System.out.println("  Elite Goblin " + i + " - Health: " + goblin.getHealth());
        }

        System.out.println("\n=== Prototype Pattern Test Complete ===");
    }
}