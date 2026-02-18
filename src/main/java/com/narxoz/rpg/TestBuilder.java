package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.*;

public class TestBuilder {
    public static void main(String[] args) {
        System.out.println("=== TESTING BUILDER PATTERN ===\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        // Test Basic Builder
        System.out.println("--- Basic Builder ---");
        EnemyBuilder basicBuilder = new BasicEnemyBuilder();
        Enemy goblin = basicBuilder.setName("Forest Goblin").setHealth(100)
                .setDamage(15).setDefense(5).setSpeed(35)
                .addAbility(fireFactory.createAbilities().get(0))
                .setLootTable(fireFactory.createLootTable()).build();
        goblin.displayInfo();
        System.out.println();

        // Test Boss Builder
        System.out.println("--- Boss Builder ---");
        EnemyBuilder bossBuilder = new BossEnemyBuilder();
        Enemy dragon = bossBuilder.setName("Fire Dragon").setHealth(5000)
                .setDamage(250).setDefense(150).setSpeed(50).setElement("FIRE")
                .setAI("AGGRESSIVE").setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .addPhase(1, 5000).addPhase(2, 3000).addPhase(3, 1500)
                .setCanFly(true).setHasBreathAttack(true).setWingspan(40).build();
        dragon.displayInfo();
        System.out.println();

        // Test Director
        System.out.println("--- Director ---");
        EnemyDirector director = new EnemyDirector(new BasicEnemyBuilder());
        Enemy minion = director.createMinion(fireFactory, "Fire");
        minion.displayInfo();
        System.out.println();

        director.setBuilder(new BossEnemyBuilder());
        Enemy raidBoss = director.createRaidBoss(shadowFactory, "Shadow");
        raidBoss.displayInfo();
    }
}