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
        if(target.equalsIgnoreCase("room")){
            String items = "";
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                if(!i.getHidden()){
                    items = items + i.getDescription() + "\n";
                }
            }

            String equipment = "";
            for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
                if(!e.getHidden()){
                    equipment = equipment + e.getDescription() + "\n";
                }
            }

            String features = "";
            for(Feature feature : gameState.getMap().getCurrentRoom().getFeatures()){
                if(!feature.getHidden()){
                    features = features + feature.getDescription() + "\n";
                }
            }

            String exits = "";
            for(Exit exit : gameState.getMap().getCurrentRoom().getExits()){
                if(!exit.getHidden()){
                    exits = exits + exit.getDescription() + "\n";
                }
            }

            return gameState.getMap().getCurrentRoom().getDescription() + "\nYou see:\n" + items + equipment + features + exits;
        }
        
        else if(target.equalsIgnoreCase("exits")){
            String exits = "";
            for(Exit exit : gameState.getMap().getCurrentRoom().getExits()){
                if(!exit.getHidden()){
                    exits = exits + exit.getDescription() + "\n";
                }else{
                    exits = exits + "";
                }
            }

            return "The available exits are:\n" + exits;
        }

        else if(target.equals("features")){
            String features = "";
            for(Feature feature : gameState.getMap().getCurrentRoom().getFeatures()){
                if(!feature.getHidden()){
                    features = features + feature.getDescription() + "\n";
                }else{
                    features = features + "";
                }
            }

            return "You also see:\n" + features;
        }

        else if(!gameState.getMap().getCurrentRoom().getFeatures().isEmpty()){
            for(Feature feature : gameState.getMap().getCurrentRoom().getFeatures()){
                if(feature.getName().equalsIgnoreCase(this.target)){
                    if(feature.getHidden()){
                        return "";
                    }

                    return feature.getDescription();
                }
            }
        }

        else if(!gameState.getMap().getCurrentRoom().getEquipments().isEmpty()){
            for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
                if(e.getName().equalsIgnoreCase(this.target)){
                    if(e.getHidden()){
                        return "";
                    }

                    return e.getDescription();
                }
            }
        }

        else if(gameState.getPlayer().hasEquipment(this.target)){
            return "Use 'status <equipment>' command to look at the equipment";
        }

        else if(!gameState.getMap().getCurrentRoom().getItems().isEmpty()){
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                if(i.getName().equalsIgnoreCase(this.target)){
                    if(i.getHidden()){
                        return "";
                    }

                    return i.getDescription();
                }
            }
        }

        else if(gameState.getPlayer().hasItem(this.target)){
            return "Use 'status <item>' command to look at the item";
        }

        return "";
    }

    public String toString(){
        // Returns a string representation of the look command, including its type and target.
        return "look " + this.target;
    }
}