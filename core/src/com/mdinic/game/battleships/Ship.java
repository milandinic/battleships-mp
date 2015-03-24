package com.mdinic.game.battleships;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    List<Coordinate> coordinates = new ArrayList<Coordinate>();

    boolean isLost() {
        for (Coordinate c : coordinates) {
            if (!c.hit) {
                return false;
            }

        }
        return true;
    }

}
