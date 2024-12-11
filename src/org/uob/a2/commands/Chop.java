package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Chop extends Command{
    private String item;

    public Chop(String item){
        this.item = item;
    }

    @Override
    public String execute(GameState gameState) {
        if(this.item.equals("watermelon")){
            if(gameState.getMap().getCurrentRoom().getName().equals("Guillotine Area")){
                if(gameState.getPlayer().hasItem("watermelon")){
                    Equipment equipment = gameState.getMap().getCurrentRoom().getEquipmentByName("key");
                    Item item = gameState.getPlayer().getItem("watermelon");
                    gameState.getPlayer().getInventory().remove(item);
                    equipment.setHidden(false);
                    return "You chop " + this.item + ". Something falls to the ground...";
                }

                return "You do not have " + this.item;
            }
    
            return "You are not in the right room to chop the " + this.item;
        }

        return "Cannot chop " + this.item;
    }
    
}
