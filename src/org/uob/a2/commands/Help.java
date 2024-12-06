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
            return "The list of available commands:\\n" +
                                "1. move <north/south/east/west> - The player moves to a new room based on the direction.\\n" +
                                "2. look - Displays a description of the room the player is in.\\n" +
                                "3. look <feature> - Displays a more detailed description of a feature of a room.\\n" +
                                "4. look <item> - Displays a description of an item.\\n" +
                                "5. search <item> - Searches for the item and puts it into the player's inventory.\\n" +
                                "6. open <item> - Opens the item and puts what's found into the inventory.\\n" +
                                "7. chop <item> - Chops an item off.\\n" +
                                "8. break <item> - Breaks an item.\\n" +
                                "9. unlock <item> - Unlocks an item.\\n" +
                                "10. inventory - Displays a list of all items the player has obtained.\\n" +
                                "11. score - Displays the player's current score.\\n" +
                                "12. map - Displays a text-based map of the current explored game world.\\n" +
                                "13. help - Displays a help message.\\n" +
                                "14. quit - Quits the game.";
        }
        else if(this.topic == "drop"){
            return "If the player possesses the specified item, it is removed from their inventory and added to the current room.";
        }
        else if(this.topic == "get"){
            return "If the specified item is present in the current room and the player does not already have it, the item is added to the player's inventory.";
        }
        else if(this.topic == "help"){
            return "Provides detailed help information based on the specified topic or general game help if no specific topic is provided.";
        }
        else if(this.topic == "look"){
            return "Provides descriptions based on the specified target:\r\n" + //
                                "If the target is \"room\", it displays the room's description and all visible objects.\r\n" + //
                                "If the target is \"exits\", it lists the visible exits in the room.\r\n" + //
                                "If the target is \"features\", it lists additional visible features in the room.\r\n" + //
                                "If the target matches an item, feature or equipment name, it displays the description of that object.";
        }
        else if(this.topic == "move"){
            return "If the specified direction corresponds to an available exit in the current room, the player's location is updated to the connected room.";
        }
        else if(this.topic == "quit"){
            return "This implementation returns a game-over message along with the player's current status.";
        }
        else if(this.topic == "status"){
            return "Retrieves and displays information based on the specified topic.\r\n" +
                                "If the topic is \"inventory\", it lists all items in the player's inventory.\r\n" +
                                "If the topic matches an item name, it displays the item's description.\r\n" +
                                "If the topic is \"player\", it displays the player's general status.";
        }
        else if(this.topic == "use"){
            return "Checks if the player has the specified equipment and whether the equipment can interact with the target. If valid, the equipment is used on the target.";
        }
    
        return null;
    }
    
    public String toString(){
        return "Returns a string representation of the help command, including its type and topic.";
    }
}
