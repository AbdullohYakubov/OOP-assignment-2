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
    private String itemToPickUp;

    public Get(String item){
        this.item = item;
    }

    @Override
    public String execute(GameState gameState) {
        if(gameState.getMap().getCurrentRoom().hasEquipment(item)){
            for(Equipment e : gameState.getPlayer().getEquipment()){
                if(!(e.getName().equals(item))){
                    itemToPickUp = e.getName();
                    gameState.getPlayer().addEquipment(e);
                }
            }
        }
        else if(gameState.getPlayer().hasItem(item)){
            for(Item i : gameState.getPlayer().getInventory()){
                if(!(i.getName().equals(item))){
                    itemToPickUp = i.getName();
                    gameState.getPlayer().addItem(i);(i);
                }
            }
        }

        return "The " + itemToPickUp + " has been picked up";
    }

    public String toString(){
        return "You got " + item; 
    }
   
}
