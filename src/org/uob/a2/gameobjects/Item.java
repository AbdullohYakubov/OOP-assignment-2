package org.uob.a2.gameobjects;

/**
 * Represents an item in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * Items can be collected, used, or interacted with by the player.
 * This class inherits common properties from {@code GameObject}.
 * </p>
 */
public class Item extends GameObject {

     /**
     * Returns a string representation of the item by calling the superclass's {@code toString} method.
     *
     * @return a string describing the item
     */

    public Item(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public boolean getHidden(){
        return this.hidden;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
