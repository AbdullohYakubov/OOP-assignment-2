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
    private Exit exitToRetrieve;
    private ArrayList<Item> items;
    private Item itemToRetrieve;
    private ArrayList<Feature> features;
    private Feature featureToRetrieve;
    private ArrayList<Equipment> equipment;
    private Equipment equipmentToRetrieve;
    private ArrayList<GameObject> gameObjects;
    // private boolean hasExit;
    // private boolean hasFeature;
    // private boolean hasItem;
    // private boolean hasEquipment;

    public Room(){}

    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
        exits = new ArrayList<Exit>();
        items = new ArrayList<Item>();
        features = new ArrayList<Feature>();
        equipment = new ArrayList<Equipment>();
        gameObjects = new ArrayList<GameObject>();
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
        for(Exit exit : exits){
            if(exit.getId().equals(id)){
                exitToRetrieve = exit;
            }
        }

        return exitToRetrieve;
    }

    public ArrayList<Feature> getFeatures(){
        return features;
    }

    public Feature getFeature(String id){
        for(Feature feature : features){
            if(feature.getId().equals(id)){
                featureToRetrieve = feature;
            }
        }

        return featureToRetrieve;
    }

    public Feature getFeatureByName(String name){
        for(Feature feature : features){
            if(feature.getName().equals(name)){
                featureToRetrieve = feature;
            }
        }
        
        return featureToRetrieve;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(String id){
        for(Item item : items){
            if(item.getId().equals(id)){
                itemToRetrieve = item;
            }
        }

        return itemToRetrieve;
    }

    public Item getItemByName(String name){
        for(Item item : items){
            if(item.getName().equals(name)){
                itemToRetrieve = item;
            }
        }

        return itemToRetrieve;
    }

    public ArrayList<Equipment> getEquipments(){
        return equipment;
    }

    public Equipment getEquipment(String id){
        for(Equipment e : equipment){
            if(e.getId().equals(id)){
                equipmentToRetrieve = e;
            }
        }

        return equipmentToRetrieve;
    } 

    public Equipment getEquipmentByName(String name){
        for(Equipment e : equipment){
            if(e.getName().equals(name)){
                equipmentToRetrieve = e;
            }
        }

        return equipmentToRetrieve;
    }

    public ArrayList<GameObject> getAll(){
        return gameObjects;
    } 

    public void addExit(Exit exit){
        if(exit != null && !exits.contains(exit)){
            exits.add(exit);
        }
    }

    public void addFeature(Feature feature){
        if(feature != null && !features.contains(feature)){
            features.add(feature);
        }
    }

    public void addItem(Item item){
        if(item != null && !items.contains(item)){
            items.add(item);
        }
    }

    public void addEquipment(Equipment equipment){
        if(equipment != null && !this.equipment.contains(equipment)){
            this.equipment.add(equipment);
        }
    }

    public boolean hasExit(String exitName){
        // Checks if the room contains an exit with the specified name.
        if(!exits.isEmpty()){
            for(Exit exit : exits){
                if(exit.getName().equals(exitName)){
                    return true;
                }
            }

            return false;
        }
        // else{
        //     System.out.println("This room does not have any exits!");
        // }

        return false; 
    }

    public boolean hasFeature(String featureName){
        // Checks if the room contains a feature with the specified name.
        if(!features.isEmpty()){
            for(Feature feature : features){
                if(feature.getName().equals(featureName)){
                    return true;
                }
            }

            return false;
        }
        // else{
        //     System.out.println("This room does not have any features!");
        // }

        return false; 
    }

    public boolean hasItem(String itemName){
        // Checks if the room contains an item with the specified name.
        if(!items.isEmpty()){
            for(Item item : items){
                if(item.getName().equals(itemName)){
                    return true;
                }
            }

            return false;
        }
        // else{
        //     System.out.println("This room does not have any items!");
        // }

        return false; 
    }

    public boolean hasEquipment(String name){
        // Checks if the room contains equipment with the specified name.
        if(!equipment.isEmpty()){
            for(Equipment e : equipment){
                if(e.getName().equals(name)){
                    return true;
                }
            }

            return false;
        }
        // else{
        //     System.out.println("This room does not have any equipment!");
        // }

        return false;
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
