package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Trees extends GameObjects {

    public boolean isWalkable(){
        return isWalkable;
    }

    public Trees(Field field, Position treePosition) {
        super(field, treePosition);
        picture = new Picture(field.getCELLSIZE()*treePosition.getCol() + field.getPADDING(),
                field.getCELLSIZE()* treePosition.getRow() + field.getPADDING(),
                "tree.png");
    }
}
