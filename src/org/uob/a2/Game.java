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
    public static void main(String[] args){
        Feature mainDoor = new Feature("0", "main door", "This is the only exit in the house. The door is locked in three ways: door lock, padlock, and planks.", false);
        
        Feature fridge = new Feature("1", "fridge", "An old fridge with a worn and slightly rusted exterior with faded colors in the corner of the room", false);

        Feature kennel = new Feature("3", "kennel", "A kennel tucked in the corner whose door secured tightly with a screw lock", false);

        Feature bed = new Feature("4", "bed", "A bed that has a bleak, unsettling appearance. It's old and made of wood that's chipped and splintered in places.", false);

        Container container = new Container("2", "jar", "A cracked jar rests on the shelves, along with other ominous items.", false);

        Item watermelon = new Item("0", "watermelon", "an item that can be found from inside the fridge and might have something inside", true);

        Item padlockKey = new Item("1", "padlock key", "a key that you can find from inside the kennel and can use to unlock the padlock", true);

        Item mainKey = new Item("2", "main key", "a key that unlock the main door", true);

        Item code = new Item("3", "code", "code written on a peice of paper that is stuck on somewhere", true);
        
        // System.out.println(mainDoor);
        // System.out.println(fridge);
        // System.out.println(container);
        // System.out.println(kennel);
        // System.out.println(bed);

        UseInformation screwdriverUseInformation = new UseInformation(false, "open", "kennel", "padlock key", "You just found a padlock key!");

        UseInformation hammerUseInformation = new UseInformation(false, "break", "main door", "", "You just broke the planks! You are one step closer to escape!");

        Equipment screwdriver = new Equipment("0", "screwdriver", "a tool that you can use to open the kennel", true, screwdriverUseInformation);

        Equipment hammer = new Equipment("1", "hammer", "a tool that you can use to break the planks", false, hammerUseInformation);

        Room foyer = new Room("0", "Foyer", "This is the foyer of Granny's house. This is the only exit in the house. The door is locked in three ways: door lock, padlock, and planks.", false);
        Room kitchen = new Room("1", "Kitchen", "This is Granny's kitchen where she cooks her favourite human blood soup and keeps it in the fridge.", false);
        Room diningRoom = new Room("2", "Dining Room", "This is Granny's dining room where she enjoys the soup. There is nothing really special about this room.", false);
        Room livingRoom = new Room("3", "Living Room", "Dim, eerie room with cracked walls, dusty floors, shadowed corners, and a chilling, unsettling atmosphere throughout.", false);
        Room bedroom1 = new Room("4", "Bedroom 1", "A dark, cramped bedroom with peeling wallpaper and creaky floors; Granny lies asleep on her bed, an object beside her.", false);
        Room restroom = new Room("5", "Restroom", "A claustrophobic, grimy restroom with dark stains on cracked tiles, echoing a faint stench of blood. Granny occasionally stumbles in, retching, and you're forced to feign sleep as she passes through your room.", false);
        Room bedroom2 = new Room("6", "Bedroom 2", "A bleak, stifling room heavy with despair, where Granny confines her hostages. Shadows cling to every corner, amplifying the eerie silence.", false);
        Room library = new Room("7", "Library", "A dim, oppressive library filled with dust and silence, its air thick with age and forgotten secrets.", false);
        Room storageRoom = new Room("8", "Storage Room", "A cramped, shadowy storage room with dusty shelves lining the walls, holding various objects shrouded in gloom and mystery.", false);
        Room parking = new Room("9", "Parking", "This is the parking where Granny keeps her broken car", false);
        Room guillotine = new Room("10", "Guillotine Area", "A chilling, oppressive space where a rusted guillotine stands, waiting for its grim purpose after days of captivity.", false);
        Room kennelArea = new Room("11", "Kennel Area", "A dark, grimy area with a kennel tucked in the corner, its door secured tightly with a screw lock.", false);

        
        Map map = new Map();
        map.addRoom(foyer);
        map.addRoom(kitchen);
        map.addRoom(diningRoom);
        map.addRoom(livingRoom);
        map.addRoom(bedroom1);
        map.addRoom(restroom);
        map.addRoom(bedroom2);
        map.addRoom(library);
        map.addRoom(storageRoom);
        map.addRoom(parking);
        map.addRoom(guillotine);
        map.addRoom(kennelArea);

        System.out.println(foyer);
        
        foyer.addFeature(mainDoor);
        foyer.addItem(mainKey);
        foyer.addFeature(mainDoor);

        System.out.println(foyer.getFeature("0"));
    }

}
