/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author panasoft
 */
public class Office {
    
    private ArrayList<Employee> employees = new ArrayList<>();
    
    public void generateEmployees(){
        int ecount = (int)Math.random()*94+6;
        
        for(int i = 0; i < ecount; i++){
            Employee e = new Employee();
//            if((int)Math.random()*5 == 0)
            Position p = new Position("1", 2);         
            e.addPosition(new Position(
                        Employee.POSITIONS[1 + Math.random()], 7));
            Employee.POSITIONS.
            employees.add(new Employee());
            
        }
        
    };
    
    
    
}
