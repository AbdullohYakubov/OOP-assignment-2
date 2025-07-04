package org.uob.a2.gameobjects;

/**
 * Represents the current state of the game, including the map and the player.
 * 
 * <p>
 * The game state contains all necessary information about the game's progress, such as
 * the player's status and the state of the game map.
 * </p>
 */
public class GameState {
   
    private Map map;
    private Player player;
    private boolean usedKey;
    private boolean usedPadlockKey;

    /**
     * Returns a string representation of the game state, including the map and player details.
     *
     * @return a string describing the game state
     */

    public GameState(){}

    public GameState(Map map, Player player){
        this.map = map;
        this.player = player;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setUsedKey(boolean usedKey){
        this.usedKey = usedKey;
    }

    public void setUsedPadlockKey(boolean usedPadlockKey){
        this.usedPadlockKey = usedPadlockKey;
    }

    public Map getMap(){
        return this.map;
    }

    public Player getPlayer(){
        return this.player;
    }

    public boolean getUsedKey(){
        return this.usedKey;
    }

    public boolean getUsedPadlockKey(){
        return this.usedPadlockKey;
    }

    @Override
    public String toString() {
        return "GameState {" +
               "map=" + (map != null ? map.toString() : "null") + ", " +
               "player=" + (player != null ? player.toString() : "null") +
               '}';
    }
}
