package com.sangpasang.game.Gems;

import com.sangpasang.game.ui.ColorTheme;

/**
 * This class code is a modified code from PixNB Blog's post.
 *
 * @see <a href=http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/>Manage Screen in LibGDX</a>
 */
public class GemManager {
    // Singleton: unique instance
    private static GemManager instance;

    // Get AppTheme's Game
    private ColorTheme colorTheme;

    // Get rule of matches
    private int matchCriteria;

    // Singleton: private constructor
    private GemManager() {
        super();
    }

    // Singleton: retrieve instance
    public static GemManager getInstance() {
        if (instance == null) {
            instance = new GemManager();
        }
        return instance;
    }

    // Initialization with the game class
    public void initialize(ColorTheme colorTheme, int matchCriteria) {
        this.colorTheme = colorTheme;
        if (matchCriteria <= 3) {
            matchCriteria = 3;
        } else {
            this.matchCriteria = matchCriteria;
        }
    }

    /**
     * Create new Gem object from GemEnum.
     *
     * @param gemEnum
     * @return
     */
    public Gem createGem(GemEnum gemEnum) {
        Gem gemObject = new Gem(gemEnum, colorTheme);
        return gemObject;
    }

    /**
     * Checks for a gem match.
     * Return true if at least 3 gem of the same type is found.
     *
     * @param gems Minimum of 3 {@link Gem}'s objects to be evaluated.
     * @return true or false.
     */
    public boolean checkMatchedGem(Gem... gems) {
        boolean isMatched;
        int countGem = 0;
        for (Gem gem : gems) {
            countGem++;
        }
        if (countGem < matchCriteria) {
            isMatched = false;
        } else {
            isMatched = true;
        }
        return isMatched;
    }
}
