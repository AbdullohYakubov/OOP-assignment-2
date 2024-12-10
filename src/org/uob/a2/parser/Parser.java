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
        // if(tokens.get(tokens.size() - 1).getTokenType() != TokenType.EOL){
        //     throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        // }

        Token commandToken = tokens.get(0);

        // boolean isFirstWordCommand = commandToken.getTokenType() == TokenType.DROP || commandToken.getTokenType() == TokenType.GET || commandToken.getTokenType() == TokenType.HELP || commandToken.getTokenType() == TokenType.LOOK || commandToken.getTokenType() == TokenType.MOVE || commandToken.getTokenType() == TokenType.QUIT || commandToken.getTokenType() == TokenType.STATUS || commandToken.getTokenType() == TokenType.USE;

        // checks if the first element is actually the command, so that something like 'chest use on key' is not allowed
        // if(!isFirstWordCommand){
        //     throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        // }

        switch (commandToken.getTokenType()){
            case DROP:
                if(tokens.size() < 3){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String itemToDrop = tokens.get(1).getValue();
                    Drop dropCommand = new Drop(itemToDrop);
                    dropCommand.commandType = CommandType.DROP;
                    return dropCommand;
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String itemToDrop = tokens.get(1).getValue();
                    String itemToDrop_2 = tokens.get(2).getValue();
                    Drop dropCommand = new Drop(itemToDrop + " " + itemToDrop_2);
                    dropCommand.commandType = CommandType.DROP;
                    return dropCommand;
                }

            case GET:
                if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }
                String itemToPickUp = tokens.get(1).getValue();
                Get getCommand = new Get(itemToPickUp);
                getCommand.commandType = CommandType.GET;
                return getCommand;
                
            
            case LOOK:
                if(tokens.size() < 3){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String param = tokens.get(1).getValue();
                    Look lookCommmand = new Look(param);
                    lookCommmand.commandType = CommandType.LOOK;
                    return lookCommmand;
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String param = tokens.get(1).getValue();
                    String param_2 = tokens.get(2).getValue();
                    Look lookCommmand = new Look(param + " " + param_2);
                    lookCommmand.commandType = CommandType.LOOK;
                    return lookCommmand;
                }

            case MOVE:
                if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }
                String direction = tokens.get(1).getValue();
                Move moveCommand = new Move(direction);
                moveCommand.commandType = CommandType.MOVE;
                return moveCommand;
            
            case STATUS:
                if(tokens.size() < 3){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String arg = tokens.get(1).getValue();
                    Status statusCommand = new Status(arg);
                    statusCommand.commandType = CommandType.STATUS;
                    return statusCommand;
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String arg = tokens.get(1).getValue();
                    String arg_2 = tokens.get(2).getValue();
                    Status statusCommand = new Status(arg + " " + arg_2);
                    statusCommand.commandType = CommandType.STATUS;
                    return statusCommand;
                }
            
            case HELP:
                if(tokens.size() == 2){
                    if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " can have 1 or no argument");
                    }

                    Help helpCommand = new Help(null);
                    helpCommand.commandType = CommandType.HELP;
                    return helpCommand;

                }
                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " can have 1 or no argument");
                    }

                    String topic = tokens.get(1).getValue();
                    Help helpCommand = new Help(topic);
                    helpCommand.commandType = CommandType.HELP;
                    return helpCommand;
                }
            
            case QUIT:
                if(tokens.size() != 2){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " cannot take any argument!");
                }

                if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.EOL){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " cannot take any argument!");
                }
                return new Quit();
            
            case USE:
                if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.PREPOSITION || tokens.get(3).getTokenType() != TokenType.VAR){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                }

                String item = tokens.get(1).getValue();
                String target = tokens.get(3).getValue();
                Use useCommand = new Use(item, target);
                useCommand.commandType = CommandType.USE;
                return useCommand;
        
            default:
                throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }
    }
}
