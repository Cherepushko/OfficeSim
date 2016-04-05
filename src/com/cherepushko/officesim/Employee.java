/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author panasoft
 */
public class Employee implements IEmployee{

    private SortedSet<Position> positions = new TreeSet<Position>();
    private Schedule schedule = new Schedule(this);
    private ArrayList<String>   incommingCommands = new ArrayList<String>();
    
    private Position currentPosition;
    private String  name;
    private String  surname;
    private int     workedTime = 0;
    private int     hours = 0;
    private boolean busy = false;
    
    public Employee() {
        
        this.name = Integer.toString(this.hashCode(), 36).toUpperCase();
        this.surname = Integer.toString(this.hashCode(), 16).toUpperCase();
        
    }
    
    public String getName(){ return this.name;};
    public String getSurname(){ return this.surname;};
    public int getWorkedTime(){ return this.workedTime;};
    public SortedSet<Position> getPositions(){ return positions;};
    public Schedule getSchedule(){ return this.schedule;};
    
    public boolean isBusy(){ return busy; };
    
    @Override
    public int doWork(){
        if(this.currentPosition.getHoursToWork() == 0) return 0;
        this.currentPosition.iWorkedOneHour();
        if(this.currentPosition.getHoursToWork() == 0)
            this.busy = false;        
        return 1;
    };
    
    private Position getPosition(String s){
    
        for(Position p : positions){
            if(s.equals(p.getPosition()))
                return p;
        }
        return null;    
    };
    
    @Override
    public void selectCommand() {
        Random r = new Random();
        if(this.busy) return;
        Position p = 
                this.getPosition(Office.positionFromCommand.get("писать код"));
        if(p != null){
            p.newTask(1 + r.nextInt(1));
            this.busy = true;
        }         
    }
    
    @Override
    public void command (String s){
        this.incommingCommands.add(s);
    };
    
    @Override
    public boolean addPosition(Position position){
        return this.positions.add(position);
    }; 
}
