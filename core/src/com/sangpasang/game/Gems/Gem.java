package com.sangpasang.game.Gems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;
import com.sangpasang.game.ui.ColorTheme;

/**
 * This class code extends {@link com.badlogic.gdx.scenes.scene2d.ui.Button}.
 */
public class Gem extends Button {
    float currentframe = 0f;
    int animation_frame;
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
        super();

        gemName = gemEnum.toString();
        gemTheme = colorTheme.getPalette().getPaletteName();
        FileHandle file = Gdx.files.internal(gemTheme + "/atlas/" + gemName + ".atlas");
        gemAtlas = new TextureAtlas(file);

        setAnimation_frame(6);
        initUpAnimation();
        initHoverAnimation();
        initDownAnimation();

        currentStyle = new ButtonStyle();
        setStyle(currentStyle);

        ClickListener click = new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                //currentStyle.over = hoverAnimation.getKeyFrame(currentframe, true);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //currentStyle.down = downAnimation.getKeyFrame(currentframe, true);
            }
        };

        addListener(click);
    }

    /**
     * Set the amount of drawables (animation_frame) to be included in one animation.
     * This method also set animation's frame per second (FPS) fixed to animation_frame.
     * For example if there are 5 drawables in atlas file, render them at 5 FPS.
     *
     * @param animation_frame Amount of drawable(s) per one animation.
     */
    private void setAnimation_frame(int animation_frame) {
        this.animation_frame = animation_frame;
    }

    private void initUpAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[animation_frame];
        for (int index = 0; index < animation_frame; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-up" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        upAnimation = new Animation<>(1 / animation_frame, animationDrawables);
    }

    private void initHoverAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[animation_frame];
        for (int index = 0; index < animation_frame; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-over" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        hoverAnimation = new Animation<>(1 / animation_frame, animationDrawables);
    }

    private void initDownAnimation() {
        TextureRegionDrawable[] animationDrawables = new TextureRegionDrawable[animation_frame];
        for (int index = 0; index < animation_frame; index++) {
            TextureAtlas.AtlasRegion region = gemAtlas.findRegion(gemName + "-checked" + index);
            animationDrawables[index] = new TextureRegionDrawable(region);
        }
        downAnimation = new Animation<>(1 / animation_frame, animationDrawables);
    }

    /**
     * Put animation of button states here.
     *
     * @param delta
     */
    @Override
    public void act(float delta) {
        currentframe += delta;
        System.out.println(currentframe);

        currentStyle.up = upAnimation.getKeyFrame(currentframe,true);
        currentStyle.over = hoverAnimation.getKeyFrame(currentframe,true);
        currentStyle.down = downAnimation.getKeyFrame(currentframe, true);
        currentStyle.checked = currentStyle.down;

        setStyle(currentStyle);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        currentStyle.up = upAnimation.getKeyFrame(currentframe,true);
        currentStyle.over = hoverAnimation.getKeyFrame(currentframe,true);
        currentStyle.down = downAnimation.getKeyFrame(currentframe, true);
        currentStyle.checked = currentStyle.down;
    }
}
