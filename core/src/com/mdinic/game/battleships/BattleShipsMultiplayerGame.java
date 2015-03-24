package com.mdinic.game.battleships;

import com.badlogic.gdx.Game;

public class BattleShipsMultiplayerGame extends Game {

    @Override
    public void create() {
        setScreen(new ScreenCreateGame(null, null));
    }
}
