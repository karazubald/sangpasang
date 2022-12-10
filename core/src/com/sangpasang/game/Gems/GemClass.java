package com.sangpasang.game.Gems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.sangpasang.game.ui.ColorTheme;

public class GemClass extends Actor {
    private boolean pressed = false, hover = false, checked = false;
    private final int FRAMES = 6;
    private float currentTime;
    private TextureAtlas gemAtlas;
    private TextureRegionDrawable drawnGem;
    private Animation<TextureRegionDrawable> upAnimation, hoverAnimation, downAnimation;
    private ClickListener clickListener;

    public GemClass(GemEnum gemType, ColorTheme colorTheme){
        initFileReference(colorTheme, gemType);

        System.out.println("frames = "+FRAMES);
        upAnimation = initAnimation(gemType,"-up");
        hoverAnimation = initAnimation(gemType, "-over");
        downAnimation = initAnimation(gemType, "-checked");

        initClickable();
    }

    /**
     * The first method that must be called.
     * Initializes atlas file based on {@link ColorTheme} and {@link GemEnum}'s value.
     * @param colorTheme {@link ColorTheme}'s value
     * @param gemType {@link GemEnum}'s value.
     */
    public void initFileReference(ColorTheme colorTheme, GemEnum gemType){
        String fileDir = colorTheme.getPalette().getPaletteName() + "/atlas/" + gemType.toString();
        FileHandle file = Gdx.files.internal(fileDir + ".atlas");
        gemAtlas = new TextureAtlas(file);
    }

    public Animation<TextureRegionDrawable> initAnimation(GemEnum gemType, String reference){
        Animation<TextureRegionDrawable> animation = null;
        //Array<TextureRegionDrawable> drawableArray = new Array<>();
        TextureRegionDrawable[] drawableArray = new TextureRegionDrawable[FRAMES];
        for (int index = 0; index < FRAMES; index++) {
            String regionReference = gemType.toString() + reference + index;
            //drawableArray.insert(index, new TextureRegionDrawable(gemAtlas.findRegion(regionReference)));
            //drawableArray.set(index, new TextureRegionDrawable(gemAtlas.findRegion(regionReference)));
            drawableArray[index] = new TextureRegionDrawable(gemAtlas.findRegion(regionReference));
        }
        animation = new Animation<>(1/FRAMES,drawableArray);
        return animation;
    }

    public void initClickable(){
        setTouchable(Touchable.enabled);
        clickListener = new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (pointer == -1) hover = true;
                drawnGem = hoverAnimation.getKeyFrame(currentTime,true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                if (pointer == -1) hover = false;
                drawnGem = upAnimation.getKeyFrame(currentTime,true);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!pressed) {
                    pressed = true;
                }
                if(!checked){
                    checked = true;
                } else {
                    checked = false;
                }
                drawnGem = downAnimation.getKeyFrame(currentTime,true);
            }
        };
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        currentTime++;
    }
}
