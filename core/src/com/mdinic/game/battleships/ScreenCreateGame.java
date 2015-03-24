package com.mdinic.game.battleships;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenCreateGame extends ScreenBase {

    // SpriteBatch batch;
    private Texture background;

    public BitmapFont font;

    Stage stage;
    Skin skin;

    private Batch batch;

    public ScreenCreateGame(Game game, MapRenderer renderer) {
        super(game, renderer);
    }

    @Override
    public void show() {

        super.show();

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.getFont("default-font").setScale(2f);

        stage = new Stage(new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        Label numberOfPlayersLabel = new Label("Number of players", skin);

        SelectBox<Integer> numberOfPlayers = new SelectBox<Integer>(skin);

        numberOfPlayers.setPosition(615, 550);
        numberOfPlayers.setSize(70, 50);
        stage.addActor(numberOfPlayers);

        numberOfPlayersLabel.setSize(200, 50);
        numberOfPlayersLabel.setPosition(numberOfPlayers.getX() - numberOfPlayersLabel.getWidth() * 2,
                numberOfPlayers.getY());
        stage.addActor(numberOfPlayersLabel);

        // TODO search for existing names on networks and add a unique name from
        // e.g. list (epic battle, black sea battle etc)
        TextField gameName = new TextField("Epic battle", skin);

        gameName.setPosition(615, 450);
        gameName.setSize(300, 50);
        stage.addActor(gameName);

        Label gameNameLabel = new Label("Game name", skin);

        gameNameLabel.setSize(200, 50);
        gameNameLabel.setPosition(gameName.getX() - gameNameLabel.getWidth() * 2, gameName.getY());
        stage.addActor(gameNameLabel);

        TextButton createAndWaitForPlayers = new TextButton("Create Game", skin);
        createAndWaitForPlayers.setPosition(615, 50);
        createAndWaitForPlayers.setSize(285, 100);
        stage.addActor(createAndWaitForPlayers);

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

        numberOfPlayers.setItems(2, 3, 4);
        numberOfPlayers.setSelectedIndex(0);

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
