package com.mdinic.game.battleships;

public class Coordinate {

    int x;
    int y;

    boolean hit;

    public Coordinate() {
        super();
    }

    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
