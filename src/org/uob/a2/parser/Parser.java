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
            throw new CommandErrorException("Invalid Command!");
        }

        Token commandToken = tokens.get(0);
        // checks if the first element is actually the command, so that something like chest use on key is not allowed
        for(TokenType tokenType : TokenType.values()){
            while(commandToken.getTokenType() != tokenType){
                throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
            }
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
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 4 arguments!");
                }

                String item = tokens.get(1).getValue();
                String target = tokens.get(3).getValue();

                // Checks if the second and the fourth words in the user input are actually treated as variables so that something like use on key chest is not allowed 
                while(item.toUpperCase() != TokenType.VAR.name() || target.toUpperCase() != TokenType.VAR.name()){
                    throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
                }
                return new Use(item, target);
        
            default:
                throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }
    }
}
