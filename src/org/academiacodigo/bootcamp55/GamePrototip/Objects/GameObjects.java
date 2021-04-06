package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Direction;
import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Frame;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.Chest;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.Tools;
import org.academiacodigo.bootcamp55.GamePrototip.Position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {

    protected Position position;
    protected Picture picture;
    protected Field field;
    protected boolean isDestroyed;
    protected boolean isWalkable = false;

    public GameObjects(Field field, Position position) {
        this.field = field;
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public boolean isWalkable(){
        return isWalkable;
    }

    public void show() {
        if(picture.getX() >= field.colToX(0) && picture.getX() < field.colToX(Frame.COLS) && picture.getY() >= field.rowToY(0) && picture.getY() < field.rowToY(Frame.ROWS)){
            if(!isDestroyed) {
                picture.draw();
            }
            if(this instanceof Tools) {
                if(((Tools) this).isInInventory()) {
                    picture.delete();
                }
            }
            if(this instanceof Chest) {
                if(((Chest) this).getIsOpen()) {
                    picture.delete();
                }
            }
        }
    }

    public void hide() {
        picture.delete();
    }

    public void moveObject(Direction direction) {
        switch (direction) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case DOWN:
                moveDown();
                break;
            case UP:
                moveUp();
                break;
            default:
                break;
        }
    }

    public void moveRight() {
        picture.translate(Frame.COLS * field.getCELLSIZE(), 0);
    }

    public void moveLeft() {
        picture.translate(-Frame.COLS * field.getCELLSIZE(), 0);
    }

    public void moveDown() {
        picture.translate(0, Frame.ROWS * field.getCELLSIZE());
    }

    public void moveUp() {
        picture.translate(0, -Frame.ROWS * field.getCELLSIZE());
    }


}
