package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for connecting to a database and managing objects connected
 * to the records in the database
 * 
 * @author Jenn Goodman
 */
public class DBManager {
    //<editor-fold defaultstate="collapsed" desc="Fields">
    public static final int NUM_FEATURES = 3;
    public static final int WEEKDAYS = 7;
    
    private String connection;
    private String username;
    private String password;
    
    private int currentCourse;
    private int currentBuilding;
    private int currentRoom;
    
    private Connection dbc;
    private Statement statement;
    private ResultSet result;
    //</editor-fold>
    
    /**
     * Default Constructor - connects to the database and
     * manages objects tied to that connection.
     */
    DBManager() {
        connection = "ourcraft.ddns.net:3306/planner";
        username = "app1";
        password = "csc490";
        currentCourse = 0;
        currentBuilding = 0;
        currentRoom = 0;
        dbc = null;
        
        try {dbc = DriverManager.getConnection(
                                        "jdbc:mysql://"+connection+
                                        "?user="+username+
                                        "&password="+password);
            statement = dbc.createStatement(); }
        catch (SQLException e) { report(e); }}
    /**
     * Temporary debug function.
     * @return the current db connection object from DBManager.
     */
    public Connection getConnection() { return dbc; }
    /**
     * ** Do not close the connection if you are using other 
     * objects from the manager.
     * @return true if successfully closed database connection.
     */
    public boolean disconnect() {
        try { dbc.close(); }
        catch (SQLException e) { report(e); }
        return true; }
    /**
     * @return a new, empty course object tied to a unique
     * database id number with it's own connection to the database.
     */
    public Course newCourse() { return new Course(dbc); }
    /**
     * @return a new, empty building object tied to a unique
     * database id number with it's own connection to the database.
     */
    public Building newBuilding() { return new Building(dbc); }
    /**
     * @return a new, empty room object tied to a unique
     * database id number with it's own connection to the database.
     */
    public Room newRoom() { return new Room(dbc); }
    /**
     * @return a new, empty schedule object tied to a unique
     * database id number with it's own connection to the database.
     */
    public Schedule newSchedule() { return new Schedule(dbc); }
    /**
     * @return all course ID numbers from the current database
     * or null if empty.
     */
    public String[] getAllCourseIDs() {
        try {
            result = statement.executeQuery("SELECT CourseID FROM course");
            if (result.next())
                return (String[])result.getArray("CourseID").getArray();
        } catch (SQLException e) { report(e);}
        return null;}
    /**
     * @return all building ID numbers from the current database
     * or null if empty.
     */
    public String[] getAllBuildingIDs() {
        ArrayList<String> rm = new ArrayList();
    try {
        result = statement.executeQuery("SELECT BuildingID FROM building");
        while (result.next()) {rm.add(result.getString("BuildingID"));}
        String[] star = new String[rm.size()];
        for (int x=0; x < star.length; x++) {star[x] = rm.get(x);}
        return star;}
    catch (SQLException e) {report(e);}
        return null;}
    /**
     * @return all room ID numbers from the current database
     * or null if empty.
     */
    public String[] getAllRoomIDs() {
    try {
        result = statement.executeQuery("SELECT RoomID FROM room");
        if (result.next())
            System.out.println("Test");
            return (String[])result.getArray("RoomID").getArray();}
    catch (SQLException e) {report(e);}
        return null;}
    /**
     * @return next course object in order (begins at first row).
     */
    public Course getNextCourse() {
        String[] ids = this.getAllCourseIDs();
        if (ids != null && currentCourse < ids.length) {
            return new Course(dbc, ids[currentCourse++]); }
        return null;}
    /**
     * @return next building object in order (begins at first row).
     */
    public Building getNextBuilding() {
        String[] ids = this.getAllBuildingIDs();
        if(ids != null && currentBuilding < ids.length) {
            return new Building(dbc, ids[currentBuilding++]);}
        return null;}
    /**
     * @return next room object in order (begins at first row).
     */
    public Room getNextRoom() {
        String[] ids = this.getAllRoomIDs();
        if (currentRoom < ids.length) {
            return new Room(dbc, ids[currentRoom++]); }
        else { return null; }}
    /**
     * @param column label of column to be listed.
     * @return array of values as a String[].
     */
    public String[] getBuildingNames(String column) {
        try {
            result = statement.executeQuery("SELECT Name FROM building");
            return (String[])result.getArray("Name").getArray();
        } catch (SQLException e) { report(e); }
        return null;}
    /**
     * Reset building index to 0.
     */
    public void resetBuildingIndex() { currentBuilding = 0; }
    /**
     * Reset course index to 0.
     */
    public void resetCourseIndex() { currentCourse = 0; }
    /**
     * Reset room index to 0.
     */
    public void resetRoomIndex() { currentRoom = 0; }
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