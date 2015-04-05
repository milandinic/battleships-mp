package com.mdinic.game.battleships;

import com.badlogic.gdx.Game;
import com.mdinic.game.battleships.ui.MapRenderer;
import com.mdinic.game.battleships.ui.ScreenPlaceYourShips;

public class BattleShipsMultiplayerGame extends Game {

    @Override
    public void create() {
        setScreen(new ScreenPlaceYourShips(this, new MapRenderer()));
    }
}
