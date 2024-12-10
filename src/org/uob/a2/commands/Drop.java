package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {
    private String item;

    public Drop(String item){
        this.item = item;
    }

    @Override
    public String execute(GameState gameState) {
        if(gameState.getPlayer().hasEquipment(item)){
            for(Equipment e : gameState.getPlayer().getEquipment()){
                if(e.getName().equals(item)){
                    gameState.getPlayer().getEquipment().remove(e);
                    gameState.getMap().getCurrentRoom().addEquipment(e);
                    return "You drop: " + this.item;
                }
            }
        }
        else if(gameState.getPlayer().hasItem(item)){
            for(Item i : gameState.getPlayer().getInventory()){
                if(i.getName().equals(item)){
                    gameState.getPlayer().getInventory().remove(i);
                    gameState.getMap().getCurrentRoom().addItem(i);
                    return "You drop: " + this.item;
                }
            }
        }

        return "You cannot drop " + this.item;
    }

    public String toString(){
        return "drop " + item; 
    }
}
