package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.utils.Array;

public class GameMap {

    Array<Ship> ships = new Array<Ship>();

    final Sounds sounds;

    public GameMap(Sounds sounds) {
        this.sounds = sounds;
    }

    public void update(float deltaTime) {

        // ship.update(deltaTime);
        //
        // for (Asteroid a : ships) {
        // a.update(deltaTime);
        // }
        // if (giana.state == GianaState.DEAD)
        // return;

        // for (Diamond diamond : diamonds) {
        // diamond.update(deltaTime);
        // }

    }
}
