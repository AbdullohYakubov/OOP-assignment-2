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
    private static GameState gameState = null;
    private static Player player;
    private static Map map;
    private static Room room;
    private static Exit exit;
    private static Feature feature;
    private static Container container;
    private static Equipment equipment;
    private static UseInformation useInformation;
    private static Item item;
    
    public GameStateFileParser(){}

    public static GameState parse(String filename){
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while((line = reader.readLine()) != null){
                line = line.trim();
                if(line.startsWith("player")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    player = new Player(args[1]);
                    gameState.setPlayer(player);
                }else if(line.startsWith("map")){
                    map = new Map();
                    gameState.setMap(map);
                }else if(line.startsWith("room")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    room = new Room(args[0], args[1], args[2], Boolean.parseBoolean(args[3]));
                    map.addRoom(room);
                }else if(line.startsWith("exit")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    exit = new Exit(args[0], args[1], args[2], args[3], Boolean.parseBoolean(args[4]));
                    room.addExit(exit);
                }else if(line.startsWith("feature")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    feature = new Feature(args[0], args[1], args[2], Boolean.parseBoolean(args[3]));
                    room.addFeature(feature);
                }else if(line.startsWith("container")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    container = new Container(args[0], args[1], args[2], Boolean.parseBoolean(args[3]));
                    room.addFeature(container);
                }else if(line.startsWith("equipment")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    useInformation = new UseInformation(false, args[4], args[5], args[6], args[7]);
                    equipment = new Equipment(args[0], args[1], args[2], Boolean.parseBoolean(args[3]), useInformation);
                    room.addEquipment(equipment);
                }else if(line.startsWith("item")){
                    int colonAt = line.indexOf(":");
                    String subLine = line.substring(colonAt + 1);
                    String[] args = subLine.split("[,]", 0);
                    item = new Item(args[0], args[1], args[2], Boolean.parseBoolean(args[3]));
                    room.addItem(item);
                }
            }
            
            reader.close();
        }catch (IOException ioe) {
            System.out.println(ioe.getMessage());      
        }

        return gameState;
    }
}
