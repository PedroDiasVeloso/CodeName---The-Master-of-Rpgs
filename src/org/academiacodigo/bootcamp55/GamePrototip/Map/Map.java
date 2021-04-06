package org.academiacodigo.bootcamp55.GamePrototip.Map;

import org.academiacodigo.bootcamp55.GamePrototip.*;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.*;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools.*;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.DestructibleTrees;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.Trees;

public class Map extends Field {

    private final Levels levelOne;
    private Position position;

    //org.academiacodigo.bootcamp55.GamePrototip.Game Objects
    private GameObjects gameObjects;

    public Map(int columns, int rows) {
        super(columns, rows);
        levelOne = new Levels();
    }

    @Override
    public void init() {
        super.init();
        System.out.println("map init");
        getGround();
        firstQuadrantMap();
        secondQuadrantMap();
        thirdQuadrantMap();
        fourthQuadrantMap();
    }

    public Levels getLevelOne() {
        return levelOne;
    }

    public GameObjects[][] getObjects() {
        return levelOne.getLevels();
    }

    public void getGround () {
        for (int column = 0; column < getCols(); column++) {
            for (int row = 0; row < getRows(); row++) {
                position = new Position(column, row, this);
                gameObjects = new Ground(this, position);
                levelOne.getLevels()[column][row] = gameObjects;
            }
        }
    }

    public void firstQuadrantMap () {
        firstPartTrees();
        firstPartRocks();
        firstPartWater();
        getChest();
    }

    public void secondQuadrantMap () {
        secondPartTrees();
        secondPartRocks();
        secondPartWater();
        getKey(41,2);
    }

    public void thirdQuadrantMap () {
        thirdPartTrees();
        thirdPartRocks();
        thirdPartWater();
        getHammer(10, 19);
    }

    public void fourthQuadrantMap () {
        fourthPartTrees();
        fourthPartRocks();
        fourthPartWater();
        getAxe(38, 19);
    }

