package Data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Jenn
 */
public class Schedule {
    
    private String ID;
    private ArrayList<String[]> schedule;
    private int rIndex;
    private int cIndex;
    private int sLength;
    
    Schedule(Connection dbc) {
        ID = "";
        rIndex = -1;
        cIndex = 0;
        schedule = new ArrayList<>();
    }
    
    public boolean updateDB() {
        return true;
    }
    
    public String getID() { return ID; }    
    
    public String[] getNextRow() {
        if (rIndex >= schedule.size()) return null;
        rIndex++;
        return schedule.get(rIndex);
    }
    
    public ArrayList<String[]> getSchedule() { return schedule; }
    
    public void resetIndex() { rIndex = -1; }
    
    public boolean addRow(String[] e) {
        schedule.add(e);
        return updateDB();
    }
    
    public boolean removeCurrentRow() {
        if (rIndex >= schedule.size()) return false;
        schedule.remove(rIndex-1);
        return updateDB();
    }
}
