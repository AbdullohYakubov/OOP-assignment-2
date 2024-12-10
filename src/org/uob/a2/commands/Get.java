package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {
    private String item;

    public Get(String item){
        this.item = item;
    }

    @Override
    public String execute(GameState gameState) {
        if(!gameState.getPlayer().getInventory().isEmpty()){
            for(Item i : gameState.getPlayer().getInventory()){
                if(i.getName().equals(this.item)){
                    return "You already have " + this.item;
                }
            }
        }
        
        if(gameState.getMap().getCurrentRoom().hasEquipment(item)){
            for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
                if(e.getName().equals(item)){
                    if(e.getHidden()){
                        return "No " + this.item + " to get.";
                    }

                    gameState.getPlayer().addEquipment(e);
                    gameState.getMap().getCurrentRoom().getEquipments().remove(e);
                    return "You pick up: " + this.item;
                }
            }
        }
        else if(gameState.getMap().getCurrentRoom().hasItem(item)){
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                if(i.getName().equals(item)){
                    if(i.getHidden()){
                        return "No " + this.item + " to get.";
                    }

                    gameState.getPlayer().addItem(i);
                    gameState.getMap().getCurrentRoom().getItems().remove(i);
                    return "You pick up: " + this.item;
                }
            }
        }

        return "No " + this.item + " to get.";
    }

    public String toString(){
        return "get " + item; 
    }
   
}
