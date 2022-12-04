package com.sangpasang.game;

import com.badlogic.gdx.Game;
import com.sangpasang.game.Gems.GemManager;
import com.sangpasang.game.Screens.ScreenEnum;
import com.sangpasang.game.Screens.ScreenManager;
import com.sangpasang.game.Screens.StagedScreen;
import com.sangpasang.game.ui.ColorTheme;

public class SangPasang extends Game {
	private int Pref_Width = 720;
	private int Pref_Height = 1280;
	private ColorTheme colorTheme = ColorTheme.DEFAULT;
	private int matchCriteria = 3;

	@Override
	public void create() {
		GemManager.getInstance().initialize(colorTheme, matchCriteria);
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenEnum.SPLASH, colorTheme);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {

	}
}
