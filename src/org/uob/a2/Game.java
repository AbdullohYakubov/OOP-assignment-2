package org.uob.a2;

import java.util.Scanner;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {
    private static Scanner scr;
    private static Parser parser;
    private static Tokeniser tokeniser;
    private static GameState gameState;

    public Game(){}
    public static void main(String[] args){
        setup();
        start();
    }

    public static void setup(){
        scr = new Scanner(System.in);
        parser = new Parser();
        tokeniser = new Tokeniser();
        gameState = GameStateFileParser.parse("C:\\Users\\user\\Desktop\\OOP-assignment-2\\data\\game.txt");
    }

    public static void start(){
        gameState.getMap().setCurrentRoom("r10");
        System.out.println("Loading game...\nGame loaded successfully.");
        Look lookCommand = new Look("room");
        System.out.println(lookCommand.execute(gameState));
        // System.out.println(gameState.getMap().getCurrentRoom().getDescription());
        String userInput = "";

        while(!userInput.equals("quit")){
            try{
                userInput = scr.nextLine();
            }catch(IllegalArgumentException iae){
                System.out.println("Invalid input! Type 'help' to see the list of available commands!");
            }
            Tokeniser tokeniser = new Tokeniser();
            tokeniser.sanitise(userInput);
            tokeniser.tokenise(userInput);

            Parser parser = new Parser();
            try {
                Command command = parser.parse(tokeniser.getTokens());
                turn(command);
            } catch (CommandErrorException cee) {
                System.out.println("Invalid Command!");
            }
        }

        scr.close();
    }

    public static void turn(Command command){
        System.out.println(command.execute(gameState));
    }
}
