package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;

public class Frame {
    private Position position;
    private GameObjects[][] objects;
    public static final int COLS = 46;
    public static final int ROWS = 26;

    public Frame(Field field, GameObjects[][] objects) {
        position = new Position(0, 0, field);
        this.objects = objects;
    }

    public Position getPosition() {
        return position;
    }

    public void moveFrame(Direction direction) {
//        switch (direction) {
//            case UP:
//                unfocus();
//                moveUp();
//                System.out.println(position.getCol() + ", " + position.getRow());
//                moveObjects(Direction.DOWN);
//                focus();
//                break;
//            case DOWN:
//                unfocus();
//                moveDown();
//                System.out.println(position.getCol() + ", " + position.getRow());
//                moveObjects(Direction.UP);
//                focus();
//                break;
//            case RIGHT:
//                unfocus();
//                moveRight();
//                System.out.println(position.getCol() + ", " + position.getRow());
//                moveObjects(Direction.LEFT);
//                focus();
//                break;
//            case LEFT:
//                unfocus();
//                moveLeft();
//                System.out.println(position.getCol() + ", " + position.getRow());
//                moveObjects(Direction.RIGHT);
//                focus();
//                break;
//            default:
//                break;
//        }
    }

    public void unfocus() {
        for (GameObjects[] objectsCol : objects) {
            for (GameObjects object : objectsCol) {
                object.hide();
            }
        }
    }

    public void focus() {
        for (GameObjects[] objectsCol : objects) {
            for (GameObjects object : objectsCol) {
                object.show();
            }
        }
    }

    private void moveObjects(Direction direction) {
        for (GameObjects[] objectsCol : objects) {
            for (GameObjects object : objectsCol) {
                object.moveObject(direction);
            }
            }
    }


    private void moveRight() {
        position.setPosition(position.getCol() + COLS, position.getRow());
    }

    private void moveLeft() {
        position.setPosition(position.getCol() - COLS, position.getRow());
    }

    private void moveDown() {
        position.setPosition(position.getCol(), position.getRow() + ROWS);
    }

    private void moveUp() {
        position.setPosition(position.getCol(), position.getRow() - ROWS);
    }
}