package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Room class intended to be created and managed by DBManager.
 *
 * @author Jenn Goodman
 */
public class Room {

    //<editor-fold defaultstate="collapsed" desc="Fields">
    private Connection dbc;
    private Statement statement;
    private ResultSet result;

    private String ID;
    private String type;
    private String number;
    private String buildingID;
    private int capacity;

    private int[] features;
    //</editor-fold>

    /**
     * Constructor.
     *
     * @param d
     */
    Room(Connection d) {
        this(d, null);
    }

    /**
     * Constructor.
     *
     * @param d database connection agent.
     * @param id room id.
     */
    Room(Connection d, String id) {
        features = new int[DBManager.NUM_FEATURES];
        dbc = d;
        try {
            statement = dbc.createStatement();
            if (id == null) {
                statement.executeUpdate(
                        "INSERT INTO room VALUES ()",
                        Statement.RETURN_GENERATED_KEYS);
                result = statement.getGeneratedKeys();
                if (result.next()) {
                    ID = result.getString(1);
                }
            } else {
                ID = id;
            }
            result = statement.executeQuery(
                    "SELECT * FROM room WHERE RoomID=" + ID);
            if (result.next()) {
                type = result.getString("ClassType");
                capacity = result.getInt("Capacity");
                number = result.getString("RoomNum");
                buildingID = result.getString("BuildingID");
                for (int f = 0; f < 3; f++) {
                    features[f] = result.getInt("Feature" + (f + 1));
                }
            }
        } catch (SQLException e) {
            report(e);
        }
    }

    /**
     * @return room id.
     */
    public String getID() {
        return ID;
    }

    /**
     * @return type of room.
     */
    public String getType() {
        return type;
    }

    /**
     * @param t new type of room.
     * @return true if successful.
     */
    public boolean setType(String t) {
        try {
            statement.executeUpdate("UPDATE room SET ClassType='" + t + "' where RoomID='" + ID + "'");
            type = t;
        } catch (SQLException e) {
            return report(e);
        }
        return true;
    }

    /**
     * @return room number.
     */
    public String getRoomNum() {
        return number;
    }

    /**
     * @param n new room number.
     * @return true if successful.
     */
    public boolean setRoomNum(String n) {
        try {
            statement.executeUpdate("UPDATE room SET RoomNum='" + n + "' where RoomID='" + ID + "'");
            number = n;
        } catch (SQLException e) {
            return report(e);
        }
        return true;
    }

    /**
     * @return room capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param c new room capacity.
     * @return true if successful.
     */
    public boolean setCapacity(int c) {
        try {
            statement.executeUpdate("UPDATE room SET Capacity='" + c + "' where RoomID='" + ID + "'");
            capacity = c;
        } catch (SQLException e) {
            return report(e);
        }
        return true;
    }

    /**
     * @return rooms assigned building ID.
     */
    public String getBuildingID() {
        return buildingID;
    }

    /**
     * @param id new building ID.
     * @return true if successful.
     */
    public boolean setBuildingID(String id) {
        try {
            statement.executeUpdate("UPDATE room SET BuildingID='" + id + "' where RoomID='" + ID + "'");
            buildingID = id;
        } catch (SQLException e) {
            return report(e);
        }
        return true;
    }

    /**
     * @return room features.
     */
    public int[] getFeatures() {
        return features;
    }

    /**
     * @param f new room features.
     * @return true if successful.
     */
    public boolean setFeatures(int[] f) {
        if (f.length == features.length) {
            features = f;
            try {
                for (int x = 0; x < f.length; x++) {
                    statement.executeUpdate(
                            "UPDATE room SET Feature" + (x + 1) + "='" + f[x] + "' where RoomID='" + ID + "'");
                }
            } catch (SQLException e) {
                return report(e);
            }
        }
        return true;
    }

    /**
     * @return Room object as string of values.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Room ID: ");
        sb.append(ID);
        sb.append(", Type: ");
        sb.append(type);
        sb.append(", Capacity: ");
        sb.append(capacity);
        sb.append(", Room Number: ");
        sb.append(number);
        sb.append(", Building ID: ");
        sb.append(buildingID);
        for (int x = 0; x < features.length; x++) {
            sb.append(", Feature");
            sb.append(x + 1);
            if (features[x] == 1) {
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
