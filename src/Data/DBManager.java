package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for connecting to a database and managing objects connected to the
 * records in the database.
 *
 * @author Jenn Goodman
 */
public class DBManager {

    //<editor-fold defaultstate="collapsed" desc="Fields">
    public static final int NUM_FEATURES = 3;
    public static final int WEEKDAYS = 7;
    public static final int NUM_PREFERENCES = 3;

    private String connection;
    private String username;
    private String password;

    private int currentCourse;
    private int currentBuilding;
    private int currentRoom;
    private int currentScheduleRow;

    private Connection dbc;
    private Statement statement;
    private ResultSet result;
    //</editor-fold>

    /**
     * Default Constructor - connects to the database and manages objects tied
     * to that connection.
     */
    DBManager() {
        connection = "ourcraft.ddns.net:3306/planner";
        username = "app1";
        password = "csc490";
        currentCourse = 0;
        currentBuilding = 0;
        currentRoom = 0;
        currentScheduleRow = 0;
        dbc = null;

        try {
            dbc = DriverManager.getConnection(
                    "jdbc:mysql://" + connection
                    + "?user=" + username
                    + "&password=" + password);
            statement = dbc.createStatement();
        } catch (SQLException e) {
            report(e);
        }
    }

    /**
     * ** Do not close the connection if you are using other objects from the
     * manager.
     *
     * @return true if successfully closed database connection.
     */
    public boolean disconnect() {
        try {
            dbc.close();
        } catch (SQLException e) {
            report(e);
        }
        return true;
    }

    /**
     * @return a new, empty course object tied to a unique database id number
     * with it's own connection to the database.
     */
    public Course newCourse() {
        return new Course(dbc);
    }

    /**
     * @return a new, empty building object tied to a unique database id number
     * with it's own connection to the database.
     */
    public Building newBuilding() {
        return new Building(dbc);
    }

    /**
     * @return a new, empty room object tied to a unique database id number with
     * it's own connection to the database.
     */
    public Room newRoom() {
        return new Room(dbc);
    }

    /**
     * @return a new, empty schedule object tied to a unique database id number
     * with it's own connection to the database.
     */
    public Schedule newSchedule() {
        return new Schedule(dbc);
    }

