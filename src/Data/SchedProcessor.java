package Data;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SchedProcessor {

    private DBManager db;
    private Object[][] courses;
    private Object[][] rooms;
    private int score, eseatscore, bpref2score, bpref3score, bprefnoscore;
    private final double B_PREF_SCORE_WT = 1000;
    private final int E_SEAT_SCORE_WT = 10;
    private int[][] monTT, tueTT, wedTT, thuTT, friTT;
    private boolean isBooked;
    private String schedName;
    private ArrayList<Schedule> schedArr;

    public static void main(String[] args) throws SQLException {

        SchedProcessor test = new SchedProcessor();

        test.process();

        //System.out.println(test.monTT[0][3]);
    }

    public SchedProcessor() {
        db = new DBManager();
        courses = db.getCourseTable();
        rooms = db.getRoomTable();
        score = 1;
        eseatscore = 0;
        bpref2score = 0;
        bpref3score = 0;
        bprefnoscore = 0;
        monTT = new int[rooms.length][9];
        tueTT = new int[rooms.length][6];
        wedTT = new int[rooms.length][9];
        thuTT = new int[rooms.length][6];
        friTT = new int[rooms.length][9];
        isBooked = false;
        schedName = "";
        //schedArr = new ArrayList<Schedule>();

    }
    
        public SchedProcessor(String name) {
        db = new DBManager();
        courses = db.getCourseTable();
        rooms = db.getRoomTable();
        score = 1;
        eseatscore = 0;
        bpref2score = 0;
        bpref3score = 0;
        bprefnoscore = 0;
        monTT = new int[rooms.length][9];
        tueTT = new int[rooms.length][6];
        wedTT = new int[rooms.length][9];
        thuTT = new int[rooms.length][6];
        friTT = new int[rooms.length][9];
        isBooked = false;
        schedName = name;
        //schedArr = new ArrayList<Schedule>();

    }

    public void process() {

        //production of course permutations; Loop this num_courses^num_courses or until perfect schedule is found
        //for (int i = 0; (i < Math.pow(courses.length, courses.length)) || (score == 0); i++) {
        //score = 0;
        //System.out.println(rooms[11][4]);
        Collections.shuffle(Arrays.asList(courses));
        //schedule all courses

        //loop courses table
        for (int j = 0; j < courses.length; j++) {
            //reset isBooked flag
            isBooked = false;

            //loop rooms table
            for (int k = 0; (k < rooms.length) && isBooked == false; k++) {

                //if pref1 matches the building current room is in
                if (courses[j][15].toString().equals((rooms[k][4]).toString())) {
                    //System.out.println("found preferred building");
                    //find proper RoomType in building
                    if (courses[j][3].toString().equals((rooms[k][1]).toString())) {
                        //System.out.println("found proper RoomType");
                        //find room with capacity
                        if (Integer.parseInt((courses[j][4].toString())) <= Integer.parseInt((rooms[k][2].toString()))) {
                            //System.out.println(courses[j][4] + "   " + rooms[k][2]);
                            //System.out.println("found room with capacity");
                            //Normal or Auditorium Course
                            if (courses[j][3].toString().equals("0") || courses[j][3].toString().equals("1")) {
                                //System.out.println("found a normal or audtiorium class to be scheduled");
                                //MWF class
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found MWF class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName, courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                } //T/TH class
                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T/TH class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }
                            //Lab course
                            if (courses[j][3].toString().equals("2") && isBooked == false) {
                                //System.out.println("found a Lab course");
                                //M Lab
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found M Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Tues Lab

                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            //tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                                //W Lab
                                if (courses[j][7].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Wed Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < wedTT[0].length; l++) {
                                        if (wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Thursday Lab
                                if (courses[j][8].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Thurs Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < thuTT[0].length; l++) {
                                        if (thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            //thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][15].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                    }
                }

                //if pref2 matches the building current room is in
                if ((courses[j][16].toString().equals((rooms[k][4]).toString())) && isBooked == false) {
                    //System.out.println("found preferred building");
                    //find proper RoomType in building
                    if (courses[j][3].toString().equals((rooms[k][1]).toString())) {
                        //System.out.println("found proper RoomType");
                        //find room with capacity
                        if (Integer.parseInt((courses[j][4].toString())) <= Integer.parseInt((rooms[k][2].toString()))) {
                            //System.out.println(courses[j][4] + "   " + rooms[k][2]);
                            //System.out.println("found room with capacity");
                            //Normal or Auditorium Course
                            if (courses[j][3].toString().equals("0") || courses[j][3].toString().equals("1")) {
                                //System.out.println("found a normal or audtiorium class to be scheduled");
                                //MWF class
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found MWF class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                } //T/TH class
                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T/TH class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }
                            //Lab course
                            if (courses[j][3].toString().equals("2") && isBooked == false) {
                                //System.out.println("found a Lab course");
                                //M Lab
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found M Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Tues Lab

                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                                //W Lab
                                if (courses[j][7].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Wed Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < wedTT[0].length; l++) {
                                        if (wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Thursday Lab
                                if (courses[j][8].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Thurs Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < thuTT[0].length; l++) {
                                        if (thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][16].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                    }
                }

                //if pref3 matches the building current room is in
                if ((courses[j][17].toString().equals((rooms[k][4]).toString())) && isBooked == false) {
                    //System.out.println("found preferred building");
                    //find proper RoomType in building
                    if (courses[j][3].toString().equals((rooms[k][1]).toString())) {
                        //System.out.println("found proper RoomType");
                        //find room with capacity
                        if (Integer.parseInt((courses[j][4].toString())) <= Integer.parseInt((rooms[k][2].toString()))) {
                            //System.out.println(courses[j][4] + "   " + rooms[k][2]);
                            //System.out.println("found room with capacity");
                            //Normal or Auditorium Course
                            if (courses[j][3].toString().equals("0") || courses[j][3].toString().equals("1")) {
                                //System.out.println("found a normal or audtiorium class to be scheduled");
                                //MWF class
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found MWF class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                } //T/TH class
                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T/TH class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }
                            //Lab course
                            if (courses[j][3].toString().equals("2") && isBooked == false) {
                                //System.out.println("found a Lab course");
                                //M Lab
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found M Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Tues Lab

                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                                //W Lab
                                if (courses[j][7].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Wed Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < wedTT[0].length; l++) {
                                        if (wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Thursday Lab
                                if (courses[j][8].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Thurs Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < thuTT[0].length; l++) {
                                        if (thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), courses[j][17].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                    }
                }

                //if no preference or no match on preference available
                if (isBooked == false) {
                    //System.out.println("found preferred building");
                    //find proper RoomType in building
                    if (courses[j][3].toString().equals((rooms[k][1]).toString())) {
                        //System.out.println("found proper RoomType");
                        //find room with capacity
                        if (Integer.parseInt((courses[j][4].toString())) <= Integer.parseInt((rooms[k][2].toString()))) {
                            //System.out.println(courses[j][4] + "   " + rooms[k][2]);
                            //System.out.println("found room with capacity");
                            //Normal or Auditorium Course
                            if (courses[j][3].toString().equals("0") || courses[j][3].toString().equals("1")) {
                                //System.out.println("found a normal or audtiorium class to be scheduled");
                                //MWF class
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found MWF class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                } //T/TH class
                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T/TH class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+9), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }
                            //Lab course
                            if (courses[j][3].toString().equals("2") && isBooked == false) {
                                //System.out.println("found a Lab course");
                                //M Lab
                                if (courses[j][5].toString().equals("1")) {
                                    System.out.println("Found M Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < monTT[0].length; l++) {
                                        if (monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            monTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(monTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Tues Lab

                                if (courses[j][6].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found T Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < tueTT[0].length; l++) {
                                        if (tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(tueTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                                //W Lab
                                if (courses[j][7].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Wed Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < wedTT[0].length; l++) {
                                        if (wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(wedTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }
                                //Thursday Lab
                                if (courses[j][8].toString().equals("1") && isBooked == false) {
                                    System.out.println("Found Thurs Lab class");
                                    System.out.println(courses[j][0]);

                                    //find available time slot
                                    for (int l = 0; l < thuTT[0].length; l++) {
                                        if (thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] == 0) {
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 1] = Integer.parseInt((courses[j][0].toString()));
                                            thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l + 2] = Integer.parseInt((courses[j][0].toString()));
                                            System.out.println(thuTT[Integer.parseInt((courses[j][0].toString())) - 1][l]);
                                            addSched(schedName,courses[j][1].toString(), Integer.toString(l+8), Integer.toString(l+11), rooms[k][3].toString(), rooms[k][4].toString());
                                            isBooked = true;
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                    }
                }

                /**
                 * greedy algorithm here: get building preference1 for current
                 * course find closest fit room try to schedule at first
                 * available time slot if no time, move to next biggest room in
                 * building if no room in building available with time move to
                 * buildpref2 repeat when room found, schedule and update score
                 */
            }
        }
        //addSched("11", "9:00", "9:50" , "25", "Petty");
        //uploadSchedule();
    }
    
   
    
    public void uploadSchedule(){
        
        //Monday
        for(int i=0; i < monTT.length; i++){
            for(int j=0; j< monTT[0].length; j++){
                
                if(monTT[i][j] != 0){
                    System.out.println(i + " " + j);
                    System.out.println(monTT[i][j]);
                   //addSched(Integer.toString(monTT[i][j])); 
                    
                }
                
                
            }
        }

        //addSched("11", "9:00", "9:50" , "25", "Petty");
        
        
    }
    
    public void addSched(String name, String cname, String stime, String etime, String rnum, String bname ){
        
        DBManager dbm = new DBManager();
        Schedule s = dbm.newSchedule();
        s.setScheduleName(name);
        s.setCourseNumber(cname);
        s.setScheduleStart(stime);
        s.setScheduleEnd(etime);
        s.setRoomNumber(rnum);
        s.setBuildingName(bname);
        s.updateDB();

        
        
    }

}
