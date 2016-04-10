package Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Course class intended to be created and managed by DBManager
 * 
 * @author Jenn Goodman
 */
public class Course {
    
    private Connection dbc;
    private Statement statement;
    private ResultSet result;
    private String ID;
    private String courseNumber;
    private String name;
    private String type;
    private boolean[] preferences;
    private boolean[] features;
    private boolean[] days;
    private int capacity;
    private Date startTime;
    private Date endTime;
    private boolean co = false;
    private boolean na = false;
    private boolean ty = false;
    private boolean pr = false;
    private boolean fe = false;
    private boolean da = false;
    private boolean cp = false;
    private boolean st = false;
    private boolean et = false;
    /**
     * Default Constructor
     * @param c MySQL database connection
     */
    Course(Connection c) { this(c, null); }
    
    /**
     * Complete Constructor
     * @param c MySQL database connection string
     * @param i row ID number to connect this object to
     */
    Course(Connection c, String i) {
        dbc = c;
        try {
            statement = dbc.createStatement();
            if (i == null) {
                statement.executeUpdate(
                        "INSERT INTO course", 
                        Statement.RETURN_GENERATED_KEYS);
                result = statement.getGeneratedKeys();
                if (result.next()) {
                    ID = Integer.toString(result.getInt("CourseID")); }
            }
            else { ID = i; }

            if ( ID != null ) {
                String query = "SELECT * FROM course WHERE CourseID=" + ID;
                statement = dbc.createStatement();
                result = statement.executeQuery(query);
                result.next();

                name = result.getString("Name");
                courseNumber = result.getString("CourseNumber");
                type = result.getString("CourseType");
                capacity = result.getInt("Capacity");
                startTime = result.getDate("StartTime");
                endTime = result.getDate("EndTime");
                days[0] = result.getBoolean("Monday");
                days[1] = result.getBoolean("Tuesday");
                days[2] = result.getBoolean("Wednesday");
                days[3] = result.getBoolean("Thursday");
                days[4] = result.getBoolean("Friday");
                days[5] = result.getBoolean("Saturday");
                days[6] = result.getBoolean("Sunday");
                for (int f=0;f<3;f++) {
                    features[f]=result.getBoolean("Features"+(f+1)); }
                for (int p=0;p<3;p++) {
                    preferences[p]=result.getBoolean("Preference"+(p+1)); }
            }
        } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        }
    }
    /**
     * @return unique ID number of course
     */
    public String getID() {
        return ID;
    }
    /**
     * @return current course name
     */
    public String getName() {
        return name;
    }    
    /**
     * @param n new name of course
     * @return true if update successful
     */
    public boolean setName(String n) {
        name = n;
        return update();
    }
    /**
     * @return current features
     */
    public boolean[] getFeatures() {
        return features;
    }
    /**
     * @param f list of features to be set true/false
     * @return true if update successful
     */
    public boolean setFeatures(boolean[] f) {
        if (f.length == features.length) features = f;
        return update();
    }
    /**
     * @return current days of course
     */
    public boolean[] getDays() {
        return days;
    }
    /**
     * @param d new list of days for course (Must be boolean[3])
     * @return true if successful
     */
    public boolean setDays(boolean[] d) {
        if (d.length == days.length) days = d;
        return update();
    }
    /**
     * @return current start time of course
     */
    public Date getStartTime() {
        return startTime;
    }
    /**
     * @param st new start time for course
     * @return true if successful
     */
    public boolean setStartTimes(Date st) {
        startTime = st;
        return update();
    }
    /**
     * @return current end time of course
     */
    public Date getEndTime() {
        return endTime;
    }    
    /**
     * @param et new end time for course
     * @return true if successful
     */
    public boolean setEndTime(Date et) {
        endTime = et;
        return update();
    }    
    /**
     * @return current preferences
     */
    public boolean[] getPreferences() {
        return preferences;
    }
    /**
     * @param p new list of preferences (Must be array[3])
     * @return true if update successful
     */
    public boolean setPreferences(boolean[] p) {
        if (p.length == preferences.length) preferences = p;
        else { return false; }
        return update();
    }
    /**
     * @return current course number
     */
    public String getCourseNumber() {
        return courseNumber;
    }
    /**
     * @param c new course number
     * @return true if update successful
     */
    public boolean setCourseNumber(String c) {
        courseNumber = c;
        return update();
    }
    /**
     * @return current capacity of course
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * @param c new capacity of course
     * @return true if update successful
     */
    public boolean setCapacity(int c) {
        capacity = c;
        return update();
    }
    /**
     * @return current type of course
     */
    public String getType() {
        return type;
    }
    /**
     * @param t type of course
     * @return true if update successful
     */
    public boolean setType(String t) {
        type = t;
        return update();
    }
    /**
     * @return true if update successful
     */
    private boolean update() {
        
        StringBuilder sb =  new StringBuilder();
        
        if (co) sb.append(courseNumber);
        if (cp) sb.append(capacity);
        if (da) {
            sb.append(days[0]);
            sb.append(days[1]);
            sb.append(days[2]);
        }
        if (et) sb.append(endTime);
        if (fe){
            sb.append(features[0]);
            sb.append(features[1]);
            sb.append(features[2]);
        }
        if (na) sb.append(name);
        if (pr) {
            sb.append(preferences[0]);
            sb.append(preferences[1]);
            sb.append(preferences[2]);
        }
        if (st) sb.append(startTime);
        if (ty) sb.append(type);
        
        String query = sb.toString();
        
        try {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        }
        return false;
    }
}