package com.mdinic.game.battleships;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {

    private boolean mute = false;

    private Music introSfx;

    private Music currentMusic = null;

    private Sound gianaJumpSfx;

    public enum Sfx {
        JUMP
    };

    public enum BgMusic {
        START_LEVEL, INTRO, MUSIC_FAST, MUSIC_LIGHT
    };

    public Sounds() {
        /*
         * musicLight =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/bgMusic1.mp3"));
         * musicFast =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/bgMusic2.mp3"));
         * highscores =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/highscores.mp3"));
         * 
         * introSfx =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/intro.mp3"));
         * startLevelSfx =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/startLevel.mp3"));
         * endLevelSfx =
         * Gdx.audio.newMusic(Gdx.files.internal("data/sfx/endLevel-bonus.mp3"
         * )); gianaJumpSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/jump.mp3"));
         * gianaKillSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/kill.mp3"));
         * gianaDyingSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/dying.mp3"));
         * diamondSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/diamond-collect.mp3"
         * )); powerUpSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/powerup.mp3"));
         * brickDestroySfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/brick.mp3"));
         * treatBoxCoinSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/treatboxcoin.mp3"));
         * treatSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/treat.mp3"));
         * fireBulletSfx =
         * Gdx.audio.newSound(Gdx.files.internal("data/sfx/fire.mp3"));
         */
    }

    public void dispose() {
        introSfx.dispose();
        gianaJumpSfx.dispose();

    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public void play(BgMusic music) {
        switch (music) {

        // case INTRO:
        // introSfx.play();
        // currentMusic = introSfx;
        // break;
        // case END_LEVEL:
        // endLevelSfx.play();
        // currentMusic = endLevelSfx;
        // break;
        // case START_LEVEL:
        // startLevelSfx.play();
        // currentMusic = startLevelSfx;
        // break;
        // case MUSIC_LIGHT:
        // musicLight.play();
        // currentMusic = musicLight;
        // break;
        // case MUSIC_FAST:
        // musicFast.play();
        // currentMusic = musicFast;
        // break;
        // case HIGHSCORES:
        // highscores.play();
        // currentMusic = highscores;
        // break;
        default:
            currentMusic = null;
            break;
        }

        if (currentMusic != null) {
            currentMusic.setVolume(mute ? 0 : 1);
        }
    }

    public void play(Sfx sfx) {
        if (mute) {
            return;
        }
        switch (sfx) {

        // case BRICK_DESTROY:
        // brickDestroySfx.play();
        // break;
        // case DYING:
        // gianaDyingSfx.play();
        // break;
        // case JUMP:
        // gianaJumpSfx.play();
        // break;
        // case KILL:
        // gianaKillSfx.play();
        // break;
        // case POWERUP:
        // powerUpSfx.play();
        // break;
        // case TREAT_BOX_COIN:
        // treatBoxCoinSfx.play();
        // break;
        // case DIAMOND:
        // diamondSfx.play();
        // break;
        // case TREAT:
        // treatSfx.play();
        // break;
        // case FIRE_BULLET:
        // fireBulletSfx.play();
        // break;
        default:
            break;
        }
    }

    public void stopCurrentMusic() {
        if (currentMusic != null) {
            currentMusic.stop();
            currentMusic = null;
        }
    }

    public Music getCurrentMusic() {
        return currentMusic;
    }

    public void stop(Sfx sfx) {
        switch (sfx) {
        // case BRICK_DESTROY:
        // brickDestroySfx.stop();
        // break;
        // case DYING:
        // gianaDyingSfx.stop();
        // break;
        //
        // case JUMP:
        // gianaJumpSfx.stop();
        // break;
        // case KILL:
        // gianaKillSfx.stop();
        // break;
        // case POWERUP:
        // powerUpSfx.stop();
        // break;
        // case TREAT_BOX_COIN:
        // treatBoxCoinSfx.stop();
        // break;
        // case DIAMOND:
        // diamondSfx.stop();
        // break;
        // case TREAT:
        // treatSfx.stop();
        // break;
        // case FIRE_BULLET:
        // fireBulletSfx.stop();
        // break;
        default:
            break;
        }
    }

    public void stop(BgMusic music) {
        switch (music) {
        // case INTRO:
        // introSfx.stop();
        // break;
        // case END_LEVEL:
        // endLevelSfx.stop();
        // break;
        // case START_LEVEL:
        // startLevelSfx.stop();
        // break;
        // case MUSIC_LIGHT:
        // musicLight.stop();
        // break;
        // case MUSIC_FAST:
        // musicFast.stop();
        // break;
        // case HIGHSCORES:
        // highscores.stop();
        // break;
        default:
            break;
        }
    }

}
