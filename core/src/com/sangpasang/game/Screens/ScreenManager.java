package com.sangpasang.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.sangpasang.game.ui.ColorTheme;

/**
 * This class code is a copied code from PixNB Blog's post.
 * @see <a href=http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/>Manage Screen in LibGDX</a>
 */
public class ScreenManager {
    // Singleton: unique instance
    private static ScreenManager instance;

    // Reference to game
    private Game game;

    // Singleton: private constructor
    private ScreenManager() {
        super();
    }

    // Singleton: retrieve instance
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    // Initialization with the game class
    public void initialize(Game game) {
        this.game = game;
    }

    // Show in the game the screen which enum type is received
    public void showScreen(ScreenEnum screenEnum, ColorTheme colorTheme, Object... params) {

        // Get current screen to dispose it
        Screen currentScreen = game.getScreen();

        // Show new screen
        StagedScreen newScreen = screenEnum.getScreen(params);
        newScreen.buildStage(colorTheme);
        game.setScreen(newScreen);

        // Dispose previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }
}
