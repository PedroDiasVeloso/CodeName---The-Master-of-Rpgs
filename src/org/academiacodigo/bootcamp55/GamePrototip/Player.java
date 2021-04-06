package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObjects {

    private Frame frame;
    private boolean haveAxe = false;
    private boolean haveHammer = false;
    private boolean haveKey = false;
    private int walkedSteps = 0;




    public Player (Field field, Frame frame) {
        super(field, new Position(4,6,field));
        this.frame = frame;
        picture = new Picture(position.getCol() * field.getCELLSIZE() + field.getPADDING(),
                position.getRow() * field.getCELLSIZE() + field.getPADDING(),
                "player.png");
    }

    public void init() {
        picture.draw();
    }

    public void moveUp () {
        position.setPosition(position.getCol(),position.getRow()-1);
        walkedSteps++;
        System.out.println("one step");
        getWalkedSteps();

        //if(position.getRow() < frame.getPosition().getRow()) {
        //    frame.moveFrame(Direction.UP);
        //    repaintPlayer((position.getCol() - frame.getPosition().getCol())* field.getCELLSIZE() + field.getPADDING(), (Frame.ROWS - 1) * field.getCELLSIZE() + field.getPADDING());
        //    return;
        //}

        picture.translate(0, -32);

        //repaintPlayer();
       /* try{
            Thread.sleep(150);
        }
        catch (InterruptedException e){
            System.out.println("Cant stop");
        }*/
    }

    public void moveDown () {
        position.setPosition(position.getCol(), position.getRow()+1);
        walkedSteps++;
        System.out.println("one step");
        getWalkedSteps();

        //if(position.getRow() >= frame.getPosition().getRow() + Frame.ROWS) {
        //    frame.moveFrame(Direction.DOWN);
        //    repaintPlayer((position.getCol() - frame.getPosition().getCol())* field.getCELLSIZE() + field.getPADDING(), field.getPADDING());
        //    return;
        //}

        picture.translate(0, 32);
        //repaintPlayer();
       /* try{
            Thread.sleep(150);
        }
        catch (InterruptedException e){
            System.out.println("Cant stop");
        }*/

    }

    public void moveRight () {
        position.setPosition(position.getCol()+1, position.getRow());
        walkedSteps++;
        System.out.println("one step");
        getWalkedSteps();

        //if(position.getCol() >= frame.getPosition().getCol() + Frame.COLS) {
        //    frame.moveFrame(Direction.RIGHT);
        //    repaintPlayer(field.getPADDING(), (position.getRow() - frame.getPosition().getRow())* field.getCELLSIZE() + field.getPADDING());
        //    return;
        //}

        picture.translate(32, 0);

        //repaintPlayer();
        /*try{
            Thread.sleep(150);
        }
        catch (InterruptedException e){
            System.out.println("Cant stop");
        }*/
    }

    public void moveLeft () {
        position.setPosition(position.getCol()-1, position.getRow());
        walkedSteps++;
        System.out.println("one step");
        getWalkedSteps();

        //if(position.getCol() < frame.getPosition().getCol()) {
        //    frame.moveFrame(Direction.LEFT);
        //    repaintPlayer((Frame.COLS - 1) * field.getPADDING() + field.getPADDING(), (position.getRow() - frame.getPosition().getRow())* field.getCELLSIZE() + field.getPADDING());
        //    return;
        //}

        picture.translate(-32, 0);

        //repaintPlayer();
        /*try{
            Thread.sleep(150);
        }
        catch (InterruptedException e){
            System.out.println("Cant stop");
        }*/

    }

    public int getWalkedSteps () {
        System.out.println(walkedSteps);
        return walkedSteps;
    }

    public void resetSteps(){
        walkedSteps = 0;
    }


    private void repaintPlayer() {
        picture.delete();
        picture = new Picture (field.colToX(position.getCol() - frame.getPosition().getCol()),
                field.rowToY(position.getRow() - frame.getPosition().getRow()),
                "player.png");
        picture.draw();
    }

    public void repaintPlayer(int x, int y) {
        picture.delete();
        picture = new Picture (x, y, "player.png");
        picture.draw();
    }

    public Position getPlayerPosition(){
        return position;
    }

    public void setPlayerPosition(int col, int row){
        position.setPosition(col, row);
    }

    public Field getField (){
        return field;
    }

    public void setHaveAxe(boolean state){
        haveAxe = state;
    }

    public void setHaveHammer(boolean state){
        haveHammer = state;
    }

    public void setHaveKey(boolean state){
        haveKey = state;
    }

    public boolean getHaveAxe(){
        return haveAxe;
    }

    public boolean getHaveHammer(){
        return haveHammer;
    }

    public boolean getHaveKey(){
        return haveKey;
    }



}
