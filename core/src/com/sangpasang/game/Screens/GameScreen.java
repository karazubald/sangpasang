package com.sangpasang.game.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sangpasang.game.Gems.Gem;
import com.sangpasang.game.Gems.GemClass;
import com.sangpasang.game.Gems.GemEnum;
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
        //ButtonGroup<Gem> gemButtonGroup = new ButtonGroup<>();
        //gemButtonGroup.setMinCheckCount(0);
        //gemButtonGroup.setMaxCheckCount(2);
        int gemTotal = 7;
        GemClass[] gemArray = new GemClass[gemTotal];
        for (int gemCount = 0; gemCount < gemTotal; gemCount++) {
            SecureRandom randomGenerator = new SecureRandom();
            int randomizedGemCode = randomGenerator.nextInt(3) + 1;
            GemClass gem = null;
            switch (randomizedGemCode) {
                case 1:
                    gem = new GemClass(GemEnum.gem1, colorTheme);
                    break;
                case 2:
                    gem = new GemClass(GemEnum.gem2, colorTheme);
                    break;
                case 3:
                    gem = new GemClass(GemEnum.gem3, colorTheme);
                    break;
            }
            //gemButtonGroup.add(gem);
        }
        for(GemClass g : gemArray){
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
