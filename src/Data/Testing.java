package Data;

/**
 *
 * @author Jenn
 */
public class Testing {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Course myCourse = new Course(dbm.getConnection(), "1");
    }
}
