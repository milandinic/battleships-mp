package com.mdinic.game.battleships.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ScreenPlaceYourShips extends ScreenBase {

    static int CELL_SIZE;
    static int LINE_WIDTH = 2;

    static int OFFSET_X;
    static int OFFSET_Y;

    // SpriteBatch batch;
    private Texture background;

    public BitmapFont font;

    private Batch batch;

    private Batch bgBatch;

    ShapeRenderer shape = new ShapeRenderer();

    List<Ship> ships = new ArrayList<Ship>();

    List<TextureRegion> shipsGfx = new ArrayList<TextureRegion>();

    Ship dragShip;
    Vector2 clickCorrection = new Vector2(0, 0);

    public ScreenPlaceYourShips(Game game, MapRenderer renderer) {
        super(game, renderer);

        CELL_SIZE = Gdx.graphics.getHeight() / 12;

        OFFSET_X = CELL_SIZE;
        OFFSET_Y = CELL_SIZE;

        int shipOffesetX = Gdx.graphics.getWidth() - CELL_SIZE * 5;
        int shipOffesetY = CELL_SIZE;
        int shipStepY = CELL_SIZE * 2;

        Ship ship = new Ship(shipOffesetX, shipOffesetY);
        ship.bounds.width = CELL_SIZE * 3;
        ship.bounds.height = CELL_SIZE * 2;
        ship.horizontal = true;
        ship.size = 1;
        ships.add(ship);
        shipsGfx.add(new TextureRegion(new Texture(Gdx.files.internal(ship.size + ".png"))));

        ship = new Ship(shipOffesetX, shipOffesetY + shipStepY * ships.size());
        ship.bounds.width = CELL_SIZE * 3;
        ship.bounds.height = CELL_SIZE * 2;
        ship.horizontal = true;
        ship.size = 2;
        ships.add(ship);
        shipsGfx.add(new TextureRegion(new Texture(Gdx.files.internal(ship.size + ".png"))));

        ship = new Ship(shipOffesetX, shipOffesetY + shipStepY * ships.size());
        ship.bounds.width = CELL_SIZE * 3;
        ship.bounds.height = CELL_SIZE * 2;
        ship.horizontal = true;
        ship.size = 3;
        ships.add(ship);
        shipsGfx.add(new TextureRegion(new Texture(Gdx.files.internal(ship.size + ".png"))));

        ship = new Ship(shipOffesetX, shipOffesetY + shipStepY * ships.size());
        ship.bounds.width = CELL_SIZE * 4;
        ship.bounds.height = CELL_SIZE * 2;
        ship.horizontal = true;
        ship.size = 4;
        ships.add(ship);
        shipsGfx.add(new TextureRegion(new Texture(Gdx.files.internal(ship.size + ".png"))));

        ship = new Ship(shipOffesetX, shipOffesetY + shipStepY * ships.size());
        ship.bounds.width = CELL_SIZE * 5;
        ship.bounds.height = CELL_SIZE * 2;
        ship.horizontal = true;
        ship.size = 5;
        ships.add(ship);
        shipsGfx.add(new TextureRegion(new Texture(Gdx.files.internal(ship.size + ".png"))));

        Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener()));

    }

    @Override
    public void show() {

        super.show();

        bgBatch = new SpriteBatch();
        bgBatch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        background = new Texture(Gdx.files.internal("background.png"));

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // background
        bgBatch.begin();
        bgBatch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        bgBatch.end();

        drawGrid();

        batch.begin();

        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            if (ship.horizontal) {

                batch.draw(shipsGfx.get(i), ship.bounds.x, ship.bounds.y, ship.bounds.width, ship.bounds.height);
            } else {
                batch.draw(shipsGfx.get(i), ship.bounds.x, ship.bounds.y,

                ship.bounds.width / 2, ship.bounds.height / 2,

                ship.bounds.height, ship.bounds.width, 1f, 1f, 0, false);
            }

        }

        batch.end();

        readKeys();
    }

    private void drawGrid() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        shape.begin(ShapeType.Filled);

        shape.setColor(1, 1, 1, 0.5f);
        shape.rect(OFFSET_X, OFFSET_Y, CELL_SIZE * 10 + LINE_WIDTH, CELL_SIZE * 10);

        shape.end();

        Gdx.gl.glDisable(GL20.GL_BLEND);

        shape.setColor(0, 0, 0, 1f);
        shape.begin(ShapeType.Filled);

        // horizontal
        for (int i = 0; i < 11; i++) {
            shape.rect(OFFSET_X, OFFSET_Y + CELL_SIZE * i, CELL_SIZE * 10 + LINE_WIDTH, LINE_WIDTH);
        }
        // vertical
        for (int i = 0; i < 11; i++) {
            shape.rect(OFFSET_X + CELL_SIZE * i, OFFSET_Y, LINE_WIDTH, CELL_SIZE * 10);
        }

        shape.end();
    }

    private void drawDragColors() {

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        shape.begin(ShapeType.Filled);

        shape.setColor(0, 1, 0, 0.5f);

        int shipMap[][] = new int[10][10];

        for (Ship ship : ships) {

            int x = (int) (ship.bounds.x / CELL_SIZE);
            int y = (int) (ship.bounds.y / CELL_SIZE);

            y--;

            if (dragShip != ship) {

                if (ship.horizontal) {

                    if (x >= 0 && x + ship.size <= 10 && y >= 0 && y < 10) {

                        shape.rect(CELL_SIZE * x + OFFSET_X, y * CELL_SIZE + OFFSET_Y, CELL_SIZE * ship.size, CELL_SIZE);

                        for (int i = Math.max(x - 1, 0); i < Math.min(x + ship.size + 1, 9); i++) {
                            for (int j = Math.max(y - 1, 0); j < Math.min(y + 2, 9); j++) {
                                shipMap[j][i] = 1;
                            }
                        }

                    }
                } else {

                    if (x >= 0 && x < 10 && y >= 0 && y + ship.size <= 10) {
                        shape.rect(CELL_SIZE * x + OFFSET_X, y * CELL_SIZE + OFFSET_Y, CELL_SIZE, CELL_SIZE * ship.size);
                    }

                    for (int i = Math.max(y - 1, 0); i < Math.min(y + ship.size + 1, 9); i++) {
                        for (int j = Math.max(x - 1, 0); j < Math.min(x + 2, 9); j++) {
                            shipMap[i][j] = 1;
                        }
                    }
                }
            }
        }

        if (dragShip != null) {

            boolean notFound = true;
            int x = (int) (dragShip.bounds.x / CELL_SIZE);
            int y = (int) (dragShip.bounds.y / CELL_SIZE);

            y--;
            if (dragShip.horizontal) {

                if (x >= 0 && x + dragShip.size <= 10 && y >= 0 && y < 10) {
                    for (int i = x; i < x + dragShip.size; i++) {
                        if (shipMap[y][i] == 1) {
                            notFound = false;
                            break;

                        }
                    }

                    if (notFound) {
                        shape.rect(CELL_SIZE * x + OFFSET_X, y * CELL_SIZE + OFFSET_Y, CELL_SIZE * dragShip.size,
                                CELL_SIZE);
                    }
                }

            } else {
                if (x >= 0 && x < 10 && y >= 0 && y + dragShip.size <= 10) {

                    for (int i = y; i < y + dragShip.size; i++) {
                        if (shipMap[i][x] == 1) {
                            notFound = false;
                            break;

                        }
                    }

                    if (notFound) {
                        shape.rect(CELL_SIZE * x + OFFSET_X, y * CELL_SIZE + OFFSET_Y, CELL_SIZE, CELL_SIZE
                                * dragShip.size);
                    }
                }
            }

        }

        shape.end();

        Gdx.gl.glDisable(GL20.GL_BLEND);

    }

    private void readKeys() {
        // read keys clicked on map

        Vector2 clickPosition = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());

        if (dragShip == null) {
            for (Ship ship : ships) {

                Rectangle d;

                if (ship.horizontal) {
                    d = ship.bounds;
                } else {
                    d = new Rectangle(ship.bounds.x, ship.bounds.y, ship.bounds.height, ship.bounds.width);
                }

                if (d.contains(clickPosition)) {
                    System.out.println("clicked on ship " + ship.size);
                    if (Gdx.input.justTouched()) {
                        // start drag with ship
                        dragShip = ship;

                        clickCorrection.x = Gdx.input.getX() - dragShip.bounds.x;
                        clickCorrection.y = Gdx.graphics.getHeight() - Gdx.input.getY() - dragShip.bounds.y;

                    }
                }
            }
        } else {
            if (Gdx.input.isTouched()) {
                dragShip.bounds.x = Gdx.input.getX() - clickCorrection.x;
                dragShip.bounds.y = Gdx.graphics.getHeight() - Gdx.input.getY() - clickCorrection.y;

            } else {
                dragShip = null;
            }

        }

        drawDragColors();
        // read click on ships to map
    }

    @Override
    public void dispose() {
        super.dispose();

        background.dispose();

        batch.dispose();
        font.dispose();
    }

    class MyGestureListener extends DefaultGestureListener {

        @Override
        public boolean tap(float x, float y, int count, int button) {

            if (dragShip != null && count == 2) {
                dragShip.horizontal = !dragShip.horizontal;

            }
            return false;
        }

    }
}
