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

    public Map(){
        rooms = new ArrayList<Room>();
        currentRoom = new Room("0", "Foyer", "This is the entrance", false);
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setCurrentRoom(String roomId){
        // Sets the current room based on the Id
        for(Room room : rooms){
            if(room.getId().equals(roomId)){
                this.currentRoom = room;
            }
        }
    }

    public void addRoom(Room room){
        // Adds a room to the map.
        if(room != null && !rooms.contains(room)){
            rooms.add(room);
        }     
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

