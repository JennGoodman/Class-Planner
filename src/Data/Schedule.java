package Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Schedule class intended to be created and managed by DBManager.
 *
 * @author Jenn
 */
public class Schedule {

    //<editor-fold defaultstate="collapsed" desc="Fields">
    private Connection dbc;
    private Statement s;
    private ResultSet r;

    private String sID;
    private String sName;
    private int sScore;
    private Date sCreationDate;
    private Date sStart;
    private Date sEnd;
    private String cID;
    private String cNumber;
    private String cType;
    private int cCapacity;
    private int[] days;
    private int[] cFeat;
    private String[] cPrefs;
    private String bID;
    private String bName;
    private String rID;
    private String rType;
    private int rCapacity;
    private String rNumber;
    private int[] rFeat;
    //</editor-fold>

    /**
     * Constructor.
     *
     * @param d database connection.
     */
    Schedule(Connection d) {
        this(d, null);
    }

    /**
     * Constructor.
     *
     * @param d MySQL database connection string.
     * @param id schedule ID number for the record row.
     */
    Schedule(Connection d, String id) {
        dbc = d;
        days = new int[DBManager.WEEKDAYS];
        cPrefs = new String[DBManager.NUM_PREFERENCES];
        cFeat = new int[DBManager.NUM_FEATURES];
        rFeat = new int[DBManager.NUM_FEATURES];

        try {
            s = dbc.createStatement();
            if (id == null) {
                s.executeUpdate(
                        "INSERT INTO schedule values()",
                        Statement.RETURN_GENERATED_KEYS);
                r = s.getGeneratedKeys();
                if (r.next()) {
                    sID = r.getString(1);
                }
            } else {
                sID = id;
            }
            r = s.executeQuery(
                    "SELECT * FROM schedule WHERE ScheduleID=" + sID);
            if (r.next()) {
                sName = r.getString(2);
                sScore = r.getInt(3);
                sCreationDate = r.getDate(4);
                sStart = r.getDate(5);
                sEnd = r.getDate(6);
                cID = r.getString(7);
                cNumber = r.getString(8);
                cType = r.getString(9);
                cCapacity = r.getInt(10);
                days[0] = r.getInt(11);
                days[1] = r.getInt(12);
                days[2] = r.getInt(13);
                days[3] = r.getInt(14);
                days[4] = r.getInt(15);
                days[5] = r.getInt(16);
                days[6] = r.getInt(17);
                cFeat[0] = r.getInt(18);
                cFeat[1] = r.getInt(19);
                cFeat[2] = r.getInt(20);
                cPrefs[0] = r.getString(21);
                cPrefs[1] = r.getString(22);
                cPrefs[2] = r.getString(23);
                bID = r.getString(24);
                bName = r.getString(25);
                rID = r.getString(26);
                rType = r.getString(27);
                rCapacity = r.getInt(28);
                rNumber = r.getString(29);
                rFeat[0] = r.getInt(30);
                rFeat[1] = r.getInt(31);
                rFeat[2] = r.getInt(32);
            }
        } catch (SQLException e) {
            report(e);
        }
    }

    public String getScheduleID() {
        return sID;
    }

    public String getScheduleName() {
        return sName;
    }

    public void setScheduleName(String n) {
        sName = n;
    }

    public int getScheduleScore() {
        return sScore;
    }

    public void setScheduleScore(int s) {
        sScore = s;
    }

    public Date getScheduleCreationDate() {
        return sCreationDate;
    }

    public void setScheduleCreationDate(Date d) {
        sCreationDate = d;
    }

    public Date getScheduleStart() {
        return sStart;
    }

    public void setScheduleStart(Date d) {
        sStart = d;
    }

    public Date getScheduleEnd() {
        return sEnd;
    }

    public void setScheduleEnd(Date d) {
        sEnd = d;
    }

    public String getCourseID() {
        return cID;
    }

    public void setCourseID(String c) {
        cID = c;
    }

    public String getCourseNumber() {
        return cNumber;
    }

    public void setCourseNumber(String n) {
        cNumber = n;
    }

    public String getCourseType() {
        return cType;
    }

    public void setCourseType(String t) {
        cType = t;
    }

    public int getCourseCapacity() {
        return cCapacity;
    }

    public void setCourseCapacity(int c) {
        cCapacity = c;
    }

    public int[] getDays() {
        return days;
    }

    public boolean setDays(int[] d) {
        if (d.length == days.length) {
            days = d;
            return true;
        }
        return false;
    }

    public int[] getCourseFeatures() {
        return cFeat;
    }

    public boolean setCourseFeatures(int[] f) {
        if (f.length == cFeat.length) {
            cFeat = f;
            return true;
        }
        return false;
    }

    public String[] getCoursePreferences() {
        return cPrefs;
    }

    public boolean setCoursePreferences(String[] p) {
        if (p.length == cPrefs.length) {
            cPrefs = p;
            return true;
        }
        return false;
    }

