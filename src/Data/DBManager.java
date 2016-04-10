package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for connecting to a database and managing objects connected
 * to the records in the database
 * 
 * @author Jenn Goodman
 */
public class DBManager {
    
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
    /**
     * Default Constructor - connects to the database and
     * manages objects tied to that connection
     */
    DBManager() {
        connection = "localhost:3306/planner";
        username = "app1";
        password = "csc490";
        currentCourse = 0;
        currentBuilding = 0;
        currentRoom = 0;
        dbc = null;
        
        try {
            dbc = DriverManager.getConnection(
                                        "jdbc:mysql://"+connection+
                                        "?user="+username+
                                        "&password="+password);
        } catch (SQLException e) {
            System.out.println("SQL Error in DBManager: " + connection);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }}
    /**
     * Temporary debug function
     * @return the current db connection object from DBManager
     */
    public Connection getConnection() { return dbc; }
    /**
     * ** Do not close the connection if you are using other 
     * objects from the manager
     * @return true if successfully closed database connection
     */
    public boolean disconnect() {
        try { dbc.close(); }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return true; }
    /**
     * @return a new, empty course object tied to a unique
     * database id number with it's own connection to the database
     */
    public Course newCourse() { return new Course(dbc); }
    /**
     * @return a new, empty building object tied to a unique
     * database id number with it's own connection to the database
     */
    public Building newBuilding() { return new Building(dbc); }
    /**
     * @return a new, empty room object tied to a unique
     * database id number with it's own connection to the database
     */
    public Room newRoom() { return new Room(dbc); }
    /**
     * @return a new, empty schedule object tied to a unique
     * database id number with it's own connection to the database
     */
    public Schedule newSchedule() { return new Schedule(dbc); }
    /**
     * @return all course ID numbers from the current database
     */
    public String[] getAllCourseIDs() {
        try {
            statement = dbc.createStatement();
            result = statement.executeQuery("SELECT CourseID FROM course");
        } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        }
        return new String[1]; // Replace
    }
    /**
     * @return all building ID numbers from the current database
     */
    public String[] getAllBuildingIDs() { return new String[1]; }
    /**
     * @return all room ID numbers from the current database
     */
    public String[] getAllRoomIDs() { return new String[1]; }
    /**
     * @return next course object in order (begins at first row)
     */
    public Course getNextCourse() { return new Course(dbc); }
    /**
     * @return next building object in order (begins at first row)
     */
    public Building getNextBuilding() { return new Building(dbc); }
    /**
     * @return next room object in order (begins at first row)
     */
    public Room getNextRoom() { return new Room(dbc); }
    /**
     * @param column label of column to be listed
     * @return array of values as a String[]
     */
    public String[] getByColumnName(String column) {
        return new String[1];
    }
    /**
     * @return true if db update is successful
     */
    public boolean update() { return true; }
}