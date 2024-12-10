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
        if(gameState.getPlayer().hasEquipment(equipmentName)) {
            for(Equipment e : gameState.getPlayer().getEquipment()) {
                if(e.getName().equals(equipmentName)) {
                    if(e.getUseInformation().isUsed()) {
                        return "You have already used " + equipmentName;
                    }

                    for(Feature feature : gameState.getMap().getCurrentRoom().getFeatures()){
                        if(feature.getName().equals(this.target)){
                            if(e.getUseInformation().getTarget().equals(feature.getId())){
                                e.use(feature, gameState);
                                return e.getUseInformation().getMessage();
                            }
                        }
                    }

                    return "Invalid use target";
                }
            }
        }
        return "You do not have " + this.equipmentName;
    }

    public String toString(){
        return "use " + this.equipmentName + " on " + this.target;
    }
}
