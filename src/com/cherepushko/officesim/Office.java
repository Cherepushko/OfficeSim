/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author panasoft
 */
public class Office {
    
    private ArrayList<Employee> employees = new ArrayList<>();
    private int eCount = 0;
    
    public static String[] POSITIONS = {"Director", "Manager", "Accountant",
                                    "Programmer", "Tester", "Cleaner"};
    
    public static HashMap<String, Integer> SALARY = 
                                    new HashMap<String, Integer>();
    
    public Office(){
        SALARY.put("Director", 25);
        SALARY.put("Manager", 18);
        SALARY.put("Accountant", 7);
        SALARY.put("Programmer", 15);
        SALARY.put("Tester", 12);
        SALARY.put("Cleaner", 6);
    };
    
    public void startSimulation(){};
    
    private void day(){};
    private void week(){};
    
    public void generateEmployees(){
        Random r = new Random();
        int ecount = 10 + r.nextInt(91); // 10 - 100 работников
        
        Employee e = new Employee();       
        e.addPosition(new Position(
                "Director" , SALARY.get("Director")));
        employees.add(e);
        
        e = null;
        
        e = new Employee();       
        e.addPosition(new Position(
                "Manager" , SALARY.get("Manager")));
        employees.add(e);
        
        e = null;
        
        e = new Employee();       
        e.addPosition(new Position(
                "Accountant" , SALARY.get("Accountant")));
        employees.add(e);
        
        e = null;
                
        for(int i = 0; i < ecount; i++){
            e = new Employee();
            int x = r.nextInt(POSITIONS.length);
            e.addPosition(new Position(POSITIONS[x], SALARY.get(POSITIONS[x])));
            employees.add(e);
            e = null;
        }
    }
    
    public void printEmployees(){
        int i = 1;
        for (Employee key: employees){
            System.out.println(i + ":: Name: " + key.getName()
                + "Surname: " + key.getSurname()
                + "Workerd Time: " + key.getWorkedTime()
                + "Positions: " + key.getPositions().toString());
            i++;
        }
        
    };
    
}
