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
    private String items = "";
    private String equipment = "";

    public Status(String topic){
        this.topic = topic;
    }

    @Override
    public String execute(GameState gameState){
        if(this.topic.equals("inventory")){
            if(!(gameState.getPlayer().getEquipment().isEmpty())){
                for(Equipment e : gameState.getPlayer().getEquipment()){
                    equipment = equipment + e.getName() + "\n";
                }
            }
            if(!(gameState.getPlayer().getInventory().isEmpty())){
                for(Item i : gameState.getPlayer().getInventory()){
                    items = items + i.getName() + "\n";
                }
            }
            
            return "You have the following equipment:\n" + equipment + "You have the following items\n" + items;

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

        return "";
    }

    public String toString(){
        // Returns a string representation of the status command, including its type and topic.
        return "status " + topic;
    }
}
