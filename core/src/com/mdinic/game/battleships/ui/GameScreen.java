package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen extends ScreenBase {

    GameMap map;

    boolean stopMusic = true;
    boolean fromBonus = false;

    ShapeRenderer shape = new ShapeRenderer();
    boolean paused = false;

    public GameScreen(Game game, GameMap oldMap, MapRenderer renderer) {
        super(game, renderer);
        map = oldMap;
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {

                if (keycode == Keys.BACK) {
                    if (paused) {
                        // getGame().getGeneralService().showConfirmExitDialog();
                    } else {
                        paused = true;
                        pause();
                        return false;
                    }
                }
                return false;
            }
        });
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {

        delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
        if (delta > 0) {
            map.update(delta);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render(delta);

        // if (map.ship.pos.x >= GameMap.MAP_LENGTH) {
        // getGame().setScreen(new GameScreen(getGame(), new GameMap(0,
        // map.sounds), renderer));
        // }

    }

    @Override
    public void resume() {
        // Music music = map.sounds.getCurrentMusic();
        // if (music != null) {
        // music.play();
        // }
    }

    @Override
    public void pause() {
        // Music music = map.sounds.getCurrentMusic();
        // if (music != null) {
        // music.pause();
        // }
    }

    @Override
    public void hide() {
        Gdx.app.debug("GianaSisters", "dispose game screen");
        // if (stopMusic)
        // map.sounds.stop(LevelConf.values()[map.level].getMusic());

    }

}
