
package org.academiacodigo.bootcamp55.GamePrototip.Objects;
import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ground extends GameObjects implements Walkable {

    private boolean isWalkable = true;

    public Ground (Field field,Position groundPosition){
        super(field, groundPosition);
        picture = new Picture(field.getX()*groundPosition.getCol()+field.getPADDING(),
                field.getY()* groundPosition.getRow()+field.getPADDING(),
                "ground.png");
    }

    @Override
    public boolean isWalkable() {
        return true;
    }
}


