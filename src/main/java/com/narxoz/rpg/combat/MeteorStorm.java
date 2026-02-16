package com.narxoz.rpg.combat;
public class MeteorStorm extends AbstractAbility {

    public MeteorStorm() {
        super("Meteor Storm", 200,
                "Calls down meteors from the sky, devastating all enemies",
                AbilityType.ULTIMATE);
    }

    @Override
    public Ability clone() {
        return new MeteorStorm();
    }
}