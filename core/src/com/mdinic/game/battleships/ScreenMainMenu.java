package com.mdinic.game.battleships;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenMainMenu extends ScreenBase {

    private Texture background;
    private Skin skin;
    private Stage stage;
    private Batch batch;

    public ScreenMainMenu(Game game, MapRenderer renderer) {
        super(game, renderer);
    }

    @Override
    public void show() {
        super.show();

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.getFont("default-font").setScale(2f);

        stage = new Stage(new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        TextButton create = new TextButton("New Game", skin);
        create.setPosition(615, 550);
        create.setSize(285, 100);
        stage.addActor(create);

        create.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ScreenCreateGame(game, renderer));
            }
        });

        TextButton join = new TextButton("Join Game", skin);
        join.setPosition(615, 411);
        join.setSize(285, 100);
        stage.addActor(join);

        batch = stage.getBatch();

        background = new Texture(Gdx.files.internal("mainmenu.png"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch.end();

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void dispose() {
        super.dispose();

        background.dispose();
        batch.dispose();
        stage.dispose();
        skin.dispose();
    }

}
