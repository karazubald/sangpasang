package com.sangpasang.game.ui;

import com.badlogic.gdx.graphics.Color;

public class DefaultPalette extends BasePalette{

    public DefaultPalette() {
        setPaletteName("default");

        setBgColor(new Color(254,249,217,1));
        setTxtColor(new Color(0,84,26,1));
        setAltTextColor(new Color(147,89,0,1));
        setOverColor(new Color(206,125,0,1));
        setDownColor(new Color(0,0,0,1));
    }
}
