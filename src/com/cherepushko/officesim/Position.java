/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

/**
 *
 * @author panasoft
 */
public class Position implements Comparable{
    private String position;
    private int salary;
    
    public String getPosition(){ return this.position;};
    public int getSalary(){ return this.salary;};

    public Position(String p, int s){
        this.position = p;
        this.salary = s;
    }

    @Override
    public int compareTo(Object o) {
        Position x = (Position) o; 
        if(x.getPosition() != this.position)
            return 1;
        return -1;
    }
}
