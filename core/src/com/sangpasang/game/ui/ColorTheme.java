package com.sangpasang.game.ui;

/**
 * An enum containing graphical configuration for all or specific sceen.
 * This class is created based on one of PixNB Blog's post.
 *
 * @see <a href=http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/>Manage Screen in LibGDX</a>
 */
public enum ColorTheme {
    DEFAULT{
        @Override
        public BasePalette getPalette() {
            return new DefaultPalette();
        }
    },
    PALEBLUE{
        @Override
        public BasePalette getPalette() {
            return new PaleBluePalette();
        }
    };

    public abstract BasePalette getPalette();
}
