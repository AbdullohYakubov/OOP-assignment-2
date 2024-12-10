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
        // if(useInformation.isUsed()){
        //     return "The item has already been used";
        // }

        // if(target instanceof Feature){
        //     if(gameState.getMap().getCurrentRoom().hasFeature(target.getName())){
        //         for(Item item : gameState.getMap().getCurrentRoom().getItems()){
        //             item.setHidden(false);
        //         }
        //     }
        // }

        for(Item item : gameState.getMap().getCurrentRoom().getItems()){
            item.setHidden(false);
        }

        this.getUseInformation().setUsed(true);
        return this.useInformation.getMessage();
    }

    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
