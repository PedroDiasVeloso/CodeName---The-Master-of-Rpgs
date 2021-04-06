package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy2;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy3;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy4;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Destructible;
import org.academiacodigo.bootcamp55.GamePrototip.Menu.MenuScreen;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.FileManager;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.DestructibleRocks;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.DestructibleTrees;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.Chest;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.ToolTypes;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.Tools;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;


public class Controller implements KeyboardHandler {

    private Keyboard keyboard;
    private Game game;
    private Player player;
    private Levels levels;
    FileManager fileManager;


    public Controller (Game game, Player player,Levels levels,FileManager fileManager) {
        keyboard = new Keyboard(this);
        this.game = game;
        this.player = player;
        this.levels = levels;
        this.fileManager = fileManager;
    }

    public void init () {
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent destroy = new KeyboardEvent();
        destroy.setKey(KeyboardEvent.KEY_D);
        destroy.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(destroy);

        KeyboardEvent pickObject = new KeyboardEvent();
        pickObject.setKey(KeyboardEvent.KEY_P);
        pickObject.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pickObject);

        KeyboardEvent cutTree = new KeyboardEvent();
        cutTree.setKey(KeyboardEvent.KEY_C);
        cutTree.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(cutTree);

        KeyboardEvent openChest = new KeyboardEvent();
        openChest.setKey(KeyboardEvent.KEY_O);
        openChest.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(openChest);

        KeyboardEvent gameStart = new KeyboardEvent();
        gameStart.setKey(KeyboardEvent.KEY_S);
        gameStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(gameStart);

        KeyboardEvent gameInstructions = new KeyboardEvent();
        gameInstructions.setKey(KeyboardEvent.KEY_SPACE);
        gameInstructions.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(gameInstructions);

        KeyboardEvent gameCredits = new KeyboardEvent();
        gameCredits.setKey(KeyboardEvent.KEY_X);
        gameCredits.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(gameCredits);

        KeyboardEvent highScores = new KeyboardEvent();
        highScores.setKey(KeyboardEvent.KEY_H);
        highScores.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(highScores);

        KeyboardEvent backToOpening = new KeyboardEvent();
        backToOpening.setKey(KeyboardEvent.KEY_Q);
        backToOpening.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(backToOpening);

        KeyboardEvent cheat = new KeyboardEvent();
        cheat.setKey(KeyboardEvent.KEY_Z);
        cheat.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(cheat);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        GameObjects[][] thisLevel = levels.getLevels();

