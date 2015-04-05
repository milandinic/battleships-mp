package com.mdinic.game.battleships.ui;

import com.mdinic.game.battleships.ui.Sounds.BgMusic;

public enum LevelConf {

    INTRO(), LEVEL1(), LEVEL2(0x826fe8), LEVEL3(0x826fe8, BgMusic.MUSIC_FAST), LEVEL4(0x826fe8), LEVEL5(0x826fe8), LEVEL6(
            0x826fe8), LEVEL7, LEVEL8(0x826fe8), LEVEL9, LEVEL10;

    enum BrickType {
        SMALL, BIG
    };

    private int backgroundColor;
    private BrickType brickType;
    private BgMusic music;

    private LevelConf(int backgroundColor, BrickType brickType, BgMusic music) {
        this.backgroundColor = backgroundColor;
        this.brickType = brickType;
        this.music = music;
    }

    private LevelConf(int backgroundColor, BgMusic music) {
        this();
        this.backgroundColor = backgroundColor;
        this.music = music;
    }

    private LevelConf(int backgroundColor) {
        this();
        this.backgroundColor = backgroundColor;
    }

    private LevelConf(BgMusic music) {
        this();
        this.music = music;
    }

    private LevelConf() {
        this.backgroundColor = 0;
        this.brickType = BrickType.SMALL;
        this.music = BgMusic.MUSIC_LIGHT;
    }

    private LevelConf(LevelConf colors) {
        this.backgroundColor = colors.backgroundColor;
        this.brickType = colors.brickType;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public BrickType getBrickType() {
        return brickType;
    }

    public BgMusic getMusic() {
        return music;
    }

}
