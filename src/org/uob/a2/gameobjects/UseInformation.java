package org.uob.a2.gameobjects;

/**
 * Represents information about how an object can be used in the game.
 * 
 * <p>
 * This class stores details about the usage of an object, such as whether it has
 * already been used, the type of action it performs, the target of the action,
 * the result of the action, and any associated message.
 * </p>
 */
public class UseInformation {
    private boolean isUsed;
    private String action;
    private String target;
    private String result;
    private String message;

    public UseInformation(boolean isUsed, String action, String target, String result, String message){
        this.isUsed = isUsed;
        this.action = action;
        this.target = target;
        this.result = result;
        this.message = message;
    }

    public void setUsed(boolean isUsed){
        this.isUsed = isUsed;
    }

    public void setAction(String action){
        this.action = action;
    }

    public void setTarget(String target){
        this.target = target;
    }

    public void setResult(String result){
        this.result = result;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getAction(){
        return this.action;
    }

    public String getTarget(){
        return this.target;
    }

    public String getResult(){
        return this.result;
    }

    public String getMessage(){
        return this.message;
    }

    public boolean isUsed(){
        return this.isUsed; // Checks if the object has already been used.
    }

    /**
     * Returns a string representation of the usage information, including all attributes.
     *
     * @return a string describing the usage information
     */
    @Override
    public String toString() {
        return "UseInformation{" +
                "isUsed=" + isUsed +
                ", action='" + action + '\'' +
                ", target='" + target + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
