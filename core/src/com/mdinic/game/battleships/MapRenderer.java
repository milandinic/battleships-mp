package com.mdinic.game.battleships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class MapRenderer {

    GameMap map;
    public OrthographicCamera cam;

    float stateTime = 0;
    Vector3 lerpTarget = new Vector3();

    public SpriteBatch batch = new SpriteBatch(5460);
    public final SpriteBatch fontBatch;

    Animation diamondAnim;

    TextureRegion ship;

    // Map<AsteroidType, Sprite> asteroids = new HashMap<AsteroidType,
    // Sprite>();

    public MapRenderer() {

        this.cam = new OrthographicCamera(GameMap.SCENE_WIDTH, GameMap.SCENE_HEIGHT);

        fontBatch = new SpriteBatch();
        fontBatch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);

        ship = new TextureRegion(new Texture(Gdx.files.internal("rocket.png")));

        // for (AsteroidType at : AsteroidType.values()) {
        // asteroids.put(at, new Sprite(new
        // Texture(Gdx.files.internal("asteroid" + at.ordinal() + ".png"))));
        // }

        ship = new TextureRegion(new Texture(Gdx.files.internal("rocket.png")));
    }

    public void setMap(GameMap map) {
        this.map = map;
        // camY = map.tiles[0].length - SCENE_HEIGHT / 2 + 1;
        // int x = (int) map.giana.pos.x;
        //
        // if (moveCamToStart) {
        // x = 10;
        // }
        //
        // if (x < 10) {
        // x = 10;
        // }
        // lerpTarget.set(x, camY, 0);
        // this.cam.position.set(x, camY, 0);
        cam.update();
    }

    public void render(float deltaTime) {

        // float camX = map.ship.pos.x + 10;

        // if (camX > 134) {
        // camX = 134;
        // }

        // cam.position.lerp(lerpTarget.set(camX, map.ship.pos.y, 0), 4f *
        // deltaTime);
        cam.update();

        stateTime += deltaTime;
        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        renderShip();

        batch.end();

    }

    private void renderShip() {
        // batch.draw(ship, map.ship.pos.x, map.ship.pos.y,
        // map.ship.bounds.width, map.ship.bounds.height);
    }

    public void dispose() {
        // yellowFont10.dispose();
        // yellowFont12.dispose();
        // whiteFont10.dispose();
        // redFont10.dispose();

        // spawn.getTexture().dispose();

        // for (Entry<BrickColor, Animation> entry : brickAnim.entrySet()) {
        // disposeAnimation(entry.getValue());
        // }

        // disposeAnimation(smallDiamondAnim);

        batch.dispose();
    }

    void disposeAnimation(Animation anim) {
        TextureRegion[] keyFrames = anim.getKeyFrames();
        for (TextureRegion textureRegion : keyFrames) {
            textureRegion.getTexture().dispose();
        }
    }
}
