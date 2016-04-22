/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Jenn
 */
public class Test {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Schedule s = dbm.newSchedule();
        s.setCourseID("12");
        s.setScheduleStart("yo");
        s.updateDB();
    }
}
