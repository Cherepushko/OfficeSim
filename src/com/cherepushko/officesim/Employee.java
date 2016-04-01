/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author panasoft
 */
public class Employee implements IEmployee{

    public Employee() {}
    

    
    public static String[] POSITIONS = {"DIRECTOR", "PROGRAMMER", "DESIGNER", "TESTER", 
                    "MANAGER", "ACCOUNTANT", "CLEANER"};
    
    private SortedSet<Position> position = new TreeSet<Position>();
    private int hours = 0;
    private boolean busy = false;
    
    public boolean isBusy(){ return busy; };
    
    @Override
    public int doWork(){
        return 0;
    };
    
    @Override
    public boolean addPosition(Position position){
        return this.position.add(position);
    };
    
    
}
