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
            String items = "";
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                items = items + i.getDescription() + "\n";
            }

            String equipment = "";
            for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
                equipment = equipment + e.getDescription() + "\n";
            }

            return gameState.getMap().getCurrentRoom().getDescription() + "\n" + items + equipment;
        }
        else if(target.equals("exits")){
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
        
        else if(gameState.getMap().getCurrentRoom().hasEquipment(target)){
            // for(Equipment e : gameState.getMap().getCurrentRoom().getEquipments()){
            //     if(e.getName().equals(target)){
            //         if(!e.getHidden()){
            //             return e.getDescription();
            //         }else{
            //             return "";
            //         }
            //     }
            // }

            Equipment equipment = gameState.getMap().getCurrentRoom().getEquipment(target);
            
            if(equipment.getHidden()){
                return "";
            }

            return equipment.getDescription();
        }
    //     else if(gameState.getMap().getCurrentRoom().hasItem(target)){
    //         System.out.println(gameState.getMap().getCurrentRoom().hasItem(target));
    //         for(Item i : gameState.getMap().getCurrentRoom().getItems()){
    //             System.out.println(i.getId());
    //             System.out.println(i.getName());
    //             System.out.println(i.getDescription());
    //             System.out.println(i.getHidden());
    //             if(!i.getHidden()){
    //                 if(i.getId().equalsIgnoreCase(target)){
    //                     return i.getDescription();
    //                 }
    //             }

    //             else{
    //                 return "";
    //             }
                
    //         }
    //         // Item item = gameState.getMap().getCurrentRoom().getItem(target);

    //         // if(item.getHidden()){
    //         //     return "";
    //         // }

    //         // return item.getDescription();
    //         // System.out.println(item.getId());
    //         // System.out.println(item.getName());
    //         // System.out.println(item.getDescription());
    //         // System.out.println(item.getHidden());
    //     }

    //     return "hello";
    // }

        else if(!gameState.getMap().getCurrentRoom().getItems().isEmpty()){
            for(Item i : gameState.getMap().getCurrentRoom().getItems()){
                if(i.getId().equalsIgnoreCase(this.target)){
                    if(i.getHidden()){
                        return "";
                    }

                    return i.getDescription();
                }
            }
        }

        return "";
    }

    public String toString(){
        // Returns a string representation of the look command, including its type and target.
        return "look " + this.target;
    }
}
