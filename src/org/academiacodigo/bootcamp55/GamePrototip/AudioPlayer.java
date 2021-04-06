package org.academiacodigo.bootcamp55.GamePrototip;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AudioPlayer {

    private Clip clip;
    private String status;
    //private AudioInputStream audioInputStream;

    public AudioPlayer(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //InputStream audio = getClass().getResourceAsStream(filePath);
        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audio));

        URL audio = getClass().getResource(filePath);
        System.out.println("Testing" + audio);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audio);
        //clip = AudioSystem.getClip();
        //clip.open(audioInputStream);
        //clip.loop(Clip.LOOP_CONTINUOUSLY);

        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        status = "play";
    }
}
