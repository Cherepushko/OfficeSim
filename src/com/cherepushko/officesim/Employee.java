/**
 *
 * @author Panas Cherepushko
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
    private ArrayList<Order>   incommingCommands = new ArrayList<Order>();
    
    private Position currentPosition;
    private String  name;
    private String  surname;
    private int     hours = 0;
    private boolean busy = false;
    
    public Employee() {
        
        this.name = Integer.toString(this.hashCode(), 36).toUpperCase();
        this.surname = Integer.toString(this.hashCode(), 16).toUpperCase();
        
    }
    
    public String getName(){ return this.name;};
    public String getSurname(){ return this.surname;};
    public int getWorkedTime(){ 
        int count = 0;
        for(Position p : this.positions)
            count += p.getWorkedHours();
        return count;
    };
    public SortedSet<Position> getPositions(){ return positions;};
    public Schedule getSchedule(){ return this.schedule;};
    
    public boolean isBusy(){ return busy; };
    
    @Override
    public int doWork(){
        this.selectCommand();
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
        Order temp;
        for(int j = 0 ; j < this.incommingCommands.size(); j++){
           for(int i = 0 ; i < this.incommingCommands.size() - j; i++){
               if(this.incommingCommands.get(i).getPriority() 
                       > this.incommingCommands.get(i).getPriority()){
                    temp = this.incommingCommands.get(i);
                    this.incommingCommands.set(i,this.incommingCommands.get(i+1)) ;
                    this.incommingCommands.set((i+1),temp);
                }
           }
        }
        this.currentPosition = (Position)this.getPositions().toArray()[0];
        if(this.currentPosition != null){
            this.currentPosition.newTask(1 + r.nextInt(1));
            this.busy = true;
        }         
    }
    
    @Override
    public void command (Order s){
        for(Position p : this.positions){
            if(p.getPosition().equals(s.getPosition())){
                this.incommingCommands.add(s);
                return;
            }
        }
    };
    
    @Override
    public boolean addPosition(Position position){
        return this.positions.add(position);
    }; 
}
