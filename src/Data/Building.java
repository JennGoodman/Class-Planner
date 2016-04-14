package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Building class intended to be created and managed by DBManager.
 * @author Jenn
 */
public class Building {
    //<editor-fold defaultstate="collapsed" desc="Fields">
    private Connection dbc;
    private Statement statement;
    private ResultSet result;
    
    private String ID;
    private String name;
    
    private int roomIndex;
    //</editor-fold>
    
    /**
     * Default Constructor
     * @param d database connection object.
     */
    Building(Connection d) { this(d, null); }
    /**
     * Default Constructor
     * @param d database connection object.
     * @param id building id.
     */
    Building (Connection d, String id) {
        dbc = d;
        roomIndex = 0;
        try {
            statement = dbc.createStatement();
            if (id == null) { 
                statement.executeUpdate(
                            "INSERT INTO building",
                            Statement.RETURN_GENERATED_KEYS);
                result = statement.getGeneratedKeys();
                if (result.next())
                    ID=Integer.toString(result.getInt("BuildingID"));
            }
            else ID = id;
            result = statement.executeQuery(
                    "SELECT * FROM building WHERE BuildingID="+ID);
            if (result.next()) name = result.getString("Name");}
        catch (SQLException e) {report(e);}
    }
    /**
     * @return Building id as String.
     */
    public String getID() { return ID; }
    /**
     * @return Building name as String.
     */
    public String getName() { return name; }
    /**
     * @param n building name.
     * @return True if successful.
     */
    public boolean setName(String n) {
        name = n;
        try {statement.executeUpdate("UPDATE course SET Name='"+n+"'");}
        catch (SQLException e) { return report(e);}
        return true;}
    /**
     * @return Array of all building room objects.
     */
    public Room[] getAllRooms() {
        ArrayList<String> myRooms = new ArrayList();
        Room[] rm = null;
        String[] ids;
        try {result = statement.executeQuery(
                    "SELECT RoomID FROM room WHERE BuildingID='"+ID+"'");
            while (result.next()) {myRooms.add(result.getString("RoomID"));}
            ids = (String[])myRooms.toArray();
            rm = new Room[ids.length];
            for (int i=0; i<rm.length; i++) {
                rm[i] = new Room(dbc, ids[i]);}}
        catch (SQLException e) {report(e);}
        return rm;}
    /**
     * @return Room as Room object.
     */
    public Room getNextRoom() {
        Room rm = null;
        try {result = statement.executeQuery(
                    "SELECT RoomID FROM room WHERE BuildingID='"+ID+"'");
            for (int i=0; i<roomIndex; i++){result.next();}
            if (result.next())
                rm = new Room(dbc, result.getString("RoomID"));
            roomIndex++;}
        catch (SQLException e) {report(e);}
        return rm;}
    /**
     * @return True if successful.
     */
    public boolean resetRoomIndex() {
        roomIndex = 0;
        return (roomIndex == 0); }
    
    @Override
    public String toString() {
        ArrayList<String> rm = new ArrayList();
        try {result = statement.executeQuery(
                    "SELECT RoomID FROM room WHERE BuildingID='"+ID+"'");
            while (result.next()) {rm.add(result.getString("RoomID"));}}
        catch (SQLException e) {report(e);}
        return "Building ID: "+ID+", Building Name: "+name+", "+"Rooms: "+rm.toString();}
    /**
     * @param e SQLException to be reported
     * @return false in all cases.
     */
    private boolean report(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        return false;}
}
