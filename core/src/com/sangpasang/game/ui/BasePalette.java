package com.sangpasang.game.ui;

import com.badlogic.gdx.graphics.Color;

import java.util.Locale;

/**
 * Instance(s) of this class provides {@link Color} configuration for in-game asset(s).
 *
 * @author karazubald
 */
public class BasePalette {
    protected String paletteName;
    protected Color bgColor;
    protected Color txtColor;
    protected Color altTextColor;
    protected Color overColor;
    protected Color downColor;

    /**
     * The name of this color palette.
     * The name should only contain lowercase letters.
     * @param paletteName
     */
    public void setPaletteName(String paletteName){
        this.paletteName = paletteName.toLowerCase(Locale.ROOT);
    }

    public Color getBgColor() {
        return bgColor;
    }

    /**
     * Set the background color of all screens
     * @param bgColor
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getTxtColor() {
        return txtColor;
    }

    /**
     * Set the font color for texts.
     * @param txtColor Color with the highest contrast from background.
     */
    public void setTxtColor(Color txtColor) {
        this.txtColor = txtColor;
    }

    public Color getAltTextColor() {
        return altTextColor;
    }

    /**
     * Set the alternative font color for texts.
     * @param altTextColor Color with higher contrast from background.
     */
    public void setAltTextColor(Color altTextColor) {
        this.altTextColor = altTextColor;
    }

    public Color getOverColor() {
        return overColor;
    }

    /**
     * Set the hover color of an asset.
     * @param overColor
     */
    public void setOverColor(Color overColor) {
        this.overColor = overColor;
    }

    public Color getDownColor() {
        return downColor;
    }

    /**
     * Set the down or checked color of an asset.
     * @param downColor
     */
    public void setDownColor(Color downColor) {
        this.downColor = downColor;
    }

    public String getPaletteName() {
        return paletteName;
    }
}