        switch (keyboardEvent.getKey()) {
            // MENU CONTROLS
            case KeyboardEvent.KEY_S:
                if(game.getGameState() == GameState.MENU_OPENING) {
                    game.setGameState(GameState.PLAYING);
                    game.start();
                    player.repaintPlayer(4*32+32,6*32+32);


                }
                break;
            case KeyboardEvent.KEY_SPACE:
                if(game.getGameState().equals(GameState.MENU_OPENING)) {
                    game.setGameState(GameState.MENU_INSTRUCTIONS);
                    game.getMenu().setScreen(MenuScreen.INSTRUCTIONS);
                    game.getMenu().showScreen();
                } else if(game.getGameState().equals(GameState.MENU_INSTRUCTIONS)) {
                    game.setGameState(GameState.MENU_OPENING);
                    game.getMenu().setScreen(MenuScreen.OPENING);
                    game.getMenu().showScreen();
                }
                break;
            case KeyboardEvent.KEY_X:
                if(game.getGameState().equals(GameState.MENU_OPENING)) {
                    game.setGameState(GameState.MENU_CREDITS);
                    game.getMenu().setScreen(MenuScreen.CREDITS);
                    game.getMenu().showScreen();
                } else if(game.getGameState().equals(GameState.MENU_CREDITS)) {
                    game.setGameState(GameState.MENU_OPENING);
                    game.getMenu().setScreen(MenuScreen.OPENING);
                    game.getMenu().showScreen();
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(thisLevel[player.getPlayerPosition().getCol() + 1][player.getPlayerPosition().getRow()].isWalkable()){
                    player.moveRight();
                    System.out.println(player.getPlayerPosition().getCol());
                    System.out.println(player.getPlayerPosition().getRow());

                }
                else{
                    System.out.println("Not moving!");
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if(thisLevel[player.getPlayerPosition().getCol() - 1][player.getPlayerPosition().getRow()].isWalkable()) {
                    player.moveLeft();
                    System.out.println(player.getPlayerPosition().getCol());
                    System.out.println(player.getPlayerPosition().getRow());
                }
                else{
                    System.out.println("Not moving!");
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow() + 1].isWalkable()) {
                    player.moveDown();
                    System.out.println(player.getPlayerPosition().getCol());
                    System.out.println(player.getPlayerPosition().getRow());
                }
                else{
                    System.out.println("Not moving");
                }
                break;
            case KeyboardEvent.KEY_UP:
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow() - 1].isWalkable()) {
                    player.moveUp();
                    System.out.println(player.getPlayerPosition().getCol());
                    System.out.println(player.getPlayerPosition().getRow());
                }
                else{
                    System.out.println("Not moving!");
                }
                break;
            case KeyboardEvent.KEY_D:
                if(thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()] instanceof DestructibleRocks && player.getHaveHammer()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()] instanceof DestructibleRocks && player.getHaveHammer()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1] instanceof DestructibleRocks && player.getHaveHammer()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1] instanceof DestructibleRocks && player.getHaveHammer()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).isDestroyed();
                }
                else{
                    System.out.println("Can't break it!");
                }
                break;
            case KeyboardEvent.KEY_P:
                if(thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()] instanceof Tools){
                    ((Tools) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).setInInventory();
                    if(((Tools) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.HAMMER){
                        player.setHaveHammer(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.AXE){
                        player.setHaveAxe(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.KEY){
                        player.setHaveKey(true);
                    }

                }



                else if(thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()] instanceof Tools){
                    ((Tools) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).setInInventory();
                    if(((Tools) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.HAMMER){
                        player.setHaveHammer(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.AXE){
                        player.setHaveAxe(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).toolType()
                            == ToolTypes.KEY){
                        player.setHaveKey(true);
                    }
                }



                else if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1] instanceof Tools){
                    ((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).setInInventory();
                    if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).toolType()
                            == ToolTypes.HAMMER){
                        player.setHaveHammer(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).toolType()
                            == ToolTypes.AXE){
                        player.setHaveAxe(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).toolType()
                            == ToolTypes.KEY){
                        player.setHaveKey(true);
                    }
                }



                else if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1] instanceof Tools){
                    ((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).setInInventory();
                    if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).toolType()
                            == ToolTypes.HAMMER){
                        player.setHaveHammer(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).toolType()
                            == ToolTypes.AXE){
                        player.setHaveAxe(true);
                    }
                    else if(((Tools) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).toolType()
                            == ToolTypes.KEY){
                        player.setHaveKey(true);
                    }
                }
                break;
            case KeyboardEvent.KEY_C:
                if(thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()] instanceof DestructibleTrees && player.getHaveAxe()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()] instanceof DestructibleTrees && player.getHaveAxe()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1] instanceof DestructibleTrees && player.getHaveAxe()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).isDestroyed();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1] instanceof DestructibleTrees && player.getHaveAxe()){
                    ((Destructible) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).isDestroyed();
                }
                else{
                    System.out.println("cant do that");
                }
                break;
            case KeyboardEvent.KEY_O:
                if(thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()] instanceof Chest && player.getHaveKey()){
                    ((Chest) thisLevel[player.getPlayerPosition().getCol()+1][player.getPlayerPosition().getRow()]).open();
                }
                if(thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()] instanceof Chest && player.getHaveKey()){
                    ((Chest) thisLevel[player.getPlayerPosition().getCol()-1][player.getPlayerPosition().getRow()]).open();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1] instanceof Chest && player.getHaveKey()){
                    ((Chest) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()+1]).open();
                }
                if(thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1] instanceof Chest && player.getHaveKey()){
                    ((Chest) thisLevel[player.getPlayerPosition().getCol()][player.getPlayerPosition().getRow()-1]).open();
                }
                else{
                    System.out.println("NO");

                }
                if(((Chest) thisLevel[10][6]).getIsOpen()){
                    game.setGameState(GameState.ENDGAME);
                    Picture picture = new Picture(32,32,"menu_gamewon.png");
                    picture.draw();
                    String steps = String.valueOf(player.getWalkedSteps());
                    fileManager.writing(steps);
                    fileManager.closing();
                    fileManager.transfer();
                }
                break;

            case KeyboardEvent.KEY_H:
                    Picture picture = new Picture(32, 32, "highscore.png");
                    picture.draw();
                    fileManager.reading();
                    break;

            case KeyboardEvent.KEY_Q:
                game.setGameState(GameState.MENU_OPENING);
                Picture picture1 = new Picture(32,32,"menu_initial_opening.png");
                picture1.draw();
                player.setPlayerPosition(4,6);
                player.setHaveAxe(false);
                player.setHaveHammer(false);
                player.setHaveKey(false);
                player.resetSteps();
                break;

            case KeyboardEvent.KEY_Z:
                player.setHaveAxe(true);
                player.setHaveHammer(true);
                player.setHaveKey(true);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
