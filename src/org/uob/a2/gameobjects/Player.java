package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents the player in the game, including their name, inventory, and equipment.
 * 
 * <p>
 * The player can carry items and equipment, interact with the game world, and perform
 * actions using their inventory or equipment.
 * </p>
 */
public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private ArrayList<Equipment> equipment;
    private Item item;
    private Equipment e;

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public boolean hasItem(String itemName){
        return false; // Checks if the player has an item with the specified name in their inventory.
    }

    // public Item getItem(String itemName){
    //     // Retrieves an item from the player's inventory by its name.
    // }

    public Item getItem(){
        return this.item;
    }

    public void addItem(Item item){
        // Adds an item to the player's inventory.
    }

    public ArrayList<Equipment> getEquipment(){
        return equipment;
    }

    public boolean hasEquipment(String equipmentName){
        return false; // Checks if the player has equipment with the specified name.
    }

    public Equipment getEquipement(String equipmentName){
        return e;
    } 

    public void addEquipment(Equipment equipment){
        // Adds a piece of equipment to the player's collection.
    }



    /**
     * Returns a string representation of the player's current state, including their name,
     * inventory, and equipment descriptions.
     *
     * @return a string describing the player, their inventory, and equipment
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipment) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
