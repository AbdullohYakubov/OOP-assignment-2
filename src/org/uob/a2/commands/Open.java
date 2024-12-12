package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Open extends Command{
    private String target;

    public Open(String target){
        this.target = target;
    }

    @Override
    public String execute(GameState gameState) {
        if(this.target.equalsIgnoreCase("fridge")){
            if(gameState.getMap().getCurrentRoom().getName().equals("Kitchen")){
                gameState.getMap().getCurrentRoom().getItemByName("watermelon").setHidden(false);
                gameState.getPlayer().addScore(10);
                return "You open " + this.target;
            }

            return "You are not in the right room to open the fridge!";
        }

        return "Cannot open " + this.target;
    }
}