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
public class Building {
    public int  numClassrooms;
    public String Name;
    
    public Building(int n, String s){
        numClassrooms = n;
        Name = s;
    }
    public Building(){
        numClassrooms = 0;
        Name = null;
    }
}
