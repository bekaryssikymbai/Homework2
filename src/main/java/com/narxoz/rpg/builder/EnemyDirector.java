package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory, String baseName) {
        return builder.setName(baseName + " Minion").setHealth(50).setDamage(10)
                .setDefense(2).setSpeed(20).setElement("NONE").setAI("BASIC")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable()).build();
    }

    public Enemy createElite(EnemyComponentFactory factory, String baseName) {
        return builder.setName(baseName + " Elite").setHealth(150).setDamage(30)
                .setDefense(10).setSpeed(30).setElement("NONE").setAI("AGGRESSIVE")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable()).build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory, String baseName) {
        return builder.setName(baseName + " Mini-Boss").setHealth(500).setDamage(60)
                .setDefense(25).setSpeed(40).setAI("AGGRESSIVE")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable()).build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory, String baseName) {
        if (builder instanceof BossEnemyBuilder) {
            BossEnemyBuilder b = (BossEnemyBuilder) builder;
            return b.setName(baseName + " Raid Boss").setHealth(10000).setDamage(300)
                    .setDefense(100).setSpeed(60).setAI(factory.createAIBehavior())
                    .setAbilities(factory.createAbilities())
                    .setLootTable(factory.createLootTable())
                    .addPhase(1, 10000).addPhase(2, 6000).addPhase(3, 3000)
                    .setCanFly(true).setHasBreathAttack(true).setWingspan(50).build();
        }
        return createMiniBoss(factory, baseName + " Raid");
    }

    public void setBuilder(EnemyBuilder builder) { this.builder = builder; }
}