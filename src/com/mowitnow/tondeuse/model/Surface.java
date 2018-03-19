package com.mowitnow.tondeuse.model;

public class Surface {
    private int topRightCornerX;
    private int topRightCornerY;

    public Surface(int topRightCornerX, int topRightCornerY) {
        this.topRightCornerX = topRightCornerX;
        this.topRightCornerY = topRightCornerY;
    }

    public int getTopRightCornerY() {
        return topRightCornerY;
    }

    public int getTopRightCornerX() {
        return topRightCornerX;
    }

}
