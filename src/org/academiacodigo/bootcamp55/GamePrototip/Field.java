package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private int cols;
    private int rows;
    private final int CELLSIZE = 32;
    private final int PADDING = 32;
    private Picture picture;
    private Rectangle field;

    public Field (int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init () {
        field = new Rectangle(PADDING, PADDING, 23 * CELLSIZE, 13 * CELLSIZE);
        System.out.println("field init");
        for (int column = 0; column < Frame.COLS; column++) {
            for (int row = 0; row < Frame.ROWS; row++) {
                picture = new Picture((column * 32) + PADDING, (row * 32) + PADDING, "ground.png");
                picture.draw();
            }
        }
    }

    public int getX () {
        return field.getX();
    }

    public int getY () {
        return field.getY();
    }

    public int getCELLSIZE () {
        return CELLSIZE;
    }

    public int getCols () {
        return cols;
    }

    public int getRows () {
        return rows;
    }

    public int getPADDING () {
        return PADDING;
    }

    public int colToX(int col) {
        return col * CELLSIZE + PADDING;
    }

    public int rowToY(int row) {
        return row * CELLSIZE + PADDING;
    }
}
