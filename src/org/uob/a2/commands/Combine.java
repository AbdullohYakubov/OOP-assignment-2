package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Combine extends Command{
    private String item_1;
    private String item_2;

    public Combine(String item_1, String item_2){
        this.item_1 = item_1;
        this.item_2 = item_2;
    }

    @Override
    public String execute(GameState gameState) {
        if(gameState.getPlayer().hasItem(item_1) && gameState.getPlayer().hasItem(item_2)){
            Item item_1 = gameState.getPlayer().getItem(this.item_1);
            Item item_2 = gameState.getPlayer().getItem(this.item_2);

            if(((this.item_1.equals("planks") && this.item_2.equals("rope")) || (this.item_2.equals("planks") && this.item_1.equals("rope")))){
                gameState.getPlayer().getInventory().remove(item_1);
                gameState.getPlayer().getInventory().remove(item_2);
                UseInformation hookedStickUseInfo = new UseInformation(false, "get", "c1", "eq3", "You use the hooked stick to topple the jar from the shelf. Something inside it falls to the floor...");
                Equipment hookedStick = new Equipment("eq5", "hooked stick", "Hooked stick perfect for toppling or retrieving hidden items.", false, hookedStickUseInfo);
                gameState.getPlayer().addEquipment(hookedStick);
                gameState.getPlayer().addScore(10);
                return this.item_1 + " has been combined with " + this.item_2 + " to make " + hookedStick.getName();
            }
        } else{
            return "Cannot combine " + this.item_1 + " with " + this.item_2;
        }

        return "";
    }
}