/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author panasoft
 */
public class Employee implements IEmployee{

    private SortedSet<Position> positions = new TreeSet<Position>();
    
    private String name;
    private String surname;
    private int workedTime = 0;
    private int hours = 0;
    private boolean busy = false;
    
    public Employee() {
        
        this.name = "Name";
        this.surname = "Surmane";
        
    }
    
    public String getName(){ return this.name;};
    public String getSurname(){ return this.surname;};
    public int getWorkedTime(){ return this.workedTime;};
    public SortedSet getPositions(){ return positions;};
    
    public boolean isBusy(){ return busy; };
    
    @Override
    public int doWork(){
        return 0;
    };
    
    @Override
    public boolean addPosition(Position position){
        return this.positions.add(position);
    };
    
    
}
