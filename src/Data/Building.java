package Data;

import java.sql.Connection;

/**
 *
 * @author Jenn
 */
public class Building {
    
    private Connection dbc;
    private String ID;
    private String name;
    private int index;
    
    Building(Connection dbc) {
        ID = "";
        index = 0;
        name = "";
    }
    
    public String getID() { return ID; }
    
    public String getName() { return name; }
    
    public void setName(String n) { name = n; }
    
    public Room[] getAllRooms() { return new Room[1]; }
    
    public Room getNextRoom() { return new Room(dbc); }
    
    public boolean reset() { index = 0;
        return true;
    }
}
