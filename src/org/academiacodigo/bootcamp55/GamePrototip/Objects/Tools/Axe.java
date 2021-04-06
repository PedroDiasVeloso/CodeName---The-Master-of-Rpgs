package org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Pickable;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Axe extends Tools implements Pickable, Walkable {

    private boolean isWalkable = false;

    public Axe (Field field, ToolTypes toolType, Position axePosition) {
        super(field, toolType, axePosition);
        picture = new Picture(field.getX() * axePosition.getCol()+field.getPADDING(),
                field.getY() * axePosition.getRow()+field.getPADDING(),
                "axe.png");
    }

    public void setInInventory(){
        inInventory = true;
        isWalkable = true;
        picture.delete();

    }
}
