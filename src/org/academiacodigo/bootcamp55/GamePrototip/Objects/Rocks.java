package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rocks extends GameObjects {

    public Rocks (Field field, Position rockPosition) {
        super(field, rockPosition);
        picture = new Picture(field.getCELLSIZE()*rockPosition.getCol() + field.getPADDING(),
                field.getCELLSIZE()* rockPosition.getRow() + field.getPADDING(),
                "rock.png");
    }
}
