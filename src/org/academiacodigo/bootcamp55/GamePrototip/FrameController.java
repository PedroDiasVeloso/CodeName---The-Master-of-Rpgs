package org.academiacodigo.bootcamp55.GamePrototip;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

//Never used, possible delete?!?
public class FrameController implements KeyboardHandler {

    private Keyboard keyboard;
    private Frame frame;

    public FrameController(Frame frame) {
        keyboard = new Keyboard(this);
        this.frame = frame;
    }

    public void init(){

        KeyboardEvent press_right = new KeyboardEvent();
        press_right.setKey(KeyboardEvent.KEY_RIGHT);
        press_right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent press_left = new KeyboardEvent();
        press_left.setKey(KeyboardEvent.KEY_LEFT);
        press_left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent press_down= new KeyboardEvent();
        press_down.setKey(KeyboardEvent.KEY_DOWN);
        press_down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent press_up = new KeyboardEvent();
        press_up.setKey(KeyboardEvent.KEY_UP);
        press_up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(press_right);
        keyboard.addEventListener(press_left);
        keyboard.addEventListener(press_down);
        keyboard.addEventListener(press_up);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                frame.moveFrame(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_UP:
                frame.moveFrame(Direction.UP);
                break;
            case KeyboardEvent.KEY_RIGHT:
                frame.moveFrame(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                frame.moveFrame(Direction.LEFT);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
