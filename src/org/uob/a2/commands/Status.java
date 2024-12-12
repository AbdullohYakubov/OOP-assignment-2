package org.uob.a2.commands;

import java.util.ArrayList;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {
    private String topic;

    public Status(String topic){
        this.topic = topic;
    }

    @Override
    public String execute(GameState gameState){
        if(this.topic.equalsIgnoreCase("inventory")){
            String equipment = "";
            if(!(gameState.getPlayer().getEquipment().isEmpty())){
                for(Equipment e : gameState.getPlayer().getEquipment()){
                    equipment = equipment + e.getName() + "\n";
                }
            }
            String items = "";
            if(!(gameState.getPlayer().getInventory().isEmpty())){
                for(Item i : gameState.getPlayer().getInventory()){
                    items = items + i.getName() + "\n";
                }
            }
            
            return "You have the following equipment:\n" + equipment + "You have the following items:\n" + items;
        }
        
        else if(this.topic.equalsIgnoreCase("player")){
            return gameState.getPlayer().toString();
        }

        else if(this.topic.equalsIgnoreCase("score")){
            return "Player score: " + gameState.getPlayer().getScore();
        }

        else if(this.topic.equalsIgnoreCase("map")){
            // Character[][] mapArr = new Character[3][5];
            // ArrayList<Character> roomSymbols= new ArrayList<>();

            // for(Room room : gameState.getMap().getRooms()){
            //     roomSymbols.add(room.getName().charAt(0));
            // }

            // mapArr[0][0] = roomSymbols.get(0);
            // mapArr[0][1] = roomSymbols.get(1);
            // mapArr[0][2] = roomSymbols.get(2);
            // mapArr[0][3] = '*';
            // mapArr[0][4] = '*';
            // mapArr[1][0] = roomSymbols.get(3);
            // mapArr[1][1] = roomSymbols.get(4);
            // mapArr[1][2] = roomSymbols.get(5);
            // mapArr[1][3] = roomSymbols.get(6);
            // mapArr[1][4] = roomSymbols.get(7);
            // mapArr[2][0] = '*';
            // mapArr[2][1] = roomSymbols.get(8);
            // mapArr[2][2] = roomSymbols.get(9);
            // mapArr[2][3] = '*';
            // mapArr[2][4] = '*';

            // String map = "";

            // for(int i = 0; i < mapArr.length; i++){
            //     for(int j = 0; j < mapArr[i].length; j++){
            //         map += mapArr[i][j] + " ";
            //     }

            //     map += "\n";
            // }

            // return map;

            String map = "";
            int width = 5;
            for(Room room : gameState.getMap().getRooms()){
                if(width == 5){
                    width = 0;
                    map+= "\n";
                }

                if(room == gameState.getMap().getCurrentRoom()){
                    map+="X";
                    width++;
                }else{
                    map+=room.getName().charAt(0);
                    width++;
                }
            }

            return map;
        }

        else if(!(gameState.getPlayer().getEquipment().isEmpty())){
            for(Equipment equipment : gameState.getPlayer().getEquipment()){
                if(equipment.getName().equalsIgnoreCase(this.topic)){
                    return equipment.getDescription();
                }
            }
        }
        
        else if(!(gameState.getPlayer().getInventory().isEmpty())){
            for(Item item : gameState.getPlayer().getInventory()){
                if(item.getName().equalsIgnoreCase(this.topic)){
                    return item.getDescription();
                }
            }
        }

        return "";
    }

    public String toString(){
        // Returns a string representation of the status command, including its type and topic.
        return "status " + topic;
    }
}