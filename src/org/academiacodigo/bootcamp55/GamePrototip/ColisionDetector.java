package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy2;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy3;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy4;

public class ColisionDetector {

    Enemy enemy;
    Enemy2 enemy2;
    Enemy3 enemy3;
    Enemy4 enemy4;
    Player player;



    public ColisionDetector(Enemy enemy, Player player,Enemy2 enemy2,Enemy3 enemy3, Enemy4 enemy4) {
        this.enemy = enemy;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
        this.player = player;
    }

    public void checkColision() {

            if ((enemy.getPosition().getCol() == player.getPlayerPosition().getCol() &&
                    enemy.getPosition().getRow() == player.getPlayerPosition().getRow())
                    ||
                    (enemy2.getPosition().getCol() == player.getPlayerPosition().getCol() &&
            enemy2.getPosition().getRow() == player.getPlayerPosition().getRow())
                    ||
                    (enemy3.getPosition().getCol() == player.getPlayerPosition().getCol() &&
            enemy3.getPosition().getRow() == player.getPlayerPosition().getRow())
                    ||
                    (enemy4.getPosition().getCol() == player.getPlayerPosition().getCol() &&
            enemy4.getPosition().getRow() == player.getPlayerPosition().getRow())) {
                enemy.setTouchPlayer(true);
                System.out.println("Colision!");
                player.setPlayerPosition(2, 4);
                player.repaintPlayer(96, 160);
        }

    }

    public ColisionDetector theMovement() throws InterruptedException{
            enemy.enemyMoving();
            Thread.sleep(200);
            enemy2.enemyMoving();
            Thread.sleep(200);
            enemy3.enemyMoving();
            Thread.sleep(200);
            enemy4.enemyMoving();
            Thread.sleep(200);
            checkColision();
            return theMovement();
    }
}
