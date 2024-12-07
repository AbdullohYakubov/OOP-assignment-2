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

        for(Token token : tokens){
            if(token.getTokenType().name().equals("DROP")){
                String item = tokens.get(1).getValue();
                return new Drop(item);
            }
            else if(token.getTokenType().name().equals("GET")){
                String item = tokens.get(1).getValue();
                return new Get(item);
            }
            else if(token.getTokenType().name().equals("HELP")){
                if(tokens.size() == 1){
                    return new Help(null);
                }else if(tokens.size() == 2){
                    String item = tokens.get(1).getValue();
                    return new Help(item);
                }
            }
            else if(token.getTokenType().name().equals("LOOK")){
                String item = tokens.get(1).getValue();
                return new Look(item);
            }
            else if(token.getTokenType().name().equals("MOVE")){
                String item = tokens.get(1).getValue();
                return new Move(item);
            }
            else if(token.getTokenType().name().equals("QUIT")){
                return new Quit();
            }
            else if(token.getTokenType().name().equals("STATUS")){
                String item = tokens.get(1).getValue();
                return new Status(item);
            }else if(token.getTokenType().name().equals("USE")){
                String item = tokens.get(1).getValue();
                String target = tokens.get(3).getValue();
                return new Use(item, target);
            }
        }

        return null;
    }
}
