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

        Token commandToken = tokens.get(0);

        // boolean isFirstWordCommand = commandToken.getTokenType() == TokenType.DROP || commandToken.getTokenType() == TokenType.GET || commandToken.getTokenType() == TokenType.HELP || commandToken.getTokenType() == TokenType.LOOK || commandToken.getTokenType() == TokenType.MOVE || commandToken.getTokenType() == TokenType.QUIT || commandToken.getTokenType() == TokenType.STATUS || commandToken.getTokenType() == TokenType.USE;

        // checks if the first element is actually the command, so that something like 'chest use on key' is not allowed
        // if(!isFirstWordCommand){
        //     throw new CommandErrorException("Invalid Command! Please enter a valid command! Type\'help\' to see a list of available commands.");
        // }

        switch (commandToken.getTokenType()){
            case DROP:
                if(tokens.size() < 3 || tokens.size() > 4){
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

                return null;

            case GET:
                if(tokens.size() < 2 || tokens.size() > 4){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                }

                if(tokens.size() == 2){
                    if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String itemToPickUp = tokens.get(1).getValue();
                    Get getCommand = new Get(itemToPickUp);
                    getCommand.commandType = CommandType.GET;
                    return getCommand;
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String itemToPickUp = tokens.get(1).getValue();
                    Get getCommand = new Get(itemToPickUp);
                    getCommand.commandType = CommandType.GET;
                    return getCommand;
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String itemToPickUp = tokens.get(1).getValue();
                    String itemToPickUp_2 = tokens.get(2).getValue();
                    Get getCommand = new Get(itemToPickUp + " " + itemToPickUp_2);
                    getCommand.commandType = CommandType.GET;
                    return getCommand;
                }

                return null;
                
            case LOOK:
                if(tokens.size() < 3 || tokens.size() > 4){
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

                return null;

            case MOVE:
                if(tokens.size() < 2 || tokens.size() > 3){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 2){
                    if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
                        throw new CommandErrorException("Invalid command!");
                    }
                    String direction = tokens.get(1).getValue();
                    Move moveCommand = new Move(direction);
                    moveCommand.commandType = CommandType.MOVE;
                    return moveCommand;
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command!");
                    }
                    String direction = tokens.get(1).getValue();
                    Move moveCommand = new Move(direction);
                    moveCommand.commandType = CommandType.MOVE;
                    return moveCommand;
                }

                return null;

            case STATUS:
                if(tokens.size() < 3 || tokens.size() > 4){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command!");
                    }
                    String arg = tokens.get(1).getValue();
                    Status statusCommand = new Status(arg);
                    statusCommand.commandType = CommandType.STATUS;
                    return statusCommand;
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command!");
                    }
                    String arg = tokens.get(1).getValue();
                    String arg_2 = tokens.get(2).getValue();
                    Status statusCommand = new Status(arg + " " + arg_2);
                    statusCommand.commandType = CommandType.STATUS;
                    return statusCommand;
                }

                return null;
            
            case OPEN:
                if(tokens.size() != 3){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command!");
                    }
                    String feature = tokens.get(1).getValue();
                    Open openCommand = new Open(feature);
                    openCommand.commandType = CommandType.OPEN;
                    return openCommand;
                }

                return null;
            
            case CHOP:
                if(tokens.size() != 3){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 3){
                    if(tokens.size() < 3 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 1 argument!");
                    }
                    String item = tokens.get(1).getValue();
                    Chop chopCommand = new Chop(item);
                    chopCommand.commandType = CommandType.CHOP;
                    return chopCommand;
                }

                return null;
            
            case HELP:
                if(tokens.size() < 2 || tokens.size() > 3){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 2){
                    if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command!");
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

                return null;
            
            case QUIT:
                if(tokens.size() != 2){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " cannot take any argument!");
                }

                if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.EOL){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " cannot take any argument!");
                }
                return new Quit();
            
            case USE:
                if(tokens.size() < 4 || tokens.size() > 6){
                    throw new CommandErrorException("Invalid command!");
                }

                if(tokens.size() == 4){
                    if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.PREPOSITION || tokens.get(3).getTokenType() != TokenType.VAR){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                    }
    
                    String equipment = tokens.get(1).getValue();
                    String target = tokens.get(3).getValue();
                    Use useCommand = new Use(equipment, target);
                    useCommand.commandType = CommandType.USE;
                    return useCommand;
                }

                if(tokens.size() == 6){
                    if(tokens.get(2).getTokenType() == TokenType.VAR){
                        if(tokens.size() < 6 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.PREPOSITION || tokens.get(4).getTokenType() != TokenType.VAR || tokens.get(5).getTokenType() != TokenType.EOL){
                            throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                        }
        
                        String equipment = tokens.get(1).getValue();
                        String equipment_2 = tokens.get(2).getValue();
                        String target = tokens.get(4).getValue();
                        Use useCommand = new Use(equipment + " " + equipment_2, target);
                        useCommand.commandType = CommandType.USE;
                        return useCommand;
                    }

                    if(tokens.get(2).getTokenType() == TokenType.PREPOSITION){
                        if(tokens.size() < 6 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.VAR || tokens.get(4).getTokenType() != TokenType.VAR || tokens.get(5).getTokenType() != TokenType.EOL){
                            throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                        }
        
                        String equipment = tokens.get(1).getValue();
                        String target = tokens.get(3).getValue();
                        String target_2 = tokens.get(4).getValue();
                        Use useCommand = new Use(equipment, target + " " + target_2);
                        useCommand.commandType = CommandType.USE;
                        return useCommand;
                    }
                }

                return null;
            
            case COMBINE:
                // if(tokens.size() == 6){
                //     if(tokens.get(2).getTokenType() == TokenType.PREPOSITION){
                //         if(tokens.size() < 6 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.VAR || tokens.get(4).getTokenType() != TokenType.VAR || tokens.get(5).getTokenType() != TokenType.EOL){
                //             throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                //         }

                //         String item_1 = tokens.get(1).getValue();
                //         String item_2 = tokens.get(3).getValue();
                //         String item_2_2 = tokens.get(4).getValue();
                //         Combine combineCommand = new Combine(item_1, item_2 + " " + item_2_2);
                //         combineCommand.commandType = CommandType.COMBINE;
                //         return combineCommand;
                //     }

                //     else if(tokens.get(2).getTokenType() == TokenType.VAR){
                //         if(tokens.size() < 6 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(3).getTokenType() != TokenType.PREPOSITION || tokens.get(4).getTokenType() != TokenType.VAR || tokens.get(5).getTokenType() != TokenType.EOL){
                //             throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                //         }

                //         String item_1 = tokens.get(1).getValue();
                //         String item_1_2 = tokens.get(2).getValue();
                //         String item_2 = tokens.get(4).getValue();
                //         Combine combineCommand = new Combine(item_1 + " " + item_1_2, item_2);
                //         combineCommand.commandType = CommandType.COMBINE;
                //         return combineCommand;
                //     }
                // }

                if(tokens.size() != 5){
                    throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                }

                if(tokens.size() == 5){
                    if(tokens.size() < 5 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.PREPOSITION || tokens.get(3).getTokenType() != TokenType.VAR || tokens.get(4).getTokenType() != TokenType.EOL){
                        throw new CommandErrorException("Invalid command! " + commandToken.getTokenType() + " must take 2 arguments and 1 preposition!");
                    }
    
                    String item_1 = tokens.get(1).getValue();
                    String item_2 = tokens.get(3).getValue();
                    Combine combineCommand = new Combine(item_1, item_2);
                    combineCommand.commandType = CommandType.COMBINE;
                    return combineCommand;
                }

                return null;
        
            default:
                throw new CommandErrorException("Invalid Input! Please enter a valid command! Type\'help\' to see a list of available commands.");
        }
    }
}
