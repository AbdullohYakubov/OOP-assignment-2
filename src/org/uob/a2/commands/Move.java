package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {
    private String direction; 

    public Move(String direction){
        this.direction = direction;
    }

    @Override
    public String execute(GameState gameState) {
        for(Exit exit : gameState.getMap().getCurrentRoom().getExits()){
            if(exit.getName().equals(this.direction)){
                String nextRoomId = exit.getNextRoom();
                gameState.getMap().setCurrentRoom(nextRoomId);
                return "You moved " + this.direction + ". You are now in " + gameState.getMap().getCurrentRoom().getName() + ".";
            }
        }

        return "You cannot move " + this.direction + "!";
    }

    public String toString(){
        // Returns a string representation of the look command, including its type and target.
        return "You move " + this.direction;
    }
}
