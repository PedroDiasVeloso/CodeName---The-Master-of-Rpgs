package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Watter extends GameObjects implements Walkable {

    public boolean isWalkable(){
        return false;
    }

    public Watter(Field field, Position watterPosition) {
        super(field, watterPosition);
        picture = new Picture(field.getX() * watterPosition.getCol()+field.getPADDING(),
                field.getY() * watterPosition.getRow()+field.getPADDING(),
                "water.png");
    }
}



