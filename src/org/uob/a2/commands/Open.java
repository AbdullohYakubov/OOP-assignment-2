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
public class Open extends Command{
    private String target;

    public Open(String target){
        this.target = target;
    }

    @Override
    public String execute(GameState gameState) {
        if(this.target.equalsIgnoreCase("fridge")){
            if(gameState.getMap().getCurrentRoom().getName().equals("Kitchen")){
                gameState.getMap().getCurrentRoom().getItemByName("watermelon").setHidden(false);
                return "You open " + this.target;
            }

            return "You are not in the right room to open the fridge!";
        }

        return "Cannot open " + this.target;
    }
}
