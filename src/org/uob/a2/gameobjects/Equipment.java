package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {
   
    protected UseInformation useInformation;
    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

    @Override
    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    @Override
    public UseInformation getUseInformation(){
        return this.useInformation;
    }

    public String use(GameObject target, GameState gameState){
        for(Item item : gameState.getMap().getCurrentRoom().getItems()){
            item.setHidden(false);
        }

        for(Equipment equipment : gameState.getMap().getCurrentRoom().getEquipments()){
            equipment.setHidden(false);
        }

        this.getUseInformation().setUsed(true);

        if(this.getName().equalsIgnoreCase("key")){
            if(this.getUseInformation().isUsed()){
                gameState.setUsedKey(true);
            }
        }

        if(this.getName().equalsIgnoreCase("padlock key")){
            if(this.getUseInformation().isUsed()){
                gameState.setUsedPadlockKey(true);
            }
        }
        
        return this.useInformation.getMessage();
    }

    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
