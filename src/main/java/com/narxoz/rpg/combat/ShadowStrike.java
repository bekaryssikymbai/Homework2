package com.narxoz.rpg.combat;

public class ShadowStrike extends AbstractAbility {

    public ShadowStrike() {
        super("Shadow Strike", 90,
                "Strikes from the shadows, dealing high damage and blinding the target",
                AbilityType.DAMAGE);
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}