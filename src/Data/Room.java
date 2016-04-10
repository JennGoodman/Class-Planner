package Data;

import java.sql.Connection;

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
    
    Room(Connection dbc) {
        ID = "";
        type = "";
        number = "";
        BuildingID = "";
        capacity = "";
        features = new String[DBManager.NUM_FEATURES];
    }
    
    public String getID() { return ID; }
    
    public String getType() { return type; }
    
    public void setType(String t) { type = t; }
    
    public String getRoomNum() { return number; }
    
    public void setRoomNum(String n) { number = n; }
    
    public String getCapacity() { return capacity; }
    
    public void setCapacity(String n) { capacity = n; }
    
    public String getBuildingID() { return ID; }
    
    public void setBuildingID(String id) { ID = id; }
    
    public String[] getFeatures() { return features; }
    
    public boolean setFeatures(int i, String f) {
        if (i >= DBManager.NUM_FEATURES) return false;
        features[i-1] = f;
        return true;
    }
}
