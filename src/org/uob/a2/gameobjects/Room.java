package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    private ArrayList<Exit> exits;
    private Exit exit;
    private ArrayList<Item> items;
    private Item item;
    private ArrayList<Feature> features;
    private Feature feature;
    private ArrayList<Equipment> equipment;
    private Equipment e;
    private ArrayList<GameObject> gameObjects;

    public Room(){}

    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public ArrayList<Exit> getExits(){
        return exits;
    }

    public Exit getExit(String id){
        return exit; // by Id
    }

    public ArrayList<Feature> getFeatures(){
        return features;
    }

    public Feature getFeature(String id){
        return feature; // by Id
    }

    public Feature getFeatureByName(String name){
        return feature;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(String id){
        return item; // Retrieves an item by its ID.
    }

    public Item getItemByName(String name){
        return item; // Retrieves an item by its ID.
    }

    public ArrayList<Equipment> getEquipments(){
        return equipment;
    }

    public Equipment getEquipment(String id){
        return e; // by Id
    } 

    public Equipment getEquipmentByName(String name){
        return e; // by name
    }

    public ArrayList<GameObject> getAll(){
        return gameObjects;
    } 

    public void addExit(Exit exit){
        // Adds an exit to the room.
    }

    public void addFeature(Feature feature){
        // Adds a feature to the room.
    }

    public void addItem(Item item){
        // Adds an item to the room.
    }

    public void addEquipment(Equipment equipment){
        // Adds equipment to the room.
    }

    public boolean hasItem(String itemName){
        return false; // Checks if the room contains an item with the specified name.
    }

    public boolean hasEquipment(String name){
        return false; // Checks if the room contains equipment with the specified name.
    }

    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipment) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
