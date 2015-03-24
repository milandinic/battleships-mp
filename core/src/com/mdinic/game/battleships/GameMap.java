package com.mdinic.game.battleships;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;

public class GameMap {

    static int SCENE_HEIGHT = 30;
    static int SCENE_WIDTH = 40;
    static int MAP_LENGTH = 300;

    static int LEVEL_PIXELBUFFER = 30;

    static int EMPTY = 0;
    static int TILE = 0xffffff;

    static int START = 0xff0000;
    static int ASTEROID = 0xf4f8f2;

    List<Integer> colidableColors = new ArrayList<Integer>();

    // pixel on 0,0 position
    // background color
    public float r; // 0.0-1.0
    public float g; // 0.0-1.0
    public float b; // 0.0-1.0

    public int lives = 3;
    public int level;
    public int score;

    public boolean demo = false;

    Array<Ship> ships = new Array<Ship>();
    // Array<CollidableGfxItem> collidableItems = new
    // Array<CollidableGfxItem>();

    int pixmapHeight;
    final Sounds sounds;
    Ship ship;

    public GameMap(GameMap oldMap) {
        this(oldMap.level, oldMap.sounds);

        this.lives = oldMap.lives;
        this.score = oldMap.score;
        // this.sounds = oldMap.sounds;
    }

    public GameMap(int level, Sounds sounds) {
        this.level = level;
        this.sounds = sounds;
        loadBinary(level, "levels");
        // colidableColors.add(TREAT_BOX_DIAMOND);

    }

    public boolean isColidable(int value) {
        return false;// colidableColors.contains(value) ||
                     // SimpleImageType.containsColor(value) != null;
    }

    public void loadBinary(int level, String filename) {
        Pixmap pixmap = new Pixmap(Gdx.files.internal(filename + ".png"));

        // background color
        int pix = LevelConf.values()[level].getBackgroundColor();

        // (pixmap.getPixel(0, level * LEVEL_PIXELBUFFER) >>> 8) & 0xffffff;
        r = (pix & 0xff0000) >>> 16;
        g = (pix & 0x00ff00) >>> 8;
        b = (pix & 0x0000ff);

        r /= 255f;
        g /= 255f;
        b /= 255f;
        pixmapHeight = pixmap.getHeight();

        for (int y = 0; y < SCENE_HEIGHT; y++) {

            for (int x = 0; x < MAP_LENGTH; x++) {
                pix = (pixmap.getPixel(x, y + (level * LEVEL_PIXELBUFFER)) >>> 8) & 0xffffff;
                int newY = pixmapHeight - 1 - y;
                if (match(pix, START)) {
                    // ship = new Ship(this, x, newY);
                    // System.out.println("start");
                    // collidableItems.add(ship);
                } else if (match(pix, ASTEROID)) {
                    // Asteroid asteroid = new Asteroid(this, x, newY);
                    // ships.add(asteroid);
                    // collidableItems.add(asteroid);
                }
            }
        }
    }

    boolean match(int src, int dst) {
        return src == dst;
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

    public boolean isDeadly(int tileId) {
        // return FixedTrapType.containsColor(tileId) != null;
        return false;
    }
}
