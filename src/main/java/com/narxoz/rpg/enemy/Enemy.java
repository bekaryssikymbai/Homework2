package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();
    String getAIBehavior();
    List<Ability> getAbilities();
    LootTable getLootTable();
    boolean hasPhases();
    int getCurrentPhase();
    void displayInfo();
    Enemy clone();
    void multiplyStats(double multiplier);
    void addAbility(Ability ability);
    void setElement(String element);
    void setAbilities(List<Ability> abilities);
    void setAI(String aiBehavior);
    void setLootTable(LootTable lootTable);
}