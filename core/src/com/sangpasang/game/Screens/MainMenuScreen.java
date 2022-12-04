package com.sangpasang.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sangpasang.game.Gems.Gem;
import com.sangpasang.game.Gems.GemEnum;
import com.sangpasang.game.ui.ColorTheme;

public class MainMenuScreen extends StagedScreen {

    @Override
    public void buildStage(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;

        Button userProfile = initializeButton("userprofile");
        Button userName = initializeButton("username");
        Button startButton = initializeButton("button");

        userProfile.setPosition(280f,280f);
        userName.setPosition(200f,520f);
        startButton.setPosition(520f,760f);

        addActor(userProfile);
        addActor(userName);
        addActor(startButton);
    }

    public Button initializeButton(String assetName){
        String theme = colorTheme.getPalette().getPaletteName();
        FileHandle file = Gdx.files.internal(theme + "/atlas/ui.atlas");
        TextureAtlas UIAtlas = new TextureAtlas(file);

        TextureRegionDrawable upDrawable = new TextureRegionDrawable(UIAtlas.findRegion(assetName + "-up"));
        TextureRegionDrawable hoverDrawable = new TextureRegionDrawable(UIAtlas.findRegion(assetName + "-over"));
        TextureRegionDrawable checkedDrawable = new TextureRegionDrawable(UIAtlas.findRegion(assetName + "-over"));

        Button.ButtonStyle style = new Button.ButtonStyle();

        style.up = upDrawable;
        style.over = hoverDrawable;
        style.down = checkedDrawable;
        style.checked = checkedDrawable;

        return new Button(style);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        act(delta);
        draw();
    }
}