    /**
     * @return all course ID numbers from the current database or null if empty.
     */
    public String[] getAllCourseIDs() {
        ArrayList<String> ids = new ArrayList();
        try {
            result = statement.executeQuery("SELECT CourseID FROM course ORDER BY CourseID");
            while (result.next()) {
                ids.add(result.getString("CourseID"));
            }
            String[] star = new String[ids.size()];
            for (int x = 0; x < star.length; x++) {
                star[x] = ids.get(x);
            }
            return star;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }

    /**
     * @return all building ID numbers from the current database or null if
     * empty.
     */
    public String[] getAllBuildingIDs() {
        ArrayList<String> rm = new ArrayList();
        try {
            result = statement.executeQuery("SELECT BuildingID FROM building ORDER BY BuildingID");
            while (result.next()) {
                rm.add(result.getString("BuildingID"));
            }
            String[] star = new String[rm.size()];
            for (int x = 0; x < star.length; x++) {
                star[x] = rm.get(x);
            }
            return star;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }

    /**
     * @return all room ID numbers from the current database or null if empty.
     */
    public String[] getAllRoomIDs() {
        ArrayList<String> ids = new ArrayList();
        try {
            result = statement.executeQuery("SELECT RoomID FROM room ORDER BY RoomID");
            while (result.next()) {
                ids.add(result.getString("RoomID"));
            }
            String[] star = new String[ids.size()];
            for (int x = 0; x < star.length; x++) {
                star[x] = ids.get(x);
            }
            return star;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }

    /**
     * @return next course object in order (begins at first row).
     */
    public Course getNextCourse() {
        String[] ids = this.getAllCourseIDs();
        if (ids != null && currentCourse < ids.length) {
            return new Course(dbc, ids[currentCourse++]);
        }
        return null;
    }

    /**
     * @return next building object in order (begins at first row).
     */
    public Building getNextBuilding() {
        String[] ids = this.getAllBuildingIDs();
        if (ids != null && currentBuilding < ids.length) {
            return new Building(dbc, ids[currentBuilding++]);
        }
        return null;
    }

    /**
     * @return next room object in order (begins at first row).
     */
    public Room getNextRoom() {
        String[] ids = this.getAllRoomIDs();
        if (currentRoom < ids.length) {
            return new Room(dbc, ids[currentRoom++]);
        } else {
            return null;
        }
    }
    
    /**
     * @return Array of unique schedule names.
     */
    public String[] getScheduleNames() {
        String[] names = null;
        ArrayList<String> temp = new ArrayList();
        try {
            result = statement.executeQuery(
                    "SELECT DISTINCT ScheduleName FROM schedule");
            while (result.next()) {
                temp.add(result.getString(1));
            }
            names = new String[temp.size()];
            for(int x=0; x< names.length; x++) {
                names[x] = temp.get(x);
            }
        }
        catch (SQLException e) {
            report(e);
        }
        return names;
    }
    
    /**
     * @param name name of schedule.
     * @return Schedule object containing the current record.
     */
    public Schedule getNextSchedule(String name) {
        try {
            result = statement.executeQuery(
                    "SELECT ScheduleID FROM schedule WHERE ScheduleName='" + name + "'");
            for(int x=0; x <= currentScheduleRow; x++ ) {
                result.next();
            }
            return new Schedule(dbc, result.getString(1));
        }
        catch (SQLException e) {
            report(e);
            return null;
        }
    }

    /**
     * @param column label of column to be listed.
     * @return array of values as a String[].
     */
    public String[] getBuildingNames(String column) {
        String[] names = null;
        ArrayList<String> temp = new ArrayList();
        try {
            result = statement.executeQuery("SELECT Name FROM building");
            while(result.next()) {
                temp.add(result.getString(1));
            }
            names = new String[temp.size()];
            for (int x=0; x<names.length; x++) {
                names[x] = temp.get(x);
            }
        } catch (SQLException e) {
            report(e);
        }
        return names;
    }

    /**
     * @return Object[][] of entire db table.
     */
    public Object[][] getBuildingTable() {
        Object[][] table;
        ArrayList<Object[]> tempList = new ArrayList();
        Object[] tempRow;
        try {
            result = statement.executeQuery("SELECT * FROM building");
            while (result.next()) {
                tempRow = new Object[2];
                tempRow[0] = result.getInt("BuildingID");
                tempRow[1] = result.getString("Name");
                tempList.add(tempRow);
            }
            table = new Object[tempList.size()][2];
            for (int x = 0; x < tempList.size(); x++) {
                table[x] = tempList.get(x);
            }
            return table;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }

    /**
     * @return Object[][] of entire db table.
     */
    public Object[][] getCourseTable() {
        Object[][] table;
        ArrayList<Object[]> tempList = new ArrayList();
        Object[] tempRow;
        try {
            result = statement.executeQuery("SELECT * FROM course");
            while (result.next()) {
                tempRow = new Object[18];
                tempRow[0] = result.getInt("CourseID");
                tempRow[1] = result.getString("CourseNumber");
                tempRow[2] = result.getString("CourseName");
                tempRow[3] = result.getString("CourseType");
                tempRow[4] = result.getInt("Capacity");
                tempRow[5] = result.getInt("Monday");
                tempRow[6] = result.getInt("Tuesday");
                tempRow[7] = result.getInt("Wednesday");
                tempRow[8] = result.getInt("Thursday");
                tempRow[9] = result.getInt("Friday");
                tempRow[10] = result.getInt("Saturday");
                tempRow[11] = result.getInt("Sunday");
                tempRow[12] = result.getInt("Feature1");
                tempRow[13] = result.getInt("Feature2");
                tempRow[14] = result.getInt("Feature3");
                tempRow[15] = result.getString("Preference1");
                tempRow[16] = result.getString("Preference2");
                tempRow[17] = result.getString("Preference3");
                tempList.add(tempRow);
            }
            table = new Object[tempList.size()][];
            for (int x = 0; x < tempList.size(); x++) {
                table[x] = tempList.get(x);
            }
            return table;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }

    /**
     * @return Object[][] of entire db table.
     */
    public Object[][] getRoomTable() {
        Object[][] table;
        ArrayList<Object[]> tempList = new ArrayList();
        Object[] tempRow;
        try {
            result = statement.executeQuery("SELECT * FROM room");
            while (result.next()) {
                tempRow = new Object[5];
                tempRow[0] = result.getInt("RoomID");
                tempRow[1] = result.getInt("ClassType");
                tempRow[2] = result.getInt("Capacity");
                tempRow[3] = result.getInt("RoomNum");
                tempRow[4] = result.getInt("BuildingID");
                tempList.add(tempRow);
            }
            table = new Object[tempList.size()][];
            for (int x = 0; x < tempList.size(); x++) {
                table[x] = tempList.get(x);
            }
            return table;
        } catch (SQLException e) {
            report(e);
        }
        return null;
    }
    
    /**
     * Returns an array of non-featured Courses for a specified BuildingID
     * sorted by their capacity.
     * 
     * Features must be a 3 element array of 0's and 1's.
     * @param bid BuildingID preference of Courses to include.
     * @return Array of Course objects.
     */
    public Object[] getGeneralCourses(String bid, int[] feat) {
        ArrayList<Course> c = new ArrayList();
        ArrayList<Course> r = new ArrayList();
        boolean match;
        Course course;
        String[] prefs;
        int[] tfeat;
        int x;
        try {
            result = statement.executeQuery(
                    "SELECT * FROM planner.course_capacity");
            while (result.next()) {
                c.add(new Course(dbc, result.getString("CourseID")));
            }
            while (!c.isEmpty()) {
                match = false;
                course = c.get(0);
                tfeat = course.getFeatures();
                prefs = course.getPreferences();
                x = 0;
                for (x=0; x < 3; x++) {
                    if(prefs[x].equalsIgnoreCase(bid)) {
                        match = true;
                    }
                }
                x = 0;
                while (match && x < 3) {
                    match = (tfeat[x] == feat[x]);
                    x++;
                }
                if (r.contains(course) || !match) {
                    c.remove(0);
                }
                else {
                    r.add(c.remove(0));
                }
            }
        } catch (SQLException e) {
            report(e);
        }
        return r.toArray();
    }

    /**
     * Reset building index to 0.
     */
    public void resetBuildingIndex() {
        currentBuilding = 0;
    }

    /**
     * Reset course index to 0.
     */
    public void resetCourseIndex() {
        currentCourse = 0;
    }

    /**
     * Reset room index to 0.
     */
    public void resetRoomIndex() {
        currentRoom = 0;
    }
    
    /**
     * Reset schedule row index to 0.
     */
    public void resetScheduleRowIndex() {
        currentScheduleRow = 0;
    }

    /**
     * @param e SQLException to be reported.
     * @return false in all cases.
     */
    private boolean report(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        return false;
    }
}
