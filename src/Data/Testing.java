package Data;

/**
 * * @author Jenn
 */
public class Testing {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Building bldg;
        Course crse;
        bldg=dbm.getNextBuilding();
        crse=dbm.getNextCourse();
        System.out.println("-- Building .toString() --");
        while (bldg != null) {
            System.out.println(bldg.toString());
            bldg=dbm.getNextBuilding();
        }
        System.out.println("-- Course .toString() --");
        while (crse != null) {
            System.out.println(crse.toString());
            crse=dbm.getNextCourse();
        }
        System.out.println("-- Get building table --");
        Object[][] tab = dbm.getBuildingTable();
        for (Object[] o : tab) {
            System.out.print("Building ID  : " + o[0]);
            System.out.println(", Building Name: " + o[1]);
        }
        System.out.println("Get room table: ");
        tab = dbm.getRoomTable();
        for (Object[] o : tab) {
            System.out.print("Room ID  : " + o[0]);
            System.out.print(", Class Type: " + o[1]);
            System.out.print(", Capacity: " + o[2]);
            System.out.print(", Room Number: " + o[3]);
            System.out.println("Building ID: " + o[4]);
        }
        System.out.println("-- Get course table --");
        tab = dbm.getCourseTable();
        for (Object[] o : tab) {
            System.out.print("Course ID  : " + o[0]);
            System.out.print(", Course Number: " + o[1]);
            System.out.print(", Course Name: " + o[2]);
            System.out.print(", Course Type: " + o[3]);
            System.out.print(", Capacity: " + o[4]);
            System.out.print(", Monday: " + o[5]);
            System.out.print(", Tuesday: " + o[6]);
            System.out.print(", Wednesday: " + o[7]);
            System.out.print(", Thursday: " + o[8]);
            System.out.print(", Friday: " + o[9]);
            System.out.print(", Saturday: " + o[10]);
            System.out.print(", Sunday: " + o[11]);
            System.out.print(", Feature 1: " + o[12]);
            System.out.print(", Feature 2: " + o[13]);
            System.out.print(", Feature 3: " + o[14]);
            System.out.print(", Preference 1: " + o[15]);
            System.out.print(", Preference 2: " + o[16]);
            System.out.println(", Preference 3: " + o[17]);
        }
    }
}
