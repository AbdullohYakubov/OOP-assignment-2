package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents an exit in the game, allowing the player to move from one room to another.
 * 
 * <p>
 * Exits have a destination (next room), a description, and can be hidden or visible based on game logic.
 * </p>
 */
public class Exit extends GameObject {

    private String nextRoom;
    // private ArrayList<String> exits;
   
    public Exit(String id, String name, String description, boolean hidden, String nextRoom){
        super(id, name, description, hidden);
        this.nextRoom = nextRoom;

        // exits = new ArrayList<>();
        // exits.add("north");
        // exits.add("south");
        // exits.add("east");
        // exits.add("west");
    }

    public String getNextRoom(){
        return this.nextRoom;
    }

    /**
     * Returns a string representation of the exit, including attributes inherited from {@code GameObject}
     * and the identifier of the next room.
     *
     * @return a string describing the exit
     */

    @Override
    public String toString() {
        return super.toString() + ", nextRoom=" + nextRoom;
    }
}
