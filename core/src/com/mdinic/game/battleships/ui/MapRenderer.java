package com.mdinic.game.battleships.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class MapRenderer {

    GameMap map;
    public OrthographicCamera cam;

    float stateTime = 0;
    Vector3 lerpTarget = new Vector3();

    // public SpriteBatch batch = new SpriteBatch(5460);

    public MapRenderer() {

        // this.cam = new OrthographicCamera(ScreenBase.SCREEN_WIDTH,
        // ScreenBase.SCREEN_HEIGHT);

        map = new GameMap(new Sounds());
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
        // batch.setProjectionMatrix(cam.combined);
        // batch.begin();
        //
        // renderShip();
        //
        // batch.end();

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

        // batch.dispose();
    }

    void disposeAnimation(Animation anim) {
        TextureRegion[] keyFrames = anim.getKeyFrames();
        for (TextureRegion textureRegion : keyFrames) {
            textureRegion.getTexture().dispose();
        }
    }
}
