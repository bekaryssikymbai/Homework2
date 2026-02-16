package com.narxoz.rpg.combat;

public class FlameBreath extends AbstractAbility {

    public FlameBreath() {
        super("Flame Breath", 75,
                "Breathes fire, dealing AoE damage and burning enemies",
                AbilityType.DAMAGE);
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}
