package com.sangpasang.game.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.sangpasang.game.ui.ColorTheme;

public class SplashScreen extends StagedScreen {
    @Override
    public void buildStage(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;

        String splashFile = colorTheme.getPalette().getPaletteName() + "/splash.png";
        TextureRegionDrawable splashDrawable = new TextureRegionDrawable(new Texture(splashFile));
        Image splashImage = new Image(splashDrawable, Scaling.fit);

        final Action switchScreen = new Action() {
            @Override
            public boolean act(float delta) {
                ScreenManager.getInstance().showScreen(ScreenEnum.GAME, getColorTheme());
                return false;
            }
        };

        splashImage.addAction(Actions.scaleTo(0.25f, 0.25f));
        splashImage.addAction(Actions.alpha(0f));
        splashImage.addAction(Actions.fadeIn(5f));
        splashImage.addAction(Actions.scaleTo(1f, 1f, 5f));
        splashImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                addAction(Actions.sequence(Actions.fadeOut(5f), switchScreen));
            }
        });

        addActor(splashImage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        act(delta);
        draw();
    }
}
