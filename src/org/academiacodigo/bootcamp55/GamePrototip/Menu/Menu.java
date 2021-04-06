package org.academiacodigo.bootcamp55.GamePrototip.Menu;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    private Picture screen;
    private int x;
    private int y;

    public Menu(int x, int y, MenuScreen menuScreen) {
        this.x = x;
        this.y = y;
        screen = new Picture(x, y, "menu_initial_opening.png");
    }

    public void setScreen(MenuScreen menuScreen) {
        switch (menuScreen) {
            case OPENING:
                screen = new Picture(x, y, "menu_initial_opening.png");
                break;
            case INSTRUCTIONS:
                screen = new Picture(x, y, "menu_initial_instructions.png");
                break;
            case CREDITS:
                screen = new Picture(x, y, "menu_initial_credits.png");
                break;
            case FINAL:
                screen = new Picture(x, y, "endGame.png");
                break;
            default:
                break;
        }
    }

    public void showScreen() {
        screen.draw();
    }

    public void hideScreen() {
        screen.delete();
    }
}
