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
public class Use extends Command {
    private String equipmentName;
    private String target;

    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        this.target = target;
    }

    @Override
    public String execute(GameState gameState){
        return "Executes the use command. Checks if the player has the specified equipment and whether the equipment can interact with the target. If valid, the equipment is used on the target.";
    }

    public String toString(){
        return "Returns a string representation of the use command, including its type, equipment, and target.";
    }
  
}
