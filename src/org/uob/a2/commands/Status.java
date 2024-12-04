package org.uob.a2.commands;

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
        return "Executes the status command. Retrieves and displays information based on the specified topic.\r\n" + //
                        "If the topic is \"inventory\", it lists all items in the player's inventory.\r\n" + //
                        "If the topic matches an item name, it displays the item's description.\r\n" + //
                        "If the topic is \"player\", it displays the player's general status.";
    }

    public String toString(){
        return "Returns a string representation of the status command, including its type and topic.";
    }
}
