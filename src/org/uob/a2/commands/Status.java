package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {
    private String topic;
    private String inventoryStatus = "You have the following items in your inventory:\n";
    private String equipmentStatus = "You have the following pieces of equipment in your equipment list:\n";

    public Status(String topic){
        this.topic = topic;
    }

    @Override
    public String execute(GameState gameState){
        if(this.topic.equals("inventory")){
            if(!(gameState.getPlayer().getInventory().isEmpty())){
                for(Item i : gameState.getPlayer().getInventory()){
                    return inventoryStatus + i.getName() + "\n";
                }
            }
        }else if(this.topic.equals("equipment")){
            if(!(gameState.getPlayer().getEquipment().isEmpty())){
                for(Equipment e : gameState.getPlayer().getEquipment()){
                    return equipmentStatus + e.getName() + "\n";
                }
            }
        }else if(this.topic.equals("player")){
            return gameState.getPlayer().toString();

        }else if(!(gameState.getPlayer().getEquipment().isEmpty())){
            for(Equipment equipment : gameState.getPlayer().getEquipment()){
                if(equipment.getName().equals(this.topic)){
                    return equipment.getDescription();
                }
            }
        }else if(!(gameState.getPlayer().getInventory().isEmpty())){
            for(Item item : gameState.getPlayer().getInventory()){
                if(item.getName().equals(this.topic)){
                    return item.getDescription();
                }
            }
        }

        return "Invalid command!";
    }

    public String toString(){
        // Returns a string representation of the status command, including its type and topic.
        return "status " + topic;
    }
}
