package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Chop extends Command{
    private String item;
    private String equipment;

    public Chop(String item, String equipment){
        this.item = item;
        this.equipment = equipment;
    }

    @Override
    public String execute(GameState gameState) {
        if(this.item.equals("watermelon") && this.equipment.equals("guillotine")){
            if(gameState.getMap().getCurrentRoom().getName().equals("Guillotine Area")){
                if(gameState.getPlayer().hasItem("watermelon")){
                    Equipment equipment = gameState.getMap().getCurrentRoom().getEquipmentByName("key");
                    Item item = gameState.getPlayer().getItem("watermelon");
                    gameState.getPlayer().getInventory().remove(item);
                    equipment.setHidden(false);
                    gameState.getPlayer().addScore(10);
                    return "You chop " + this.item + ". Something falls to the ground...";
                }

                return "You do not have " + this.item;
            }
    
            return "You are not in the right room to chop the " + this.item;
        }

        return "Cannot chop " + this.item + " on " + this.equipment;
    }   
}