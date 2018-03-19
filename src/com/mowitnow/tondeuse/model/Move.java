package com.mowitnow.tondeuse.model;

public enum Move {
    AVANCE('A'),
    DROITE('D'),
    GAUCHE('G');

    private Character shortName;

    Move(Character shortName) {
        this.shortName = shortName;
    }

    public static Move fromShortName(Character shortName) {
        for (Move move : Move.values()) {
            if (move.shortName.equals(shortName)) {
                return move;
            }
        }
        return null;
    }

}
