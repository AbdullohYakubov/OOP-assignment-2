package org.uob.a2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {
    private static GameState gs;
    
    public GameStateFileParser(){}

    public static GameState parse(String filename){
        try {
            FileReader reader = new FileReader("C:\\Users\\user\\Desktop\\OOP-assignment-2\\data\\game.txt");
            reader.read();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found!");
        } catch (IOException ioe) {
            System.out.println("File not found!");      
        }

        return gs;
    }
}
