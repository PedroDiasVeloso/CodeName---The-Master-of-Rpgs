package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Destructible;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class DestructibleTrees extends GameObjects implements Destructible,Walkable{

    public boolean isWalkable(){
        return isWalkable;
    }

    public DestructibleTrees(Field field, Position treePosition) {
        super(field, treePosition);
        picture = new Picture(field.getCELLSIZE()*treePosition.getCol() + field.getPADDING(),
                field.getCELLSIZE()* treePosition.getRow() + field.getPADDING(),
                "tree1.png");
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
}
