package com.narxoz.rpg.combat;

public class Blizzard extends AbstractAbility {

    public Blizzard() {
        super("Blizzard", 150,
                "Summons a fierce snowstorm, damaging all enemies over time",
                AbilityType.ULTIMATE);
    }

    @Override
    public Ability clone() {
        return new Blizzard();
    }
}