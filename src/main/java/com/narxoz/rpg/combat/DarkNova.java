package com.narxoz.rpg.combat;

public class DarkNova extends AbstractAbility {

    public DarkNova() {
        super("Dark Nova", 180,
                "Explodes with dark energy, devastating all nearby enemies",
                AbilityType.ULTIMATE);
    }

    @Override
    public Ability clone() {
        return new DarkNova();
    }
}