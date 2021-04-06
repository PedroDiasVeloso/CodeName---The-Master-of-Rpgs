package org.academiacodigo.bootcamp55.GamePrototip.Objects.Tools;


import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiacodigo.bootcamp55.GamePrototip.Interfaces.Walkable;
import org.academiacodigo.bootcamp55.GamePrototip.Objects.GameObjects;
import org.academiacodigo.bootcamp55.GamePrototip.Position;

public class Tools extends GameObjects implements Walkable {

    protected ToolTypes toolType;
    protected boolean inInventory = false;
    private boolean isWalkable = false;

    public boolean isWalkable(){
        return true;
    }

    public Tools (Field field, ToolTypes toolType , Position toolPosition){
        super(field, toolPosition);
        this.toolType = toolType;
    }

    public void setInInventory(){
        picture.delete();
        inInventory = true;
        isWalkable = true;
    }

    public boolean isInInventory() {
        return inInventory;
    }

    public ToolTypes toolType (){
        return toolType;
    }
}
