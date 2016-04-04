package Data;

/**
 *
 * @author Jenn
 */
public class Course {
    
    private String ID;
    private String courseNum;
    private String name;
    private String type;
    private String[] features;
    private boolean[] days;
    private String[] startTimes;
    private String[] endTimes;
    private boolean IDc;
    private boolean courseNumc;
    private boolean namec;
    private boolean typec;
    private boolean featuresc;
    private boolean daysc;
    private boolean startTimesc;
    private boolean endTimesc;
    
    Course() { this(""); }
    
    Course(String n) {
        this.ID =
        this.courseNum =
        this.type = "";
        this.name = n;
        this.features = new String[DBManager.NUM_FEATURES];
        this.days = new boolean[DBManager.WEEKDAYS];
        this.startTimes = new String[DBManager.TIMESLOTS];
        this.endTimes = new String[DBManager.TIMESLOTS];
        for (int x=0;x<DBManager.WEEKDAYS;x++) { this.days[x] = false; }
        for (int x=0;x<DBManager.TIMESLOTS;x++) { 
            this.startTimes[x] = "";
            this.endTimes[x] = "";
        }
        IDc = 
        courseNumc = 
        namec = 
        typec = 
        featuresc = 
        daysc = 
        startTimesc = 
        endTimesc = false;
    }
    
    public boolean updateDB() {
        String query = "";
        
        if (IDc) {}
        if (courseNumc) {}
        if (namec) {}
        if (typec) {}
        if (featuresc) {}
        if (daysc) {}
        if (startTimesc) {}
        if (endTimesc) {}
        
        // Do Query
        return true;
    }
    
    public String getID() { return this.ID; }
    
    public String getName() { return this.name; }
    
    public boolean setName(String n) {
        this.name = n;
        return updateDB();
    }
    
    public String[] getFeatures() { return features; }
    
    public boolean setFeatures(int i, String f) {
        if (i < 0 || i >= DBManager.NUM_FEATURES) return false;
        this.features[i] = f;
        return updateDB();
    }
    
    public boolean[] getWeekdays() { return days; }
    
    public boolean setWeekdays(boolean[] d) {
        if (d.length != days.length) return false;
        days = d;
        return updateDB();
    }
    
    public String[] getStartTimes() { return startTimes; }
    
    public boolean setStartTimes(String[] st) {
        if (st.length != startTimes.length) return false;
        startTimes = st;
        return updateDB();
    }
    
    public String[] getEndTimes() { return endTimes; }
    
    public boolean setEndTimes(String[] et) {
        if (et.length != endTimes.length) return false;
        endTimes = et;
        return updateDB();
    }
}
