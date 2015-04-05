package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenJoinGameWaitToStart extends ScreenBase {

    // SpriteBatch batch;
    private Texture background;

    public BitmapFont font;

    Stage stage;
    Skin skin;

    private Batch batch;

    public ScreenJoinGameWaitToStart(Game game, MapRenderer renderer) {
        super(game, renderer);
    }

    @Override
    public void show() {

        super.show();

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.getFont("default-font").setScale(2f);

        stage = new Stage(new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        Label messageLabel = new Label("Waiting for game to start", skin);

        messageLabel.setSize(200, 50);
        messageLabel.setPosition(300, 500);
        stage.addActor(messageLabel);

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

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
