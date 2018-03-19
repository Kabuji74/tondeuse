package com.mowitnow.tondeuse.model;

public enum Direction {

    NORD("N", 0),
    EST("E", 1),
    SUD("S", 2),
    OUEST("W", 3);

    Direction(String shortName, int ordinal){
        this.shortName = shortName;
        this.ordinal=ordinal;
    }

    private int ordinal;
    private String shortName;

    public int getOrdinal() {
        return this.ordinal;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public static  Direction fromShortName(String shortName) {
        for (Direction direction : values()) {
            if (direction.shortName.equals(shortName)) {
                return direction;
            }
        }

        return null;
    }

    public Direction rotated90RightDirection() {
        return values()[(getOrdinal() + 1) % 4];
    }

    public Direction rotated90LeftDirection() {
        return values()[(getOrdinal() + 3) % 4];
    }
}