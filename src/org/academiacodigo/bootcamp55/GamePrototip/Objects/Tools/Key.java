package org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Pickable;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Key extends Tools implements Pickable, Walkable {

    private boolean isWalkable = false;

    public void setInInventory(){
        inInventory = true;
        isWalkable = true;
        picture.delete();
    }

    public Key(Field field, ToolTypes toolType, Position keyPosition) {
        super(field, toolType, keyPosition);
        picture = new Picture(field.getX() * keyPosition.getCol()+field.getPADDING(),
                field.getY() * keyPosition.getRow()+field.getPADDING(),
                "key.png");
    }
}
