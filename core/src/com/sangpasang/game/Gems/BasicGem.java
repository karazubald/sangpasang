package com.sangpasang.game.Gems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sangpasang.game.ui.ColorTheme;

public class BasicGem extends Actor {
    private final int FRAMES = 6;
    TextureAtlas gemAtlas;
    TextureAtlas.AtlasRegion gemRegion;
    boolean hovered, checked;
    ClickListener click;
    float stateTime;
    Animation<TextureAtlas.AtlasRegion> upAnimation, hoverAnimation, checkedAnimation;

    public BasicGem(GemEnum gemEnum, ColorTheme colorTheme){
        initAtlas(colorTheme, gemEnum);
        initClickListener();
        initUpAnimation(gemEnum);
        initHoverAnimation(gemEnum);
        initCheckedAnimation(gemEnum);

        Image image = new Image(gemRegion);
        image.setFillParent(true);
        image.setVisible(true);
    }

    public void initAtlas(ColorTheme colorTheme, GemEnum gemEnum){
        String reference = colorTheme.getPalette().getPaletteName() + "/atlas/" + gemEnum.toString() + ".atlas";
        FileHandle atlasFile = Gdx.files.internal(reference);
        gemAtlas = new TextureAtlas(atlasFile);
    };

    public void initClickListener(){
        click = new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if(isChecked()) setHovered(false); else setHovered(true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                if(isHovered()) setHovered(false);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(isChecked()) setChecked(false); else setChecked(true);
            }
        };
    }

    public void initUpAnimation(GemEnum gemEnum){
        TextureAtlas.AtlasRegion[] regionArray = new TextureAtlas.AtlasRegion[FRAMES];
        TextureAtlas.AtlasRegion atlasRegion;
        String regionName;
        for(int index = 0; index < FRAMES; index++){
            regionName = gemEnum.toString() + "-up" + index;
            regionArray[index] = gemAtlas.findRegion(regionName);
        }
        upAnimation = new Animation<>(1/FRAMES,regionArray);
        upAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public void initHoverAnimation(GemEnum gemEnum){
        TextureAtlas.AtlasRegion[] regionArray = new TextureAtlas.AtlasRegion[FRAMES];
        TextureAtlas.AtlasRegion atlasRegion;
        String regionName;
        for(int index = 0; index < FRAMES; index++){
            regionName = gemEnum.toString() + "-over" + index;
            regionArray[index] = gemAtlas.findRegion(regionName);
        }
        hoverAnimation = new Animation<>(1/FRAMES,regionArray);
        hoverAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public void initCheckedAnimation(GemEnum gemEnum){
        TextureAtlas.AtlasRegion[] regionArray = new TextureAtlas.AtlasRegion[FRAMES];
        TextureAtlas.AtlasRegion atlasRegion;
        String regionName;
        for(int index = 0; index < FRAMES; index++){
            regionName = gemEnum.toString() + "-checked" + index;
            regionArray[index] = gemAtlas.findRegion(regionName);
        }
        checkedAnimation = new Animation<>(1/FRAMES,regionArray);
        checkedAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if(isChecked()) {
            gemRegion = checkedAnimation.getKeyFrame(stateTime);
        } else if (!isChecked()){
            if(isHovered()) gemRegion = hoverAnimation.getKeyFrame(stateTime);
            if(!isHovered()) gemRegion = upAnimation.getKeyFrame(stateTime);
        }

        batch.draw(gemRegion, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }

    public void act(float delta){
        stateTime += delta;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isHovered(){
        return hovered;
    }
}
