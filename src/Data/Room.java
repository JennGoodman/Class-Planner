package Data;

/**
 *
 * @author Jenn Goodman
 */
public class Room {
    
    private String ID;
    private String type;
    private String number;
    private String BuildingID;
    private String[] features;
    private String capacity;
    
    Room() { this(""); }
    
    Room(String n) {
        this.ID = "";
        this.type = "";
        this.number = "";
        this.BuildingID = "";
        this.capacity = "";
        this.features = new String[DBManager.NUM_FEATURES];
    }
    
    public String getID() { return this.ID; }
    
    public String getType() { return this.type; }
    
    public void setType(String t) { this.type = t; }
    
    public String getRoomNum() { return this.number; }
    
    public void setRoomNum(String n) { this.number = n; }
    
    public String getCapacity() { return this.capacity; }
    
    public void setCapacity(String n) { this.capacity = n; }
    
    public String getBuildingID() { return this.ID; }
    
    public void setBuildingID(String id) { this.ID = id; }
    
    public String[] getFeatures() { return features; }
    
    public boolean setFeatures(int i, String f) {
        if (i >= DBManager.NUM_FEATURES) return false;
        this.features[i-1] = f;
        return true;
    }
}
