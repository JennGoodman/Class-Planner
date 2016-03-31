package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class Course {
    public String name;
    public int pref1, pref2, pref3, capacity, type;
    public Course(String n, int p1, int p2, int p3, int c, int t){
        name = n;
        pref1 = p1;
        pref2 = p2;
        pref3 = p3;
        capacity = c;
        type = t;
    }
    public Course(){
        name = null;
        pref1 = 0;
        pref2 = 0;
        pref3 = 0;
        capacity = 0;
        type = 0;
    }
}
