package com.narxoz.rpg.combat;

public class Vanish extends AbstractAbility {

    public Vanish() {
        super("Vanish", 0,
                "Disappears into the shadows, avoiding all attacks",
                AbilityType.DEFENSIVE);
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}