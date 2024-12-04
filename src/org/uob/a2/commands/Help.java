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
        return "Executes the help command. Provides detailed help information based on the specified topic or general game help if no specific topic is provided.";
    }

    public String toString(){
        return "Returns a string representation of the help command, including its type and topic.";
    }
}
