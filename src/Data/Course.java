package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Course class intended to be created and managed by DBManager
 * @author Jenn Goodman
 */
public class Course {
    
    //<editor-fold defaultstate="collapsed" desc="Fields">
    private Connection dbc;
    private Statement statement;
    private ResultSet result;
    
    private String ID;
    private String courseNumber;
    private String courseName;
    private String type;
    
    private String[] preferences;
    
    private int[] features;
    private int[] days;
    
    private int capacity;
    //</editor-fold>
    
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
        days = new int[7];
        features = new int[3];
        preferences = new String[3];
        try {
            statement = dbc.createStatement();
            if (i == null) {
                statement.executeUpdate(
                        "INSERT INTO course", 
                        Statement.RETURN_GENERATED_KEYS);
                result = statement.getGeneratedKeys();
                if (result.next())
                    ID = Integer.toString(result.getInt("CourseID"));
            }
            else { ID = i; }
            if ( ID != null ) {
                statement = dbc.createStatement();
                result = statement.executeQuery(
                        "SELECT * FROM course WHERE CourseID="+ID);
                if (result.next()) {
                    courseName = result.getString("CourseName");
                    courseNumber = result.getString("CourseNumber");
                    type = result.getString("CourseType");
                    capacity = result.getInt("Capacity");
                    days[0] = result.getInt("Monday");
                    days[1] = result.getInt("Tuesday");
                    days[2] = result.getInt("Wednesday");
                    days[3] = result.getInt("Thursday");
                    days[4] = result.getInt("Friday");
                    days[5] = result.getInt("Saturday");
                    days[6] = result.getInt("Sunday");
                    for (int f=0;f<3;f++)
                        features[f]=result.getInt("Feature"+(f+1));
                    for (int p=0;p<3;p++) 
                        preferences[p]=result.getString("Preference"+(p+1));}}
        } catch (SQLException e) { report(e); }
    }
    /**
     * @return unique ID number of course
     */
    public String getID() { return ID; }
    /**
     * @return current course courseName
     */
    public String getCourseName() { return courseName; }    
    /**
     * @param n new courseName of course
     * @return true if update successful
     */
    public boolean setCourseName(String n) {
        courseName = n;
        try {statement.executeUpdate("UPDATE course SET CourseName='"+n+"'");}
        catch (SQLException e) {return report(e);}
        return true;}
    /**
     * @return current features
     */
    public int[] getFeatures() { return features; }
    /**
     * @param f list of features to be set true/false
     * @return true if update successful
     */
    public boolean setFeatures(int[] f) {
        if (f.length == features.length) {
            features = f;
            try {for (int x=0 ; x<f.length ; x++) {
                statement.executeUpdate(
                            "UPDATE course SET Feature"+(x+1)+"='"+f[x]+"'");}}
            catch (SQLException e) {return report(e);}}
        return true;}
    /**
     * @return current days of course
     */
    public int[] getDays() { return days; }
    /**
     * @param d new list of days for course (Must be boolean[3])
     * @return true if successful
     */
    public boolean setDays(int[] d) {
        if (d.length == days.length) {
            days = d;
            try {statement.executeUpdate("UPDATE course SET Monday='"+d[0]+"'");
                statement.executeUpdate("UPDATE course SET Tuesday='"+d[1]+"'");
                statement.executeUpdate("UPDATE course SET Wednesday='"+d[2]+"'");
                statement.executeUpdate("UPDATE course SET Thursday='"+d[3]+"'");
                statement.executeUpdate("UPDATE course SET Friday='"+d[4]+"'");
                statement.executeUpdate("UPDATE course SET Saturday='"+d[5]+"'");
                statement.executeUpdate("UPDATE course SET Sunday='"+d[6]+"'");}
            catch (SQLException e) {return report(e);}}
        return true;}
    /**
     * @return current preferences
     */
    public String[] getPreferences() { return preferences; }
    /**
     * @param p new list of preferences (Must be array[3])
     * @return true if update successful
     */
    public boolean setPreferences(String[] p) {
        if (p.length == preferences.length) {
            preferences = p;
            try {for (int x=0 ; x<p.length ; x++) { statement.executeUpdate(
                        "UPDATE course SET Preference"+(x+1)+"='"+p[x]+"'");}}
            catch (SQLException e) {return report(e);}}
        return true;}
    /**
     * @return current course number
     */
    public String getCourseNumber() { return courseNumber; }
    /**
     * @param c new course number
     * @return true if update successful
     */
    public boolean setCourseNumber(String c) {
        courseNumber = c;
        try {statement.executeUpdate("UPDATE course SET CourseNumber='"+c+"'");}
        catch (SQLException e) {return report(e);}
        return true;}
    /**
     * @return current capacity of course
     */
    public int getCapacity() { return capacity; }
    /**
     * @param c new capacity of course
     * @return true if update successful
     */
    public boolean setCapacity(int c) {
        capacity = c;
        try {statement.executeUpdate("UPDATE course SET Capacity='"+c+"'");}
        catch (SQLException e) {return report(e);}
        return true;}
    /**
     * @return current type of course
     */
    public String getType() { return type; }
    /**
     * @param t type of course
     * @return true if update successful
     */
    public boolean setType(String t) {
        type = t;
        try {statement.executeUpdate("UPDATE course SET CourseNumber='"+t+"'");}
        catch (SQLException e) {return report(e);}
        return true;}
    /**
     * @param e SQLException to be reported
     * @return false in all cases.
     */
    private boolean report(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("SQL Error: " + e.getErrorCode());
        return false;}
    /**
     * @return Course object as String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] d = {"M","T","W","Th","F","Sat","Sun"};
        boolean dash = false;
        sb.append("CourseID: "); sb.append(ID);
        sb.append("\nCourseNumber: "); sb.append(courseNumber);
        sb.append("\nCourseName: "); sb.append(courseName);
        sb.append("\nCourseType: "); sb.append(type);
        sb.append("\nCapacity: "); sb.append(capacity);
        sb.append("\nWeekdays: ");
        for(int x=0;x<days.length;x++) {
            if (days[x]==1) {
                if (dash) {
                    sb.append("-"); sb.append(d[x]); }
                else { sb.append(d[x]); dash = true; } } }
        if (!dash) sb.append("None");
        for(int x=0;x<features.length;x++) {
            sb.append("\nFeature"); sb.append(x);
            if (features[x]==1) sb.append(": Yes");
            else sb.append(": No"); }
        for(int x=0;x<preferences.length;x++) {
            sb.append("\nPreference"); sb.append(x);
            sb.append(": "); sb.append(preferences[x]); }
        return sb.toString();
    }
}