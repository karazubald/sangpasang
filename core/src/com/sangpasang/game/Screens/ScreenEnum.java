package com.sangpasang.game.Screens;

/**
 * This class is a modified code from PixNB Blog's post.
 * @see <a href=http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/>Manage Screen in LibGDX</a>
 */
public enum ScreenEnum {
    SPLASH{
        public StagedScreen getScreen(Object... params) {
            return new SplashScreen();
        }
    },
    MAIN_MENU {
        public StagedScreen getScreen(Object... params) {
            return new MainMenuScreen();
        }
    },
    GAME {
        public StagedScreen getScreen(Object... params) {
            return new GameScreen();
        }
    },
    LICENSE{
        public StagedScreen getScreen(Object... params) {
            return new LicenseScreen();
        }
    };

    public abstract StagedScreen getScreen(Object... params);
}