    //Getting all the trees!
    public void drawTrees (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Trees(this, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void firstPartTrees () {
        //Border Trees first
        for (int column = 0; column < 23; column++) {
            drawTrees(column, 0);
        }
        for (int row = 0; row < 13; row++) {
            drawTrees(0, row);
        }
        for (int column = 1; column < 3; column++) {
            for (int row = 1; row < 3; row++) {
                drawTrees(column, row);
            }}
        drawTrees(1,9);
        drawTrees(1,12);
        for (int column = 1; column < 4; column++) {
            for (int row = 10; row < 12; row++) {
                drawTrees(column, row);
            }}
        drawTrees(9,7);
        drawTrees(11,5);
        for (int column = 14; column < 18; column++) {
            drawTrees(column, 1);
        }
        for (int column = 13; column < 17; column++) {
            drawTrees(column, 2);
        }
        drawTrees(15,3);
        drawTrees(16, 3);
        drawTrees(14,4);
        drawTrees(15,4);
        drawTrees(15,5);
        drawTrees(16,5);
        drawTrees(16,6);
        drawTrees(17,9);
        drawTrees(19,6);
        drawTrees(20,6);
        drawTrees(21,6);
        drawTrees(20,5);
        for (int column = 4; column < 6; column++) {
            for (int row = 1; row < 3; row++) {
                drawTrees(column, row);
            }}
        for (int column = 6; column < 8; column++) {
            for (int row = 2; row < 4; row++) {
                drawTrees(column, row);
            }}
        for (int row = 10; row < 12; row++) {
            drawTrees(4, row);
        }
        for (int column = 7; column < 13; column++) {
            drawTrees(column, 11);
        }
        drawTrees(7, 1);
        drawTrees(3, 1);
        for (int row = 5; row < 8; row++) {
            drawTrees(8, row);
        }
        for (int row = 5; row < 8; row++) {
            drawTrees(12, row);
        }
        destructibleTrees(9,5);
        destructibleTrees(11,7);
        destructibleTrees(22,1);
        destructibleTrees(22,2);
        destructibleTrees(10, 4);
        destructibleTrees(10, 8);
        destructibleTrees(8, 12);
    }

    public void secondPartTrees () {
        //Border trees first
        for (int column = 23; column < getCols(); column++) {
            drawTrees(column, 0);
        }
        for (int row = 0; row < 13; row++) {
            drawTrees(getCols()-1, row);
        }
        drawTrees(25,2);
        drawTrees(26,2);
        drawTrees(26,3);
        drawTrees(26,4);
        drawTrees(27,4);
        for (int column = 42; column < 45; column++) {
            for (int row = 1; row < 5; row++) {
                drawTrees(column, row);
            }}
        drawTrees(40,1);
        drawTrees(41,1);
        drawTrees(37,3);
        drawTrees(41,3);
        for (int column = 38; column < 45; column++) {
            drawTrees(column, 4);
        }
        drawTrees(42,5);
        drawTrees(44,5);
        for (int column = 40; column < 43; column++) {
            drawTrees(column, 6);
        }
        drawTrees(44,10);
        for (int column = 42; column < 45; column++) {
            drawTrees(column, 11);
        }
        for (int column = 40; column < 45; column++) {
            drawTrees(column, 12);
        }
        for (int column = 30; column < 33; column++) {
            for (int row = 8; row < 11; row++) {
                drawTrees(column, row);
            }}
        drawTrees(30,7);
        drawTrees(31,7);
        drawTrees(33,7);
        drawTrees(33, 9);
        for (int column = 33; column < 36; column++) {
            drawTrees(column,10);
        }
        drawTrees(30,11);
        drawTrees(31,11);
        drawTrees(33,11);
        drawTrees(36,11);
        drawTrees(28,9);
        drawTrees(28,10);
        drawTrees(28,11);
        destructibleTrees(23,1);
        destructibleTrees(24,1);
        destructibleTrees(25,1);
        destructibleTrees(33,8);
        destructibleTrees(34,9);
        destructibleTrees(38,2);
        destructibleTrees(38,3);
        destructibleTrees(40,3);
    }

    public void thirdPartTrees () {
        //Border trees first
        for (int column = 0; column < 23; column++) {
            drawTrees(column, getRows()-1);
        }
        for (int row = 13; row < getRows(); row++) {
            drawTrees(0, row);
        }
        drawTrees(1,13);
        drawTrees(2,18);
        drawTrees(3,18);
        drawTrees(18,19);
        for (int column = 1; column < 3; column++) {
            for (int row = 14; row < 18; row++) {
                drawTrees(column, row);
            }}
        drawTrees(7,15);
        drawTrees(7,18);
        drawTrees(11,17);
        drawTrees(11,19);
        drawTrees(11,20);
        drawTrees(10,20);
        drawTrees(10,21);
        for (int column = 8; column < 11; column++){
            for (int row = 15; row < 19; row++){
                drawTrees(column, row);
            }}
        for (int column = 1; column < 3; column++) {
            for (int row = 21; row < 25; row++) {
                drawTrees(column, row);
            }}
        for (int column = 3; column < 7; column++) {
            drawTrees(column, 24);
        }
        drawTrees(6,23);
        drawTrees(4, 13);
        drawTrees(4, 14);
        drawTrees(5,14);
        drawTrees(6, 13);
        drawTrees(8, 13);
        destructibleTrees(9,19);
        destructibleTrees(8,19);
        destructibleTrees(9,20);
        destructibleTrees(11,18);
        destructibleTrees(12,18);
        destructibleTrees(6, 14);
        destructibleTrees(7, 13);
    }

    public void fourthPartTrees() {
        //Border trees first
        for (int column = 23; column < getCols(); column++) {
            drawTrees(column, getRows()-1);
        }
        for (int row = 13; row < getRows(); row++) {
            drawTrees(getCols()-1, row);
        }
        drawTrees(40,17);
        for (int column = 33; column < 36; column++) {
            for (int row = 17; row < 21; row++) {
                drawTrees(column, row);
            }
        }
        for (int column = 35; column < 40; column++) {
            drawTrees(column, 22);
        }
        for (int column = 35; column < 40; column++) {
            drawTrees(column, 15);
        }
        for (int column = 34; column < 40; column++) {
            drawTrees(column, 16);
        }
        drawTrees(33,21);
        drawTrees(34,21);
        drawTrees(36,21);
        drawTrees(39, 21);
        drawTrees(40,21);
        drawTrees(40,20);
        drawTrees(41,20);
        drawTrees(41,19);
        drawTrees(40, 13);
        drawTrees(43,13);
        drawTrees(44,13);
        drawTrees(44,14);
        drawTrees(29, 15);
        drawTrees(29,17);
        drawTrees(30,16);
        drawTrees(30,17);
        destructibleTrees(35,16);
        destructibleTrees(39,16);
        destructibleTrees(37,17);
    }

    public void destructibleTrees(int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new DestructibleTrees(this, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    //Getting the lake!
    public void drawLake (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Watter(this, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void firstPartWater () {
        for (int column = 19; column < 23; column++) {
            for (int row = 7; row < 13; row++) {
                drawLake(column, row);
            }}
        for (int row = 3; row < 7; row++) {
            drawLake(22, row);
        }
        drawLake(21,4);
        drawLake(21,5);
        for (int column = 17; column < 19; column++) {
            for (int row = 10; row < 13; row++) {
                drawLake(column, row);
            }}
        drawLake(16,11);
        drawLake(16,12);
        drawLake(18, 9);
    }

    public void secondPartWater () {
        for (int column = 18; column < 23; column++) {
            for (int row = 13; row < 18; row++) {
                drawLake(column, row);
            }}
        for (int column = 19; column < 23; column++) {
            for (int row = 18; row < 21; row++) {
                drawLake(column, row);
            }}
        drawLake(17,13);
        drawLake(17,15);
        drawLake(17,16);
        drawLake(18,20);
        drawLake(22,21);
    }

    public void thirdPartWater () {
        for (int column = 23; column < 27; column++) {
            for (int row = 7; row < 13; row++) {
                drawLake(column, row);
            }}
        for (int column = 23; column < 25; column++) {
            for (int row = 2; row < 7; row++) {
                drawLake(column, row);
            }}
        drawLake(25,6);
        for (int row = 9; row < 12; row++) {
            drawLake(27, row);
        }
        for (int column = 3; column < 6; column++) {
            for (int row = 22; row < 24; row++) {
                drawLake(column, row);
            }}
        drawLake(3, 21);
    }

    public void fourthPartWater () {
        for (int column = 23; column < 27; column++) {
            for (int row = 13; row < 19; row++) {
                drawLake(column, row);
            }}
        for (int column = 23; column < 25; column++) {
            for (int row = 19; row < 21; row++) {
                drawLake(column, row);
            }}
        for (int column = 27; column < 29; column++) {
            for (int row = 17; row < 19; row++) {
                drawLake(column, row);
            }}
        drawLake(27, 15);
        drawLake(27,16);
        drawLake(25,19);
        drawLake(29, 18);
    }

    //Getting all the rocks!
    public void drawRocks (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Rocks(this, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void destructibleRocks(int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new DestructibleRocks(this, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void firstPartRocks() {
        drawRocks(10, 5);
        drawRocks(9, 6);
        drawRocks(11, 6);
        drawRocks(15, 11);
        drawRocks(15, 12);
        destructibleRocks(10,7);
    }

    public void secondPartRocks() {
        drawRocks(28, 4);
        drawRocks(28, 5);
        drawRocks(27, 5);
        drawRocks(37, 9);
        drawRocks(39, 2);
        destructibleRocks(40,2);
        destructibleRocks(39,3);
        destructibleRocks(38,1);
    }

    public void thirdPartRocks() {
        drawRocks(15,13);
        drawRocks(16,13);
        drawRocks(16,14);
        drawRocks(17,14);
        drawRocks(17,17);
        drawRocks(17,18);
        drawRocks(18,18);
        drawRocks(6,22);
        drawRocks(4,21);
    }

    public void fourthPartRocks() {
        drawRocks(28, 15);
        drawRocks(28, 16);
        drawRocks(30, 15);
        drawRocks(29, 16);
        drawRocks(31, 17);
        drawRocks(35, 21);
        drawRocks(39, 17);
    }

    //Getting all the tools!
    public void getAxe (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Axe(this, ToolTypes.AXE, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void getHammer (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Hammer(this, ToolTypes.HAMMER, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void getKey (int column, int row) {
        position = new Position(column, row, this);
        gameObjects = new Key(this, ToolTypes.KEY, position);
        levelOne.getLevels()[column][row] = gameObjects;
    }

    public void getChest(){
        position = new Position(10,6,this);
        gameObjects = new Chest(this,position);
        levelOne.getLevels()[10][6] = gameObjects;
    }

}
