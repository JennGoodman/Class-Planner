/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class Classroom {
    public int type, capacity, number, building;
    
    public Classroom(int t, int c, int n, int b){
        type = t;
        capacity = c;
        number = n;
        building = b;
    }
    public Classroom(){
        type = 0;
        capacity = 0;
        number = 0;
    }
}
