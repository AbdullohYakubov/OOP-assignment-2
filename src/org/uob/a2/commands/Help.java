package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {
    private String topic; // Creates a new Help command for the specified topic.

    public Help(String topic){
        this.topic = topic;
    }

    public String execute(GameState gameState){
        if(this.topic == null){
            return "Welcome to the game!\n" +
                                "- MOVE <north|south|east|west> - The player moves to a new room based on the direction.\n" +
                                "- LOOK <room> - Displays a more detailed description of a room, describing everything that's in there.\n" +
                                "- LOOK <features> - Displays a more detailed description of all features in the room.\n" +
                                "- LOOK <exits> - Displays a more detailed description of all exits in the room.\n" +
                                "- LOOK <item> - Displays a description of an item.\n" +
                                "- GET <item> - Picks up an item.\n" +
                                "- DROP <item> - Drops an item.\n" +
                                "- USE <equipment> <on> <feature> - Uses a piece of equipment on a feature.\n" +
                                "- COMBINE <item> <with> <item> - Combines an item with another item to make a new piece of equipment.\n" +
                                "- STATUS <inventory|player|item name|equipment name|map|score> - Uses a piece of equipment on a feature.\n" +
                                "- OPEN <feature> - Opens a feature.\n" +
                                "- CHOP <item> <on> <feature> - Chops an item off using a feature of the room.\n" +
                                "- HELP - Displays a help message.\n" +
                                "- QUIT - Quits the game.";
        }
        else if(this.topic.equals("drop")){
            return "DROP Command: Use the 'drop' command to drop an item or a peice of equipment.";
        }
        else if(this.topic.equals("get")){
            return "GET Command: Use the 'get' command to pick up an item or a piece of equipment.";
        }
        else if(this.topic.equals("help")){
            return "HELP Command: Use the 'help' command to see the list of available commands or the 'help <command name>' command to see what the specified command does.";
        }
        else if(this.topic.equals("look")){
            return "LOOK Command: Use the 'look' command to look at the room/feature/exit/equipment/item.";
        }
        else if(this.topic.equals("move")){
            return "MOVE Command: Use the 'move' command to move in one of these directions (north, south, east, west).";
        }
        else if(this.topic.equals("quit")){
            return "QUIT Command: Use the 'quit' command to quit the game.";
        }
        else if(this.topic.equals("status")){
            return "STATUS Command: Use the 'status' command to see the status of the player, inventory, map, score, and a specific item or a piece of equipment.";
        }
        else if(this.topic.equals("use")){
            return "USE Command: Use the 'use' command to usea piece of equipment on a feature.";
        }
        else if(this.topic.equals("combine")){
            return "COMBINE Command: Use the 'combine' command to combine an item with another item to make a new piece of equipment.";
        }
        else if(this.topic.equals("open")){
            return "OPEN Command: Use the 'open' command to open a feature.";
        }
        else if(this.topic.equals("chop")){
            return "CHOP Command: Use the 'chop' command to chop an item on a feature.";
        }
        else{
            return "No help available for the topic: " + topic;
        }    
    }
    
    public String toString(){
        return this.topic == null ? "help" : "HELP " + this.topic;
    }
}
