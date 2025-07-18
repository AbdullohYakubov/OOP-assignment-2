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
    private int score = 10;
    private ArrayList<Item> inventory;
    private ArrayList<Equipment> equipment;

    public Player(){}

    public Player(String name){
        this.name = name;
        inventory = new ArrayList<Item>();
        equipment = new ArrayList<Equipment>();
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void addScore(int score){
        this.score += score;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public Item getItem(String itemName){
        // Retrieves an item from the player's inventory by its name.
        if(!inventory.isEmpty()){
            for(Item item : inventory){
                if(item.getName().equals(itemName)){
                    return item;
                }
            }
        }

        return null;
    }

    public boolean hasItem(String itemName){
        // Checks if the player has an item with the specified name in their inventory.
        if(!inventory.isEmpty()){
            for(Item item : inventory){
                if(item.getName().equalsIgnoreCase(itemName)){
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public void addItem(Item item){
        // Adds an item to the player's inventory.
        if(item != null && !inventory.contains(item)){
            inventory.add(item);
        }else{
            System.out.println("There is no such an item or you already have it!");
        }
    }

    public ArrayList<Equipment> getEquipment(){
        return equipment;
    }

    public Equipment getEquipment(String equipmentName){
        if(!equipment.isEmpty()){
            for(Equipment e : equipment){
                if(e.getName().equals(equipmentName)){
                    return e;
                }
            }
        }

        return null;
    }

    public boolean hasEquipment(String equipmentName){
        // Checks if the player has equipment with the specified name.
        if(!equipment.isEmpty()){
            for(Equipment e : equipment){
                if(e.getName().equals(equipmentName)){
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    public void addEquipment(Equipment equipment){
        // Adds a piece of equipment to the player's collection.
        if(equipment != null && !this.equipment.contains(equipment)){
            this.equipment.add(equipment);
        }else{
            System.out.println("There is no such a piece of equipment or you already have it!");
        }
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
        out.append("Player score: " + this.score);
        return out.toString();
    }
}