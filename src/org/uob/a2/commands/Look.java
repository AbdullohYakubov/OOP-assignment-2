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
    // private String itemToLookAt;

    public Look(String target){
        this.target = target;
    }

    @Override
    public String execute(GameState gameState) {
        if(target.equals("room")){
            return gameState.getMap().getCurrentRoom().getDescription();
        }
        else if(target.equals("exit")){
            for(Exit exit : gameState.getMap().getCurrentRoom().getExits()){
                return exit.getDescription();
            }
        }
        else if(gameState.getMap().getCurrentRoom().hasFeature(target)){
            for(Feature feature : gameState.getMap().getCurrentRoom().getFeatures()){
                if(feature.getName().equals(target)){
                    return feature.getDescription();
                }
            }
        }
        else if(gameState.getMap().getCurrentRoom().hasEquipment(target)){
            for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
                if(e.getName().equals(target)){
                    return e.getDescription();
                }
            }
        }
        else if(gameState.getMap().getCurrentRoom().hasItem(target)){
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                if(i.getName().equals(target)){
                    return i.getDescription();
                }
            }
        }

        return null;
    }

    public String toString(){
        return "Returns a string representation of the look command, including its type and target.";
    }

   
}
