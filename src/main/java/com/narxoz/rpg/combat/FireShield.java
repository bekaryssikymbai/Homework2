package com.narxoz.rpg.combat;


public class FireShield extends AbstractAbility {

    public FireShield() {
        super("Fire Shield", 0,
                "Creates a shield of fire that damages attackers",
                AbilityType.DEFENSIVE);
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}