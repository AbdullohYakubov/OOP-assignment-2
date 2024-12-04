package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {
    private String target;

    public Look(String target){
        this.target = target;
    }

    @Override
    public String execute(GameState gameState) {
        return "Executes the look command. Provides descriptions based on the specified target:\r\n" + //
                        "If the target is \"room\", it displays the room's description and all visible objects.\r\n" + //
                        "If the target is \"exits\", it lists the visible exits in the room.\r\n" + //
                        "If the target is \"features\", it lists additional visible features in the room.\r\n" + //
                        "If the target matches an item, feature or equipment name, it displays the description of that object.\r\n" + //
                        "Hidden objects are not included unless they are explicitly revealed in the game state.";
    }

    public String toString(){
        return "Returns a string representation of the look command, including its type and target.";
    }

   
}
