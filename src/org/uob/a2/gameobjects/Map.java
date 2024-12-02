package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    private Room currentRoom;
    private ArrayList<Room> rooms;
    
    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */

    public Map(){}

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setCurrentRoom(Room roomId){
        // this.currentRoom = currentRoom;
    }

    public void addRoom(Room room){
        // Adds a room to the map.
    }
    
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

