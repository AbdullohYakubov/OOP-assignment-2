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
    private String itemToDrop;
    // private boolean isDropped;

    public Drop(String item){
        this.item = item;
    }

    @Override
    public String execute(GameState gameState) {
        if(gameState.getPlayer().hasEquipment(item)){
            for(Equipment e : gameState.getPlayer().getEquipment()){
                if(e.getName().equals(item)){
                    itemToDrop = e.getName();
                    gameState.getPlayer().getEquipment().remove(e);
                    gameState.getMap().getCurrentRoom().addEquipment(e);
                    break;
                }
            }
        }
        else if(gameState.getPlayer().hasItem(item)){
            for(Item i : gameState.getPlayer().getInventory()){
                if(i.getName().equals(item)){
                    itemToDrop = i.getName();
                    gameState.getPlayer().getInventory().remove(i);
                    gameState.getMap().getCurrentRoom().addItem(i);
                    break;
                }
            }
        }

        return itemToDrop;
        
        // if(gameState.getPlayer().getInventory().contains(this.item) && !(gameState.getPlayer().getEquipment().contains(this.item))){
        //     if(!(gameState.getPlayer().getInventory().isEmpty())){
        //         for(Item item : gameState.getPlayer().getInventory()){
        //             if(item.getName().equals(this.item)){
        //                 gameState.getPlayer().getInventory().remove(item);
        //                 isDropped = true;
        //             }else{
        //                 isDropped = false;
        //             }
        //         }
        //     }else{
        //         System.out.println("Your inventory is empty!");
        //     }
        // } 
        // else if(!(gameState.getPlayer().getInventory().contains(this.item)) && gameState.getPlayer().getEquipment().contains(this.item)){
        //     if(!(gameState.getPlayer().getEquipment().isEmpty())){
        //         for(Equipment e : gameState.getPlayer().getEquipment()){
        //             if(e.getName().equals(this.item)){
        //                 gameState.getPlayer().getEquipment().remove(item);
        //                 isDropped = true;
        //             }else{
        //                 isDropped = false;
        //             }
        //         }
        //     }else{
        //         System.out.println("Your inventory is empty!");
        //     }
        // }

    }

    public String toString(){
        return "You dropped " + item; 
    }
   
}
