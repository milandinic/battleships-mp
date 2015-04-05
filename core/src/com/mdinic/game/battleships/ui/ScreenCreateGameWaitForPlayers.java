package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenCreateGameWaitForPlayers extends ScreenBase {

    // SpriteBatch batch;
    private Texture background;

    public BitmapFont font;

    Stage stage;
    Skin skin;

    private Batch batch;

    public ScreenCreateGameWaitForPlayers(Game game, MapRenderer renderer) {
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

        ScrollPane scroll = new ScrollPane(listOfGames, skin);

        listOfGames.setItems("NIkoa", "Nikao", "Milan", "HTC");

        scroll.setPosition(615, 300);
        scroll.setSize(285, 350);
        // scroll.
        stage.addActor(scroll);

        Label playersLabel = new Label("Players", skin);

        playersLabel.setSize(200, 50);
        playersLabel.setPosition(scroll.getX() - playersLabel.getWidth() * 2, scroll.getY() + scroll.getHeight()
                - playersLabel.getHeight());
        stage.addActor(playersLabel);

        TextButton kick = new TextButton("Kick player", skin);
        kick.setPosition(615, 160);
        kick.setSize(285, 100);
        stage.addActor(kick);

        TextButton createGame = new TextButton("GO!", skin);
        createGame.setPosition(615, 50);
        createGame.setSize(285, 100);
        stage.addActor(createGame);

        TextButton back = new TextButton("Back", skin);
        back.setPosition(50, 50);
        back.setSize(285, 100);
        stage.addActor(back);

        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ScreenCreateGame(game, renderer));
            }
        });

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
