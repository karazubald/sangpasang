package com.sangpasang.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.sangpasang.game.ui.ColorTheme;
import com.sangpasang.game.ui.BasePalette;

/**
 * This class is a modified code from PixNB Blog's post.
 * @see <a href=http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/>Manage Screen in LibGDX</a>
 */
public abstract class StagedScreen extends Stage implements Screen {
    ColorTheme colorTheme;

    protected StagedScreen() {
        super(new FitViewport(720, 1280f, new OrthographicCamera()) );
    }

    public ColorTheme getColorTheme(){
        return this.colorTheme;
    }

    public void buildStage(ColorTheme colorTheme){
        this.colorTheme = colorTheme;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        BasePalette currentPalette = colorTheme.getPalette();
        ScreenUtils.clear(currentPalette.getBgColor());
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resized to w = "+width+", h = "+height);
        getViewport().update(width,height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