    public String getBuildingID() {
        return bID;
    }

    public void setBuildingID(String b) {
        bID = b;
    }

    public String getBuildingName() {
        return bName;
    }

    public void setBuildingName(String n) {
        bName = n;
    }

    public String getRoomID() {
        return rID;
    }

    public void setRoomID(String r) {
        rID = r;
    }

    public String getRoomType() {
        return rType;
    }

    public void setRoomType(String t) {
        rType = t;
    }

    public int getRoomCapacity() {
        return rCapacity;
    }

    public void setRoomCapacity(int c) {
        rCapacity = c;
    }

    public String getRoomNumber() {
        return rNumber;
    }

    public void setRoomNumber(String n) {
        rNumber = n;
    }

    public int[] getRoomFeatures() {
        return rFeat;
    }

    public boolean setRoomFeatures(int[] f) {
        if (f.length == rFeat.length) {
            rFeat = f;
            return true;
        }
        return false;
    }

    public boolean updateDB() {
        try {
            s.executeUpdate("UPDATE schedule SET "
                    + "ScheduleName=" + sName
                    + "ScheduleScore=" + sScore
                    + "ScheduleCreationDate=" + sCreationDate
                    + "ScheduleStart=" + sStart
                    + "ScheduleEnd=" + sEnd
                    + "CourseID=" + cID
                    + "CourseNumber=" + cNumber
                    + "CourseType=" + cType
                    + "CourseCapacity=" + cCapacity
                    + "Monday=" + days[0]
                    + "Tuesday=" + days[1]
                    + "Wednesday=" + days[2]
                    + "Thursday=" + days[3]
                    + "Friday=" + days[4]
                    + "Saturday=" + days[5]
                    + "Sunday=" + days[6]
                    + "CourseFeature1=" + cFeat[0]
                    + "CourseFeature2=" + cFeat[1]
                    + "CourseFeature3=" + cFeat[2]
                    + "CoursePreference1=" + cPrefs[0]
                    + "CoursePreference2=" + cPrefs[1]
                    + "CoursePreference3=" + cPrefs[2]
                    + "BuildingID=" + bID
                    + "BuildingName=" + bName
                    + "RoomID=" + rID
                    + "RoomType=" + rType
                    + "RoomCapacity=" + rCapacity
                    + "RoomNumber=" + rNumber
                    + "RoomFeature1=" + rFeat[0]
                    + "RoomFeature2=" + rFeat[1]
                    + "RoomFeature3=" + rFeat[2]);
        } catch (SQLException e) {
            return report(e);
        }
        return true;
    }

    /**
     * @return Schedule object as string of values.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] d = {"M", "T", "W", "Th", "F", "Sat", "Sun"};
        boolean dash = false;

        sb.append("Schedule ID: ");
        sb.append(sID);
        sb.append(", Schedule Name: ");
        sb.append(sName);
        sb.append(", Schedule Score: ");
        sb.append(sScore);
        sb.append(", Schedule Creation Date: ");
        sb.append(sCreationDate);
        sb.append(", Schedule Start: ");
        sb.append(sStart);
        sb.append(", Schedule End: ");
        sb.append(sEnd);
        sb.append(", CourseID: ");
        sb.append(cID);
        sb.append(", Course Number: ");
        sb.append(cNumber);
        sb.append(", Course Type: ");
        sb.append(cType);
        sb.append(", Course Capacity: ");
        sb.append(cCapacity);
        sb.append(", Course Days: ");
        for (int x = 0; x < days.length; x++) {
            if (days[x] == 1) {
                if (dash) {
                    sb.append("-");
                    sb.append(d[x]);
                } else {
                    sb.append(d[x]);
                    dash = true;
                }
            }
        }
        for (int x = 0; x < cFeat.length; x++) {
            sb.append(", Feature");
            sb.append(x + 1);
            if (cFeat[x] == 1) {
                sb.append(": Yes");
            } else {
                sb.append(": No");
            }
        }
        for (int x = 0; x < cPrefs.length; x++) {
            sb.append(", Course Preference");
            sb.append(x + 1);
            sb.append(": ");
            sb.append(cPrefs[x]);
        }
        sb.append(", Building ID: ");
        sb.append(bID);
        sb.append(", Building Name: ");
        sb.append(bName);
        sb.append(", Room ID: ");
        sb.append(rID);
        sb.append(", Room Type: ");
        sb.append(rType);
        sb.append(", Room Capacity: ");
        sb.append(rCapacity);
        sb.append(", Room Number: ");
        sb.append(rNumber);
        for (int x = 0; x < rFeat.length; x++) {
            sb.append(", Feature");
            sb.append(x + 1);
            if (rFeat[x] == 1) {
                sb.append(": Yes");
            } else {
                sb.append(": No");
            }
        }
        return sb.toString();
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
