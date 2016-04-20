package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SchedProcessor {

    private DBManager db;
    private Object[][] courses;
    private int score, eseatscore, bpref2score, bpref3score, bprefnoscore;
    private final double B_PREF_SCORE_WT = 1000;
    private final int E_SEAT_SCORE_WT = 10;
    
    
    

    public static void main(String[] args) {

    }

    public SchedProcessor() {
        db = new DBManager();
        courses = db.getCourseTable();
        score = 1;
        eseatscore = 0;
        bpref2score = 0;
        bpref3score = 0;
        bprefnoscore = 0;
        
    }

    public void process() {

        //production of course permutations; Loop this num_courses^num_courses or until perfect schedule is found
        for (int i = 0; (i < Math.pow(courses.length, courses.length)) || (score == 0); i++) {
            score = 0;
        
        Collections.shuffle(Arrays.asList(courses));
        //schedule all courses
        for (int j = 0; j < courses.length; i++) {

            System.out.println(courses[j][4]);

            /**
             * greedy algorithm here: get building preference1 for current course
             * find closest fit room try to schedule at first available time
             * slot if no time, move to next biggest room in building if no room
             * in building available with time move to buildpref2 repeat when
             * room found, schedule and update score
             */
        }
        }

    }

}
