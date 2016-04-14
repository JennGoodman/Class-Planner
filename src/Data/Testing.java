package Data;

/**
 *
 * @author Jenn
 */
public class Testing {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Building bldg;
        Course crse;
        bldg=dbm.getNextBuilding();
        crse=dbm.getNextCourse();
        while (bldg != null && crse != null) {
            System.out.println(bldg.toString());
            System.out.println(crse.toString());
            bldg=dbm.getNextBuilding();
            crse=dbm.getNextCourse();
        }
    }
}
