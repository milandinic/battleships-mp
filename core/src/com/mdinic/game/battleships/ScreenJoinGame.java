package com.mdinic.game.battleships;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenJoinGame extends ScreenBase {

    // SpriteBatch batch;
    private Texture background;

    public BitmapFont font;

    Stage stage;
    Skin skin;

    private Batch batch;

    public ScreenJoinGame(Game game, MapRenderer renderer) {
        super(game, renderer);
    }

    @Override
    public void show() {

        super.show();

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.getFont("default-font").setScale(2f);

        stage = new Stage(new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        List<String> listOfGames = new List<String>(skin);

        listOfGames.setItems("Epic battle", "some game", "Addriatic battle", "Black sea battle");

        listOfGames.setPosition(615, 550);
        listOfGames.setSize(285, 100);
        stage.addActor(listOfGames);

        batch = stage.getBatch();

        background = new Texture(Gdx.files.internal("background.png"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        batch.end();

        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();

        background.dispose();

        batch.dispose();
        font.dispose();
    }

}
