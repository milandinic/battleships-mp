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
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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

        ScrollPane scroll = new ScrollPane(listOfGames, skin);

        listOfGames.setItems("Epic battle", "some game", "Addriatic battle", "Black sea battle", "Atlantic survival",
                "Ice sea battle", "more gam2", "more gam3", "more gam5", "more game", "more gam6", "more gam7");

        scroll.setPosition(615, 250);
        scroll.setSize(285, 400);
        // scroll.
        stage.addActor(scroll);

        TextButton join = new TextButton("Join", skin);
        join.setPosition(615, 50);
        join.setSize(285, 100);
        stage.addActor(join);

        TextButton back = new TextButton("Back", skin);
        back.setPosition(50, 50);
        back.setSize(285, 100);
        stage.addActor(back);

        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ScreenMainMenu(game, renderer));
            }
        });

        join.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ScreenJoinGameWaitToStart(game, renderer));
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
