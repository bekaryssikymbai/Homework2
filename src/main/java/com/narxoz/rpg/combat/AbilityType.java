package com.narxoz.rpg.combat;


public enum AbilityType {
    DAMAGE("Damage"),
    BUFF("Buff"),
    DEBUFF("Debuff"),
    ULTIMATE("Ultimate"),
    DEFENSIVE("Defensive");

    private final String displayName;

    AbilityType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}