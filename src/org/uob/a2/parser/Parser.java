package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {
    public Parser(){}

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.isEmpty()){
            throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }

        // Checks if the order of command arguments is correct so that something like 'use key on' is not allowed
        if(tokens.get(tokens.size() - 1).getTokenType() != TokenType.EOL){
            throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }

        Token commandToken = tokens.get(0);

        boolean isFirstWordCommand = commandToken.getTokenType() == TokenType.DROP || commandToken.getTokenType() == TokenType.GET || commandToken.getTokenType() == TokenType.HELP || commandToken.getTokenType() == TokenType.LOOK || commandToken.getTokenType() == TokenType.MOVE || commandToken.getTokenType() == TokenType.QUIT || commandToken.getTokenType() == TokenType.STATUS || commandToken.getTokenType() == TokenType.USE;

        // checks if the first element is actually the command, so that something like 'chest use on key' is not allowed
        if(!isFirstWordCommand){
            throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }

        switch (commandToken.getTokenType()) {
            case DROP:
            case GET:
            case LOOK:
            case MOVE:
            case STATUS:
                if(tokens.size() != 2){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }
                String arg = tokens.get(1).getValue();
                return new Drop(arg);
            
            case HELP:
                if(tokens.size() == 1){
                    return new Help(null);
                }else if(tokens.size() == 2){
                    String topic = tokens.get(1).getValue();
                    return new Help(topic);
                }else{
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " can have 1 or no argument");
                }
            
            case QUIT:
                if(tokens.size() != 1){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " cannot take any argument!");
                }
                return new Quit();
            
            case USE:
                if(tokens.size() != 4){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                }

                // Checks if the second and the fourth words in the user input are actually treated as variables so that something like use on key chest is not allowed 
                if(tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.VAR){
                    throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
                }

                String item = tokens.get(1).getValue();
                String target = tokens.get(3).getValue();
                return new Use(item, target);
        
            default:
                throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }
    }
}
