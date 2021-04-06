package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy2;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy3;
import org.academiacodigo.bootcamp55.GamePrototip.Enemies.Enemy4;
import org.academiacodigo.bootcamp55.GamePrototip.Map.Map;
import org.academiacodigo.bootcamp55.GamePrototip.Menu.Menu;
import org.academiacodigo.bootcamp55.GamePrototip.Menu.MenuScreen;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.FileManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Game {

    private Menu menu;
    private Map field;
    private Frame frame;
    private Controller controller;
    private Player player;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;
    private ColisionDetector colisionDetector;

    private GameState gameState;

    public void init() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioPlayer audioPlayer = new AudioPlayer("/audio/cembalo-hill.wav");
        audioPlayer.play();

        field = new Map (46,26);
        frame = new Frame(field, field.getObjects());
        player = new Player(field, frame);
        enemy = new Enemy(field,8,8);
        enemy2 = new Enemy2(field,14,22);
        enemy3 = new Enemy3(field,42,16);
        enemy4 = new Enemy4(field,37,6);
        FileManager fileManager = new FileManager(field);
        controller = new Controller(this, player, field.getLevelOne(),fileManager);
        controller.init();



        gameState = GameState.MENU_OPENING;

        menu = new Menu(field.getPADDING(), field.getPADDING(), MenuScreen.OPENING);
        menu.showScreen();


        colisionDetector = new ColisionDetector(enemy,player,enemy2,enemy3,enemy4);
        colisionDetector.theMovement();

    }

    public void start() {
        field.init();
        frame.focus();
        player.init();
        Thread thread = new Thread(enemy);
        Thread thread1 = new Thread(enemy2);
        Thread thread2 = new Thread(enemy3);
        Thread thread3 = new Thread(enemy4);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();


    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Menu getMenu() {
        return menu;
    }

}
