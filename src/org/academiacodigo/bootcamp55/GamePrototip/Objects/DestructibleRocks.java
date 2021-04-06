package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Destructible;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DestructibleRocks extends GameObjects implements Destructible {

    public DestructibleRocks(Field field, Position rockPosition) {
        super(field, rockPosition);
        picture = new Picture(field.getCELLSIZE()*rockPosition.getCol() + field.getPADDING(),
                field.getCELLSIZE()* rockPosition.getRow() + field.getPADDING(),
                "rock1.png");
    }

    @Override
    public void isDestroyed() {
        isDestroyed = true;
        picture.delete();
        isWalkable = true;
    }

    @Override
    public boolean getDestroyed() {
        return isDestroyed;
    }

    public boolean isWalkable(){
        return isWalkable;
    }
}
