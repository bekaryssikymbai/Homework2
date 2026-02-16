package com.narxoz.rpg;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

public class TestPhase3 {
    static void main(String[] args) {
        System.out.println("=== Testing Phase 3: Abilities and Loot Tables ===\n");

        System.out.println("--- Fire Abilities ---");
        Ability flameBreath = new FlameBreath();
        Ability fireShield = new FireShield();
        Ability meteorStorm = new MeteorStorm();

        System.out.println(flameBreath);
        System.out.println(fireShield);
        System.out.println(meteorStorm);


        System.out.println("\n--- Ice Abilities ---");
        Ability frostBreath = new FrostBreath();
        Ability iceShield = new IceShield();
        Ability blizzard = new Blizzard();

        System.out.println(frostBreath);
        System.out.println(iceShield);
        System.out.println(blizzard);


        System.out.println("\n--- Shadow Abilities ---");
        Ability shadowStrike = new ShadowStrike();
        Ability vanish = new Vanish();
        Ability darkNova = new DarkNova();

        System.out.println(shadowStrike);
        System.out.println(vanish);
        System.out.println(darkNova);

        System.out.println("\n--- Loot Tables ---");
        LootTable fireLoot = new FireLootTable();
        LootTable iceLoot = new IceLootTable();
        LootTable shadowLoot = new ShadowLootTable();

        System.out.println(fireLoot);
        System.out.println(iceLoot);
        System.out.println(shadowLoot);


        System.out.println("\n--- Testing Clone (Deep Copy) ---");
        LootTable fireLootClone = fireLoot.clone();
        System.out.println("Original: " + fireLoot);
        System.out.println("Clone:    " + fireLootClone);

        System.out.println("\n✓ Phase 3 foundation complete!");
    }
}