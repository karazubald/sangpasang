package com.sangpasang.game.Gems;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;

public class PreGem extends Table implements Disableable {
    ButtonGroup buttonGroup;
    boolean isPressed, isChecked;

    @Override
    public void setDisabled(boolean isDisabled) {

    }

    @Override
    public boolean isDisabled() {
        return false;
    }
}
