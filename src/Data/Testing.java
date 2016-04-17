package Data;

import java.util.Random;

/**
 * * @author Jenn
 */
public class Testing {

    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Building bld;
        Course crs;
        Room rm;
        while ((bld = dbm.getNextBuilding()) != null) {
            System.out.println(bld);
        }
        while ((rm = dbm.getNextRoom()) != null) {
            System.out.println(rm);
        }
        while ((crs = dbm.getNextCourse()) != null) {
            System.out.println(crs);
        }
        
        // Create Dummy Rooms
//        Random rand = new Random();
//        int x = 0;
//        do {
//        rm = dbm.newRoom();
//        rm.setType(String.valueOf(rand.nextInt(3)));
//        rm.setCapacity(rand.nextInt(200)+5);
//        rm.setRoomNum(String.valueOf(rand.nextInt(400)+1));
//        rm.setBuildingID(String.valueOf(rand.nextInt(20)+1));
//        rm.setFeatures(new int[] {
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2)});
//        x++;
//        } while (x < 100);
        
        // Create Dummy Buildings
//        Building bldg = dbm.newBuilding();
//        Random rand = new Random();
//        for (int x = 1; x < 20; x++) {
//            bldg.setName("Test Building " + x);
//            bldg = dbm.newBuilding();
//        }
        
        
        // Create Dummy Courses
//        Course course = dbm.newCourse();
//        Random rand = new Random();
//        course.setCourseNumber("CSC " + String.valueOf(rand.nextInt(600)+100));
//        course.setCourseName("Test Course");
//        course.setType(String.valueOf(rand.nextInt(2)+1));
//        course.setCapacity(rand.nextInt(150)+1);
//        course.setDays(new int[] {
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2)});
//        course.setFeatures(new int[] {
//            rand.nextInt(2),
//            rand.nextInt(2),
//            rand.nextInt(2)});
//        course.setPreferences(new String[] {
//            String.valueOf(rand.nextInt(4)),
//            String.valueOf(rand.nextInt(4)),
//            String.valueOf(rand.nextInt(4))});
//        while((course = dbm.getNextCourse()) != null) {
//            System.out.println(course.toString());
//        }
    }
}
