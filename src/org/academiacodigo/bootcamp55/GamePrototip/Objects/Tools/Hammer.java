package org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Pickable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer extends Tools implements Pickable {


    private boolean isWalkable = false;

    public Hammer(Field field, ToolTypes toolType, Position hammerPosition) {
        super(field, toolType, hammerPosition);
        picture = new Picture(field.getX() * hammerPosition.getCol()+field.getPADDING(),
                field.getY() * hammerPosition.getRow()+field.getPADDING(),
                "picareta.png");
    }

    public void setInInventory(){
        inInventory = true;
        isWalkable = true;
        picture.delete();
    }
}
