package org.academiacodigo.bootcamp55.GamePrototip.Enemies;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy2 extends GameObjects implements Runnable {


    private boolean touchPlayer = false;



    public Enemy2(Field field, int x, int y) {
        super(field, new Position(x,y,field));
        picture = new Picture(position.getCol() * field.getCELLSIZE() + field.getPADDING(),
                position.getRow() * field.getCELLSIZE() + field.getPADDING(),
                "enemy.png");
    }

    public void setTouchPlayer(boolean touch){
        touchPlayer = touch;
    }


    public boolean getTouchPlayer(){
        return touchPlayer;
    }

    public void init(){
        show();
    }


    public void moveRight(){
        if(position.getCol()<18) {
            position.setPosition(position.getCol()+1,position.getRow());
            picture.translate(32,0);
        }
        else{
            position.setPosition(position.getCol() - 1, position.getRow());
            picture.translate(-32, 0);
        }
    }

    /*public void moveLeft(){
        if(position.getCol()>12) {
            position.setPosition(position.getCol()-1,position.getRow());
            picture.translate(-32,0);
        }
        else{
            position.setPosition(position.getCol() +1, position.getRow());
            picture.translate(32, 0);
        }
    }*/

    public void moveUp(){
        if(position.getRow()>21) {
            position.setPosition(position.getCol(),position.getRow()-1);
            picture.translate(0,-32);
        }
        else{
            position.setPosition(position.getCol(), position.getRow()+1);
            picture.translate(0, 32);
        }
    }

    public void moveDown(){
        if(position.getRow()<23) {
            position.setPosition(position.getCol(),position.getRow()+1);
            picture.translate(0,32);
        }
        else{
            position.setPosition(position.getCol(), position.getRow()-1);
            picture.translate(0, -32);
        }
    }


    public void enemyMoving() throws InterruptedException {
        int random = randomNumber();

        if(random <20){
            moveRight();

        }
        else if (random>21 && random <50){
            moveLeft();

        }
        else if(random>50 && random <75){
            moveUp();

        }
        else{
            moveDown();

        }
    }

    public int randomNumber (){
        return (int) (Math.random() * 100);
    }


    @Override
    public void run() {
        show();
    }
}