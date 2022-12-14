package com.sangpasang.game.Gems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sangpasang.game.ui.AnimatedDrawable;
import com.sangpasang.game.ui.ColorTheme;

/**
 * This class code extends {@link com.badlogic.gdx.scenes.scene2d.ui.Button}.
 */
public class Gem extends Button {
    float currentframe = 0f;
    private final int FRAMES = 6;
    String gemName;
    String gemTheme;
    TextureAtlas gemAtlas;
    ButtonStyle currentStyle;
    Animation<TextureRegionDrawable> upAnimation;
    Animation<TextureRegionDrawable> hoverAnimation;
    Animation<TextureRegionDrawable> downAnimation;

    /**
     * This constructor generates a drawable button gem with custom configuration.
     *
     * @param gemEnum    A name of this gem as specified in {@link GemEnum}.
     * @param colorTheme {@link ColorTheme}'s color palette.
     */
    public Gem(GemEnum gemEnum, ColorTheme colorTheme) {
        //super(new ButtonStyle());

        gemName = gemEnum.toString();
        gemTheme = colorTheme.getPalette().getPaletteName();
        FileHandle file = Gdx.files.internal(gemTheme + "/atlas/" + gemName + ".atlas");
        gemAtlas = new TextureAtlas(file);

        initUpAnimation();
        initHoverAnimation();
        initDownAnimation();

        currentStyle = new ButtonStyle();
        currentStyle.up = new AnimatedDrawable(upAnimation);
        currentStyle.over = new AnimatedDrawable(hoverAnimation);
        currentStyle.down = new AnimatedDrawable(downAnimation);
        currentStyle.checked = currentStyle.down;
        setStyle(currentStyle);
        //currentStyle = getStyle();
    }

    private void initUpAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[FRAMES];
        for (int index = 0; index < FRAMES; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-up" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        upAnimation = new Animation<>(1 / FRAMES, animationDrawables);
    }

    private void initHoverAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[FRAMES];
        for (int index = 0; index < FRAMES; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-over" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        hoverAnimation = new Animation<>(1 / FRAMES, animationDrawables);
    }

    private void initDownAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[FRAMES];
        for (int index = 0; index < FRAMES; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-checked" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        downAnimation = new Animation<>(1 / FRAMES, animationDrawables);
    }

    /**
     * Put animation of button states here.
     *
     * @param delta
     */
    @Override
    public void act(float delta) {
        currentframe += delta;
    }

    /*
    @Override
    public void draw(Batch batch, float parentAlpha) {
        validate();

        currentStyle.up = upAnimation.getKeyFrame(currentframe,true);
        currentStyle.over = hoverAnimation.getKeyFrame(currentframe,true);
        currentStyle.down = downAnimation.getKeyFrame(currentframe, true);
        currentStyle.checked = currentStyle.down;
        setStyle(currentStyle);

        super.draw(batch, parentAlpha);
    }
     */
}
