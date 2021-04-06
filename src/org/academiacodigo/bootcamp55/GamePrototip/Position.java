package org.academiacodigo.bootcamp55.GamePrototip;

public class Position {

    private Field field;
    private int col;
    private int row;

    public Position (int col, int row, Field field) {
        this.row = row;
        this.col = col;
        this.field = field;
    }

    public Position (Field field) {
        this.field = field;
        col = (int) (Math.random()* field.getCols());
        row = (int) (Math.random()*field.getRows());
    }

    public void setPosition (int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol () {
        return col;
    }

    public int getRow () {
        return row;
    }
}
