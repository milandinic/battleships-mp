package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GfxItem {

    Vector2 pos = new Vector2();
    Rectangle bounds = new Rectangle();

    float stateTime = 0;

    float rotation = 0;

    public GfxItem(float x, float y) {
        pos.x = x;
        pos.y = y;

        bounds.width = 1f;
        bounds.height = 1f;
        bounds.x = pos.x;
        bounds.y = pos.y;
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
    }

    public int getColor() {
        return 0;
    }

}
