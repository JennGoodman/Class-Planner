package Data;

/**
 *
 * @author Jenn
 */
public class Building {
    
    private String ID;
    private String name;
    private int index;
    
    Building() { this(""); }
    
    Building(String n) {
        this.ID = "";
        this.index = 0;
        this.name = n;
    }
    
    public String getID() { return this.ID; }
    
    public String getName() { return this.name; }
    
    public void setName(String n) { this.name = n; }
    
    public Room[] getAllRooms() {
        return new Room[1];
    }
    
    public Room getNextRoom() {
        return new Room();
    }
    
    public boolean reset() {
        this.index = 0;
        return true;
    }
}
