package Data;
import java.sql.DriverManager;

/**
 *
 * @author Jenn Goodman
 */
public class DBManager {
    
    public static final int NUM_FEATURES = 3;
    public static final int WEEKDAYS = 7;
    public static final int TIMESLOTS = 7;
    
    private String connection;
    private String username;
    private String password;
    private boolean connected;
    private int port;
    private int currentCourse;
    private int currentBuilding;
    private int currentRoom;
    
    private DriverManager DBH;
    
    DBManager(String connect, String user, String pass) {
        this.connection = connect;
        this.username = user;
        this.password = pass;
        
        if (connect()) {
            connected = true;
        }
    }
    
    public boolean configure(String connect) {
        if (connect.isEmpty()) return false;
        this.connection = connect;
        return true;
    }
    
    public boolean connect() {
        //Do SQL Connect
        return true;
    }
    
    public boolean disconnect() {
        // Do SQL Disconnect
        return true;
    }
    
    public Course newCourse(String name) {
        return new Course(name);
    }
    
    public Building newBuilding() {
        return new Building();
    }
    
    public Room newRoom() {
        return new Room();
    }
    
    public Schedule newSchedule() {
        return new Schedule();
    }
    
    public String[] getAllCourseIDs() {
        return new String[1];
    }
    
    public String[] getAllBuildingIDs() {
        return new String[1];
    }
    
    public String[] getAllRoomIDs() {
        return new String[1];
    }
    
    public Course getNextCourse() {
        return new Course();
    }
    
    public Building getNextBuilding() {
        return new Building();
    }
    
    public Room getNextRoom() {
        return new Room();
    }
    
    public boolean update() {
        return true;
    }
    
}
