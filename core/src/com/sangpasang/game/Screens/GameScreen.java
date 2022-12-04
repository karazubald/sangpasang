package com.sangpasang.game.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.sangpasang.game.Gems.Gem;
import com.sangpasang.game.Gems.GemEnum;
import com.sangpasang.game.Gems.GemManager;
import com.sangpasang.game.ui.ColorTheme;

import java.security.SecureRandom;

public class GameScreen extends StagedScreen {
    @Override
    public void buildStage(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;

        Table table = new Table();
        table.setFillParent(true);
        table.center();
        table.setDebug(true);

        //GemManager.getInstance().createGem(GemEnum.gem2);
        ButtonGroup<Gem> gemButtonGroup = new ButtonGroup<>();
        gemButtonGroup.setMinCheckCount(0);
        gemButtonGroup.setMaxCheckCount(2);
        int gemTotal = 7;
        for (int gemCount = 0; gemCount < gemTotal; gemCount++) {
            SecureRandom randomGenerator = new SecureRandom();
            int randomizedGemCode = randomGenerator.nextInt(3) + 1;
            Gem gem = GemManager.getInstance().createGem(GemEnum.gem1);
            switch (randomizedGemCode) {
                case 1:
                    gem = GemManager.getInstance().createGem(GemEnum.gem1);
                    break;
                case 2:
                    gem = GemManager.getInstance().createGem(GemEnum.gem2);
                    break;
                case 3:
                    gem = GemManager.getInstance().createGem(GemEnum.gem3);
                    break;
            }
            gemButtonGroup.add(gem);
        }
        for(Gem g : gemButtonGroup.getButtons()){
            table.add(g);
        }

        addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        act(delta);
        draw();
    }
}
