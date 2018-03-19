package com.mowitnow.tondeuse.model;

public class Position {
    private int positionX;
    private int positionY;
    private Direction orientation;

    public Position(int positionX, int positionY, Direction orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "" + positionX + positionY + orientation.getShortName();
    }
}
