package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mdinic.game.battleships.BattleShipsMultiplayerGame;

public abstract class ScreenBase implements Screen {

    protected final Game game;
    protected final MapRenderer renderer;

    public static final int SCREEN_WIDTH = 960;
    public static final int SCREEN_HEIGHT = 720;

    public ScreenBase(Game game, MapRenderer renderer) {
        this.game = game;
        this.renderer = renderer;
    }

    public BattleShipsMultiplayerGame getGame() {
        return (BattleShipsMultiplayerGame) game;
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
