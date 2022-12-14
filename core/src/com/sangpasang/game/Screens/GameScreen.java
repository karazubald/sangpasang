package com.sangpasang.game.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sangpasang.game.Gems.Gem;
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

        ButtonGroup<Gem> gemButtonGroup = new ButtonGroup<>();
        gemButtonGroup.setMinCheckCount(0);
        gemButtonGroup.setMaxCheckCount(2);
        int gemTotal = 7;
        for (int gemCount = 0; gemCount < gemTotal; gemCount++) {
            SecureRandom randomGenerator = new SecureRandom();
            int randomizedGemCode = randomGenerator.nextInt(3) + 1;
            Gem gem = null;
            switch (randomizedGemCode) {
                case 1:
                    gem = new Gem(GemEnum.gem1, colorTheme);
                    break;
                case 2:
                    gem = new Gem(GemEnum.gem2, colorTheme);
                    break;
                case 3:
                    gem = new Gem(GemEnum.gem3, colorTheme);
                    break;
            }
            gemButtonGroup.add(gem);
            //table.add(gem);
        }

        for (Gem g : gemButtonGroup.getButtons()) {
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
