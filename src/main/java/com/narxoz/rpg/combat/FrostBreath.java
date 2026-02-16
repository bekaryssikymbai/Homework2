package com.narxoz.rpg.combat;

public class FrostBreath extends AbstractAbility {

    public FrostBreath() {
        super("Frost Breath", 60,
                "Breathes freezing air, dealing damage and slowing enemies",
                AbilityType.DAMAGE);
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}