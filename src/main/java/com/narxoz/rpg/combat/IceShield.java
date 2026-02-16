package com.narxoz.rpg.combat;

public class IceShield extends AbstractAbility {

    public IceShield() {
        super("Ice Shield", 0,
                "Creates a shield of ice that reduces incoming damage",
                AbilityType.DEFENSIVE);
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}
