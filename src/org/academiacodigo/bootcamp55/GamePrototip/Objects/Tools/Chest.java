package org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Chest extends GameObjects {

    private boolean isOpen = false;

    public Chest(Field field, Position position){
        super(field, position);
        picture = new Picture(field.getCELLSIZE()*position.getCol() + field.getPADDING(),
                field.getCELLSIZE()* position.getRow() + field.getPADDING(),
                "cofre.png");
    }

    public void open(){
        picture.delete();
        isOpen = true;
    }

    public boolean getIsOpen() {
        return isOpen;
    }


}
