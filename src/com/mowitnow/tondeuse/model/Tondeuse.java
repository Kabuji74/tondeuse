package com.mowitnow.tondeuse.model;

public class Tondeuse {
    private Position position;

    public Tondeuse(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("position must not be null");
        }
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
