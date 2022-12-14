package com.sangpasang.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * This code is copied from a reddit post about animated button.
 * @see <a href=https://www.reddit.com/r/libgdx/comments/4gwxod/best_way_to_make_an_animated_button_in_scene2d/>Animated Button in Scene2D</a
 */
public class AnimatedDrawable extends BaseDrawable {
    private Animation<TextureRegionDrawable> animation;
    private TextureRegionDrawable keyFrame;
    private float stateTime = 0;

    public AnimatedDrawable(Animation<TextureRegionDrawable> animation){

        this.animation = animation;
        TextureRegionDrawable key = animation.getKeyFrame(0);

        this.setLeftWidth(key.getRegion().getRegionWidth()/2);
        this.setRightWidth(key.getRegion().getRegionWidth()/2);
        this.setTopHeight(key.getRegion().getRegionHeight()/2);
        this.setBottomHeight(key.getRegion().getRegionHeight()/2);
        this.setMinWidth(key.getRegion().getRegionWidth());
        this.setMinHeight(key.getRegion().getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height){

        stateTime += Gdx.graphics.getDeltaTime();
        keyFrame = animation.getKeyFrame(stateTime, true);

        batch.draw(keyFrame.getRegion(), x,y, keyFrame.getRegion().getRegionWidth(), keyFrame.getRegion().getRegionHeight());
    }
}
